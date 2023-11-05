package io.atha.bbasic.awt;

import static io.atha.libbababasic.error.RuntimeError.ErrorCode.GRAPHICS_ERROR;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import io.atha.libbababasic.error.RuntimeError;

public final class AWTGraphicsUtil {

    public static final int BUFFER_NUM_FRONT = 0;
    public static final int BUFFER_NUM_BACK1 = 1;
    static final int MAX_WIDTH = 4000;
    static final int MAX_HEIGHT = 4000;
    static final String PUT_XOR = "XOR";
    private static final int REFRESH_MILLIS = 40;
    private static final int KEY_BUFFER_SIZE = 16;
    private static final String PUT_OR = "OR";
    private static final String PUT_AND = "AND";
    private static final String PUT_PSET = "PSET";
    private static final String PUT_MIX = "MIX";

    private static void copyRect(int[] srcArray, int srcx, int srcy, int srcWidth,
                                 int[] dstArray, int dstx, int dsty, int dstWidth,
                                 int copyW, int copyH) {
        int srcVerticalOffset = srcy * srcWidth;
        int dstVerticalOffset = dsty * dstWidth;
        for (int yi = srcy; yi < srcy + copyH; yi++) {
            System.arraycopy(srcArray, srcVerticalOffset + srcx,
                    dstArray, dstVerticalOffset + dstx,
                    copyW);
            srcVerticalOffset += srcWidth;
            dstVerticalOffset += dstWidth;
        }
    }

    private static long createPoint(int x, int y) {
        return (((long) x) << 32) | y;
    }

    private static int getX(long point) {
        return (int) (point >>> 32);
    }

    private static int getY(long point) {
        return (int) (point & 0xffffffffL);
    }

    private static void iterativeFloodFill(
            BufferedImage image, int px, int py, Color fill, Color boundary) {
        var visited = new HashSet();
        var queue = new LinkedList<Long>();
        queue.push(createPoint(px, py));

        while (!queue.isEmpty()) {
            long point = queue.pop();
            int x = getX(point);
            int y = getY(point);
            if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight() || visited.contains(point)) {
                continue;
            }

            var atXY = new Color(image.getRGB(x, y));
            if (atXY.getRed() == boundary.getRed()
                    && atXY.getGreen() == boundary.getGreen()
                    && atXY.getBlue() == boundary.getBlue()) {
                continue;
            }

            if (atXY.getRed() == fill.getRed()
                    && atXY.getGreen() == fill.getGreen()
                    && atXY.getBlue() == fill.getBlue()) {
                continue;
            }

            visited.add(point);
            image.setRGB(x, y, fill.getRGB());
            if (x > 0) {
                var nextC = new Color(image.getRGB(x - 1, y));
                if (nextC.getRed() != fill.getRed()
                        || nextC.getGreen() != fill.getGreen()
                        || nextC.getBlue() != fill.getBlue()) {
                    queue.push(createPoint(x - 1, y));
                }
            }
            if (x < image.getWidth() - 1) {
                var nextC = new Color(image.getRGB(x + 1, y));
                if (nextC.getRed() != fill.getRed()
                        || nextC.getGreen() != fill.getGreen()
                        || nextC.getBlue() != fill.getBlue()) {
                    queue.push(createPoint(x + 1, y));
                }
            }
            if (y > 0) {
                var nextC = new Color(image.getRGB(x, y - 1));
                if (nextC.getRed() != fill.getRed()
                        || nextC.getGreen() != fill.getGreen()
                        || nextC.getBlue() != fill.getBlue()) {
                    queue.push(createPoint(x, y - 1));
                }
            }
            if (y < image.getHeight() - 1) {
                var nextC = new Color(image.getRGB(x, y + 1));
                if (nextC.getRed() != fill.getRed()
                        || nextC.getGreen() != fill.getGreen()
                        || nextC.getBlue() != fill.getBlue()) {
                    queue.push(createPoint(x, y + 1));
                }
            }
        }
    }

    private interface Canvas {
        BufferedImage getFront();

        BufferedImage getBack1();

        Graphics2D getFrontGraphics2D();

        Graphics2D getBackGraphics2D();

        default BufferedImage get(int bufferNumber) {
            if (bufferNumber == BUFFER_NUM_FRONT) {
                return getFront();
            } else if (bufferNumber == BUFFER_NUM_BACK1) {
                return getBack1();
            } else {
                throw new InternalError("Bad bufferNumber: " + bufferNumber);
            }
        }

        void prepareToRender();
    }

    static class BasicFrame extends JFrame {

        private final DrawingCanvas drawingCanvas;

        BasicFrame(String title,
                   int w, int h,
                   int iw, int ih,
                   boolean autoRepaint,
                   boolean doubleBuffer) {
            drawingCanvas = init(title, w, h, iw, ih, autoRepaint, doubleBuffer);
        }

        DrawingCanvas getDrawingCanvas() {
            return drawingCanvas;
        }

        private DrawingCanvas init(
                String title,
                int w, int h,
                int iw, int ih,
                boolean autoRepaint, boolean doubleBuffer) {
            var mouseState = new BasicMouseState(this);

            var drawingCanvas = new DrawingCanvas(
                    w, h, iw, ih, REFRESH_MILLIS, KEY_BUFFER_SIZE, mouseState, doubleBuffer);
            add(drawingCanvas);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    drawingCanvas.stopRefresh();
                }
            });
            addKeyListener(new InkeyDlrKeyListener(drawingCanvas));

            setTitle(title);
            pack();
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            if (autoRepaint) {
                drawingCanvas.startRefresh();
            }
            return drawingCanvas;
        }
    }

    private static final class SingleImageCanvas implements Canvas {
        private final BufferedImage image;
        private final Graphics2D graphics;

        SingleImageCanvas(int imageWidth, int imageHeight) {
            this.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
            this.graphics = (Graphics2D) image.getGraphics();
        }

        @Override
        public BufferedImage getBack1() {
            return image;
        }

        @Override
        public BufferedImage getFront() {
            return image;
        }

        @Override
        public Graphics2D getFrontGraphics2D() {
            return graphics;
        }

        @Override
        public Graphics2D getBackGraphics2D() {
            return graphics;
        }

        @Override
        public void prepareToRender() {
        }
    }

    private static final class DoubleBufferedImageCanvas implements Canvas {
        private final BufferedImage[] images;
        private final Graphics2D[] graphics;
        private int imageIndex;

        DoubleBufferedImageCanvas(int imageWidth, int imageHeight) {
            this.images = new BufferedImage[2];
            this.images[0] = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
            this.images[1] = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
            this.graphics = new Graphics2D[2];
            this.graphics[0] = (Graphics2D) images[0].getGraphics();
            this.graphics[1] = (Graphics2D) images[1].getGraphics();
        }

        @Override
        public BufferedImage getBack1() {
            return images[imageIndex];
        }

        @Override
        public BufferedImage getFront() {
            return images[(imageIndex + 1) % 2];
        }

        @Override
        public Graphics2D getBackGraphics2D() {
            return graphics[imageIndex];
        }

        @Override
        public Graphics2D getFrontGraphics2D() {
            return graphics[(imageIndex + 1) % 2];
        }

        @Override
        public void prepareToRender() {
            imageIndex = (imageIndex + 1) % 2;
        }
    }

    static class DrawingCanvas extends JPanel implements ActionListener {

        private final Timer timer;
        private final Deque<String> keyBuffer;
        private final int keyBufferSize;
        private final int w;
        private final int h;
        private final int iw;
        private final int ih;
        private final int[] clearBuffer;
        private final BasicMouseState mouseState;
        private final Canvas canvas;
        private final Set<String> keysPressed;

        DrawingCanvas(
                int w, int h, int iw, int ih,
                int refreshMillis, int keyBufferSize,
                BasicMouseState mouseState,
                boolean doubleBuffer) {
            this.w = w;
            this.h = h;
            this.iw = iw;
            this.ih = ih;
            this.clearBuffer = new int[w * h];
            Arrays.fill(clearBuffer, 0);
            // Always use setPreferredSize() here.
            setPreferredSize(new Dimension(w, h));
            this.canvas = doubleBuffer ? new DoubleBufferedImageCanvas(iw, ih) : new SingleImageCanvas(iw, ih);
            this.timer = new Timer(refreshMillis, this);
            this.keyBuffer = new ArrayDeque<>();
            this.keyBufferSize = keyBufferSize;
            this.mouseState = mouseState;
            this.keysPressed = new HashSet<>();
        }

        public int getScreenWidth() {
            return w;
        }

        public int getScreenHeight() {
            return h;
        }

        public int getImageWidth() {
            return iw;
        }

        public int getImageHeight() {
            return ih;
        }

        public BasicMouseState getMouseState() {
            return mouseState;
        }

        String takeNextKey() {
            synchronized (keyBuffer) {
                return keyBuffer.isEmpty() ? "" : keyBuffer.removeFirst();
            }
        }

        void setKeyPressed(String key) {
            synchronized (keyBuffer) {
                keysPressed.add(key);
                var lastKey = !keyBuffer.isEmpty() ? keyBuffer.getLast() : null;
                if (!key.equals(lastKey) && keyBuffer.size() < keyBufferSize) {
                    keyBuffer.add(key);
                }
            }
        }

        void setKeyReleased(String key) {
            synchronized (keyBuffer) {
                keysPressed.remove(key);
            }
        }

        boolean isKeyPressed(String key) {
            synchronized (keyBuffer) {
                return keysPressed.contains(key);
            }
        }

        void startRefresh() {
            timer.start();
        }

        void stopRefresh() {
            timer.stop();
        }

        Graphics2D getGraphics2D() {
            return canvas.getBackGraphics2D();
        }

        private void draw(java.awt.Graphics g) {
            g.drawImage(canvas.getFront(), 0, 0, null);
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            synchronized (this) {
                draw(g);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        void floodFill(int x, int y, int r, int g, int b) {
            var image = canvas.getBack1();
            iterativeFloodFill(image, x, y, canvas.getBackGraphics2D().getColor(), new Color(r, g, b));
        }

        void point(int x, int y, int r, int g, int b) {
            var image = canvas.getBack1();
            var graphics = image.getGraphics();
            Color color;
            if (r != -1 && g != -1 && b != -1) {
                color = new Color(r, g, b);
            } else {
                color = graphics.getColor();
            }
            image.setRGB(x, y, color.getRGB());
        }

        void bufferCopyHor(int srcx, int dstx, int copyW) {
            var src = canvas.getFront();
            var dst = canvas.getBack1();
            int[] srcArray = ((DataBufferInt) src.getRaster().getDataBuffer()).getData();
            int[] dstArray = ((DataBufferInt) dst.getRaster().getDataBuffer()).getData();
            copyRect(srcArray, srcx, 0, src.getWidth(),
                    dstArray, dstx, 0, dst.getWidth(),
                    copyW, src.getHeight());
        }

        void copyGraphicsToArray(int bufferNumber, int x1, int y1, int x2, int y2, int[] dest) {
            var image = canvas.get(bufferNumber);
            int[] srcArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
            int w = Math.abs(x1 - x2);
            int h = Math.abs(y1 - y2);
            copyRect(srcArray, x1, y1, image.getWidth(), dest, 0, 0, w, w, h);
        }

        void copyArrayToGraphics(int bufferNumber, int x, int y, int w, int h, String action,
                                 int[] src, int srcx, int srcy, int scanWidth) {
            var image = canvas.get(bufferNumber);
            int[] dstArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
            if (action.equalsIgnoreCase(PUT_PSET)) {
                copyRect(src, srcx, srcy, scanWidth, dstArray, x, y, image.getWidth(), w, h);
            } else {
                int srcVertOffset = srcy * iw + srcx;
                int dstVertOffset = y * iw;
                if (action.equalsIgnoreCase(PUT_XOR)) {
                    for (int yi = 0; yi < h; yi++) {
                        for (int xi = 0; xi < w; xi++) {
                            int srcValue = src[srcVertOffset + xi];
                            int dstIdx = dstVertOffset + x + xi;
                            dstArray[dstIdx] = dstArray[dstIdx] ^ srcValue;
                        }
                        srcVertOffset += scanWidth;
                        dstVertOffset += iw;
                    }
                } else if (action.equalsIgnoreCase(PUT_MIX)) {
                    for (int yi = 0; yi < h; yi++) {
                        for (int xi = 0; xi < w; xi++) {
                            int srcValue = src[srcVertOffset + xi];
                            if (srcValue != 0) {
                                dstArray[dstVertOffset + x + xi] = srcValue;
                            }
                        }
                        srcVertOffset += scanWidth;
                        dstVertOffset += iw;
                    }
                } else if (action.equalsIgnoreCase(PUT_OR)) {
                    for (int yi = 0; yi < h; yi++) {
                        for (int xi = 0; xi < w; xi++) {
                            int srcValue = src[srcVertOffset + xi];
                            int dstIdx = dstVertOffset + x + xi;
                            dstArray[dstIdx] = dstArray[dstIdx] | srcValue;
                        }
                        srcVertOffset += scanWidth;
                        dstVertOffset += iw;
                    }
                } else if (action.equals(PUT_AND)) {
                    for (int yi = 0; yi < h; yi++) {
                        for (int xi = 0; xi < w; xi++) {
                            int srcValue = src[srcVertOffset + xi];
                            int dstIdx = dstVertOffset + x + xi;
                            dstArray[dstIdx] = dstArray[dstIdx] & srcValue;
                        }
                        srcVertOffset += scanWidth;
                        dstVertOffset += iw;
                    }
                } else {
                    throw new RuntimeError(
                            GRAPHICS_ERROR,
                            "Bad PUT action: " + action
                    );
                }
            }
        }

        void clear() {
            var image = canvas.getBack1();
            image.setRGB(0, 0, w, h, clearBuffer, 0, w);
        }

        void renderAndRepaint() {
            canvas.prepareToRender();
            repaint();
        }
    }

    private static class InkeyDlrKeyListener extends KeyAdapter {

        private final DrawingCanvas drawingCanvas;

        InkeyDlrKeyListener(DrawingCanvas drawingCanvas) {
            this.drawingCanvas = drawingCanvas;
        }

        private String getKeyString(KeyEvent e) {
            int charCode = e.getKeyChar();
            int keyCode = e.getKeyCode();
            if (charCode == 65535) {
                return ((char) 0) + String.valueOf((char) keyCode);
            } else {
                // Always store lower case
                if (charCode >= 65 && charCode <= 90) {
                    charCode += 32;
                }
                return String.valueOf((char) charCode);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            drawingCanvas.setKeyPressed(getKeyString(e));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            drawingCanvas.setKeyReleased(getKeyString(e));
        }
    }

    static final class BasicMouseState {
        private final ReadWriteLock lock;
        private int buttonClicked = -1;
        private int buttonPressed = -1;
        private int buttonReleased = -1;
        private int draggedX = -1;
        private int draggedY = -1;
        private int movedX = -1;
        private int movedY = -1;

        BasicMouseState(Component component) {
            this.lock = new ReentrantReadWriteLock();
            component.addMouseListener(new BasicMouseAdapter());
            component.addMouseMotionListener(new BasicMouseMotionAdapter());
        }

        void onMoved(MouseEvent e) {
            lock.writeLock().lock();
            try {
                movedX = e.getX();
                movedY = e.getY();
            } finally {
                lock.writeLock().unlock();
            }
        }

        void onDragged(MouseEvent e) {
            lock.writeLock().lock();
            try {
                draggedX = e.getX();
                draggedY = e.getY();
            } finally {
                lock.writeLock().unlock();
            }
        }

        void onClicked(MouseEvent e) {
            lock.writeLock().lock();
            try {
                buttonClicked = e.getButton();
            } finally {
                lock.writeLock().unlock();
            }
        }

        void onPressed(MouseEvent e) {
            lock.writeLock().lock();
            try {
                buttonPressed = e.getButton();
            } finally {
                lock.writeLock().unlock();
            }
        }

        void onReleased(MouseEvent e) {
            lock.writeLock().lock();
            try {
                buttonReleased = e.getButton();
            } finally {
                lock.writeLock().unlock();
            }
        }

        int getButtonClicked() {
            lock.writeLock().lock();
            try {
                var result = buttonClicked;
                buttonClicked = -1;
                return result;
            } finally {
                lock.writeLock().unlock();
            }
        }

        int getButtonPressed() {
            lock.writeLock().lock();
            try {
                var result = buttonPressed;
                buttonPressed = -1;
                return result;
            } finally {
                lock.writeLock().unlock();
            }
        }

        int getButtonReleased() {
            lock.writeLock().lock();
            try {
                var result = buttonReleased;
                buttonReleased = -1;
                return result;
            } finally {
                lock.writeLock().unlock();
            }
        }

        int getMovedX() {
            lock.readLock().lock();
            try {
                return movedX;
            } finally {
                lock.readLock().unlock();
            }
        }

        int getMovedY() {
            lock.readLock().lock();
            try {
                return movedY;
            } finally {
                lock.readLock().unlock();
            }
        }

        int getDraggedX() {
            lock.readLock().lock();
            try {
                return draggedX;
            } finally {
                lock.readLock().unlock();
            }
        }

        int getDraggedY() {
            lock.readLock().lock();
            try {
                return draggedY;
            } finally {
                lock.readLock().unlock();
            }
        }

        private final class BasicMouseMotionAdapter extends MouseMotionAdapter {
            @Override
            public void mouseDragged(MouseEvent e) {
                onDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                onMoved(e);
            }
        }

        private final class BasicMouseAdapter extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                onPressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                onReleased(e);
            }
        }
    }
}
