package io.atha.bbasic.awt;

import java.awt.Graphics2D;

import io.atha.libbababasic.error.RuntimeError;

class AWTGraphicsState {
    private AWTGraphicsUtil.BasicFrame frame;

    AWTGraphicsState() {
    }

    boolean isInitialized() {
        return frame != null;
    }

    AWTGraphicsUtil.BasicFrame getFrame() {
        assertScreenInitialized();
        return frame;
    }

    void setFrame(AWTGraphicsUtil.BasicFrame frame) {
        assertNewScreen();
        this.frame = frame;
    }

    Graphics2D getGraphics2D() {
        return getFrame().getDrawingCanvas().getGraphics2D();
    }

    int getImageWidth() {
        return getFrame().getDrawingCanvas().getImageWidth();
    }

    int getImageHeight() {
        return getFrame().getDrawingCanvas().getImageHeight();
    }

    private void assertNewScreen() {
        if (frame != null) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Screen cannot be called again!"
            );
        }
    }

    private void assertScreenInitialized() {
        if (frame == null) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Screen has already been created!"
            );
        }
    }
}
