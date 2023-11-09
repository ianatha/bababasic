# BabaBASIC

<a href="https://play.google.com/store/apps/details?id=io.atha.quickbasic&pli=1"><img alt="BabaBASIC on the Play Store" src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" width="256px" /></a>

## Write and run QuickBASIC 4.5 programs, just like in the 80s

<p float="left">
<img alt="BabaBASIC Screenshot" src="https://github.com/ianatha/bababasic/blob/main/design_assets/screenshot_1.png" width="256px" />
<img alt="BabaBASIC Screenshot" src="https://github.com/ianatha/bababasic/blob/main/design_assets/screenshot_2.png" width="256px" />
</p>

BabaBASIC lets you write and run QuickBASIC 4.5-compatible programs on your Android device, enabling you to reminisce of the prehistoric computing era.


## Why I am making this?

I made this app because my father, who was a programmer in the 80s, asked me to find him an Android app to showcase programming to others using QuickBASIC.
I couldn't find anything that I felt comfortable recommending to him, so I pulled an all-nighter and made this.

## Running on the command-line

```
./gradlew :bbasic:build
java -jar bbasic/build/libs/bbasic-standalone.jar INPUT.BAS
```

## Standing on the shoulders of giants

* [Rosemoe/sora-editor](https://github.com/Rosemoe/sora-editor)
* [termux/termux-app](https://github.com/termux/termux-app)
* BabaBASIC started as fork of [mayuropensource/PuffinBASIC](https://github.com/mayuropensource/PuffinBASIC),
but it's been modified significantly to match [QuickBASIC 4.5](https://ia803001.us.archive.org/12/items/Microsoft_QuickBASIC_4.5_2nd_Edition_Manual/Microsoft_QuickBASIC_4.5_2nd_Edition_Manual.pdf).
