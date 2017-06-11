## Spring Library

Spring Library is utility class for make Spring animation on Android platform.

It uses [Rebound library](http://facebook.github.io/rebound/) from facebook(It is not easy to use directly).

![preivew](https://github.com/bdhwan/spring_library/blob/master/screenshot/preview.gif?raw=true "Spring Preview")

## Setup
Add the following to your build.gradle:
```
compile 'com.altamirasoft.spring:spring:0.1.8'
```

or 

Download the jar files:
- [Spring Library jar](https://github.com/bdhwan/spring_library/raw/master/spring/release/spring.jar)
- [Rebound library jar](https://github.com/facebook/rebound/releases/tag/v0.3.8)
- Add .jar files to your project's libs folder


## Usage
- Simple Usage with tension and friction
```
  SpringAnimator.ofFloat(object,"scale",1f,0.5f).setTensionFriction(400,20).start();
```

- Complex Animator Set
```
  SpringAnimator animX = SpringAnimator.ofFloat(object,"scaleX",1f);
  SpringAnimator animY = SpringAnimator.ofFloat(object,"scaleY",1f);

  SpringAnimatorSet set = SpringAnimatorSet.createAnimationSet(animX,animY);
  set.start();
```

- Animator Listener
```
    SpringAnimator animX = SpringAnimator.ofFloat(object,"scaleX",1f);

    animX.addListener(new SpringAnimator.AnimatorListener() {
        @Override
        public void onAnimationStart(SpringAnimator animation) {

        }

        @Override
        public void onAnimationEnd(SpringAnimator animation) {

        }

        @Override
        public void onAnimationCancel(SpringAnimator animation) {

        }

        @Override
        public void onAnimationRepeat(SpringAnimator animation) {

        }
    });
```


- Animator Update Listener
```
    SpringAnimator animX = SpringAnimator.ofFloat(object,"scaleX",1f);

    animX.addUpdateListener(new SpringAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(SpringAnimator animation) {
            float value = animation.getAnimatedValue();
            Log.d("log","value = "+value);
        }
    });
    
```



## Project News
- Added animator listener
- Added animator update listener

## Features
- Easy to use (Similar with basic android animator)
- Support Scale, ScaleX, ScaleY, TranslationX, TranslationY, Alpha or value
- Support Animator Set like android basic animator set
- Animation End Callback
- Animation Value Update listener





