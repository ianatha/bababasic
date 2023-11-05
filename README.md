# BabaBASIC

## Write and run BASIC programs, just like in the 70s

<p float="left">
<img alt="BabaBASIC Screenshot" src="https://github.com/ianatha/bababasic/blob/main/design_assets/screenshot_1.png" width="256px" />
<img alt="BabaBASIC Screenshot" src="https://github.com/ianatha/bababasic/blob/main/design_assets/screenshot_2.png" width="256px" />
</p>

BabaBASIC lets you write and run BASIC on your Android device, enabling you to reminisce of the prehistoric computing era.


## Why I am making this?

I made this app because my father, who was a programmer in the 80s, asked me to find him an Android app to showcase programming to others using BASIC.
I couldn't find anything that I felt comfortable recommending to him, so I pulled an all-nighter and made this.

## Running on the command-line

```
./gradlew :bbasic:build
java -jar bbasic/build/libs/bbasic-standalone.jar INPUT.BAS
```

## Standing on the shoulders of giants

This app relies heavily on:
* [mayuropensource/PuffinBASIC](https://github.com/mayuropensource/PuffinBASIC)
* [Rosemoe/sora-editor](https://github.com/Rosemoe/sora-editor)
* [termux/termux-app](https://github.com/termux/termux-app)
