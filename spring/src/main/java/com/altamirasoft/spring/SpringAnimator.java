package com.altamirasoft.spring;



//사용 방법
//SpringAnimator.ofFloat(app_view_MC,"translationX",1400,0).start(); fromTo
//SpringAnimator.ofFloat(app_view_MC,"translationX",1400).start(); To
//SpringAnimator.ofFloat(app_view_MC,"translationX",1400).setTensionFriction(400,20).start();


import android.util.Log;
import android.view.View;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;


import java.util.ArrayList;

/**
 * Created by bdhwan on 2016. 7. 7..
 */
public class SpringAnimator {


    public static final float DEFAULT_TENSION = 600f;
    public static final float DEFAULT_FRICTION = 20f;


    boolean isAnimating = false;
    boolean isCanceled = false;

    static SpringSystem springSystem;


    //case
    //1. translationX
    //2. translationY
    //3. scaleX
    //4. scaleY
    //5. scale = (scaleX+scaleY)
    //6. rotation
    //7. rotationX
    //8. rotationY
    //9. alpha

    ArrayList<AnimatorListener> mListeners = null;
    ArrayList<AnimatorUpdateListener> mUpdateListeners = null;


    View mTarget;
    String mPropertyName;
    float[] mTargetValue;


    public void start() {

        if(mTargetValue==null)return;

        if (springSystem == null) {
            springSystem = SpringSystem.create();
        }

        isCanceled = false;

        if ("value".equals(mPropertyName)) {
            changeStateWithSpring(null, mTension, mFriction, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }

        else if ("translationx".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, mTarget.getTranslationX(), mTargetValue[0], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            }

        } else if ("translationy".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, mTarget.getTranslationY(), mTargetValue[0], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            }
        } else if ("scale".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, mTarget.getScaleX(), mTargetValue[0], mTarget.getScaleY(), mTargetValue[0], 0, 0, 0, 0, 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0,mTargetValue[0], mTargetValue[1], mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0);

            }
        } else if ("scalex".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, mTarget.getScaleX(), mTargetValue[0], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            }
        } else if ("scaley".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, mTarget.getScaleY(), mTargetValue[0], 0, 0, 0, 0, 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0, 0, 0);

            }
        } else if ("rotation".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, mTarget.getRotation(), mTargetValue[0], 0, 0, 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0, 0, 0);

            }
        } else if ("rotationx".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTarget.getRotationX(), mTargetValue[0], 0, 0, 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0, 0, 0);

            }
        } else if ("rotationy".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTarget.getRotationY(), mTargetValue[0], 0, 0);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1], 0, 0);

            }
        } else if ("alpha".equals(mPropertyName)) {
            if (mTargetValue.length == 1) {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTarget.getAlpha(), mTargetValue[0]);

            } else {
                changeStateWithSpring(mTarget, mTension, mFriction, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, mTargetValue[0], mTargetValue[1]);

            }
        }

    }

    public void cancel() {

        isCanceled = true;
        if (mListeners != null) {
            for (int i = 0; i < mListeners.size(); i++) {
                mListeners.get(i).onAnimationCancel(SpringAnimator.this);
            }
        }
    }


    public void end() {

        isCanceled = true;

        if ("translationx".equals(mPropertyName)) {
            mTarget.setTranslationX(mTargetValue[mTargetValue.length - 1]);
        } else if ("translationy".equals(mPropertyName)) {
            mTarget.setTranslationY(mTargetValue[mTargetValue.length - 1]);
        } else if ("scale".equals(mPropertyName)) {
            mTarget.setScaleX(mTargetValue[mTargetValue.length - 1]);
            mTarget.setScaleY(mTargetValue[mTargetValue.length - 1]);
        } else if ("scalex".equals(mPropertyName)) {
            mTarget.setScaleX(mTargetValue[mTargetValue.length - 1]);

        } else if ("scaley".equals(mPropertyName)) {
            mTarget.setScaleY(mTargetValue[mTargetValue.length - 1]);

        } else if ("rotation".equals(mPropertyName)) {
            mTarget.setRotation(mTargetValue[mTargetValue.length - 1]);

        } else if ("rotationx".equals(mPropertyName)) {
            mTarget.setRotationX(mTargetValue[mTargetValue.length - 1]);

        } else if ("rotationy".equals(mPropertyName)) {
            mTarget.setRotationY(mTargetValue[mTargetValue.length - 1]);

        } else if ("alpha".equals(mPropertyName)) {
            mTarget.setAlpha(mTargetValue[mTargetValue.length - 1]);

        }


        if (mListeners != null) {
            for (int i = 0; i < mListeners.size(); i++) {
                mListeners.get(i).onAnimationEnd(SpringAnimator.this);
            }
        }

    }


    float mTension = DEFAULT_TENSION;
    float mFriction = DEFAULT_FRICTION;


    public SpringAnimator setTensionFriction(float tension, float friction) {
        mTension = tension;
        mFriction = friction;
        return this;
    }


    private void setTarget(View target) {
        mTarget = target;
    }

    private void setPropertyName(String propertyName) {
        mPropertyName = propertyName.toLowerCase();
    }

    private void setTargetValue(float... targetValue) {
        mTargetValue = targetValue;
    }

    public static SpringAnimator ofFloat(View target, String propertyName, float... targetValue) {
        SpringAnimator anim = new SpringAnimator();
        anim.setTargetValue(targetValue);
        anim.setTarget(target);
        anim.setPropertyName(propertyName);
        return anim;
    }


    public static SpringAnimator ofFloat(String propertyName, float... targetValue) {
        SpringAnimator anim = new SpringAnimator();
        anim.setTargetValue(targetValue);
        anim.setPropertyName(propertyName);
        return anim;
    }




    public void addListener(AnimatorListener listener) {
        if (mListeners == null) {
            mListeners = new ArrayList<AnimatorListener>();
        }
        mListeners.add(listener);
    }



    public void addUpdateListener(AnimatorUpdateListener listener) {
        if (mUpdateListeners == null) {
            mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        }
        mUpdateListeners.add(listener);
    }




    public static interface AnimatorListener {
        /**
         * <p>Notifies the start of the animation.</p>
         *
         * @param animation The started animation.
         */
        void onAnimationStart(SpringAnimator animation);

        /**
         * <p>Notifies the end of the animation. This callback is not invoked
         * for animations with repeat count set to INFINITE.</p>
         *
         * @param animation The animation which reached its end.
         */
        void onAnimationEnd(SpringAnimator animation);

        /**
         * <p>Notifies the cancellation of the animation. This callback is not invoked
         * for animations with repeat count set to INFINITE.</p>
         *
         * @param animation The animation which was canceled.
         */
        void onAnimationCancel(SpringAnimator animation);

        /**
         * <p>Notifies the repetition of the animation.</p>
         *
         * @param animation The animation which was repeated.
         */
        void onAnimationRepeat(SpringAnimator animation);




    }



    public static interface AnimatorUpdateListener {
        /**
         * <p>Notifies the occurrence of another frame of the animation.</p>
         *
         * @param animation The animation which was repeated.
         */
        void onAnimationUpdate(SpringAnimator animation);

    }

    float mCurrentValue = 0;

    void animateValue(float value) {
        mCurrentValue = value;
        if (mUpdateListeners != null) {
            int numListeners = mUpdateListeners.size();
            for (int i = 0; i < numListeners; ++i) {
                mUpdateListeners.get(i).onAnimationUpdate(this);
            }
        }
    }


    public float getAnimatedValue() {
        return mCurrentValue;
    }



    public void changeStateWithSpring(final View view, final float tension, final float friction, final float fromX, final float targetX, final float fromY, final float targetY, final float fromScaleX, final float targetScaleX, final float fromScaleY, final float targetScaleY, final float fromRotate, final float targetRotate, final float fromRotateX, final float targetRotateX, final float fromRotateY, final float targetRotateY, final float fromAlpha, final float targetAlpha) {
        if (isAnimating) return;
        isAnimating = true;
        SpringConfig config = new SpringConfig(tension, friction);
        final Spring spring = springSystem.createSpring();
        spring.setSpringConfig(config);
        spring.addListener(new SpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                if (isCanceled) return;

                float value = (float) spring.getCurrentValue();


                float differValue = targetX - fromX;


                if(view==null){
                    //update current value
                    float current = fromX + differValue * value;
                    animateValue(current);
                }



                if(view==null)return;


                //change y translation
                float differX = targetX - fromX;
                if (Math.abs(differX) > 0) {
                    view.setTranslationX(fromX + differX * value);

                    animateValue(fromX + differX * value);
                }

                //change y translation
                float differY = targetY - fromY;
                if (Math.abs(differY) > 0) {
                    view.setTranslationY(fromY + differY * value);

                    animateValue(fromY + differY * value);
                }

                //change scaleX
                float differScaleX = targetScaleX - fromScaleX;
                if (Math.abs(differScaleX) > 0) {
                    view.setScaleX(fromScaleX + differScaleX * value);
                    animateValue(fromScaleX + differScaleX * value);
                }

                //change scaleY
                float differScaleY = targetScaleY - fromScaleY;
                if (Math.abs(differScaleY) > 0) {
                    view.setScaleY(fromScaleY + differScaleY * value);
                    animateValue(fromScaleY + differScaleY * value);
                }


                //change rotate
                float differRotate = targetRotate - fromRotate;
                if (Math.abs(differRotate) > 0) {
                    view.setRotation(fromRotate + differRotate * value);
                    animateValue(fromRotate + differRotate * value);
                }

                //change rotateX
                float differRotateX = targetRotateX - fromRotateX;
                if (Math.abs(differRotateX) > 0) {
                    view.setRotationX(fromRotateX + differRotateX * value);
                    animateValue(fromRotateX + differRotateX * value);
                }

                //change rotateY
                float differRotateY = targetRotateY - fromRotateY;
                if (Math.abs(differRotateY) > 0) {
                    view.setRotationY(fromRotateY + differRotateY * value);
                    animateValue(fromRotateY + differRotateY * value);
                }

                //change alpha
                float differAlpha = targetAlpha - fromAlpha;
                if (Math.abs(differAlpha) > 0) {

                    float tempAlpha = fromAlpha + differAlpha * value;
                    if (tempAlpha < 0f) {
                        tempAlpha = 0f;
                    }
                    if (tempAlpha > 1f) {
                        tempAlpha = 1f;
                    }
                    view.setAlpha(tempAlpha);
                    animateValue(tempAlpha);
                }
            }

            @Override
            public void onSpringAtRest(Spring spring) {

                isAnimating = false;
                if (mListeners != null) {
                    for (int i = 0; i < mListeners.size(); i++) {
                        mListeners.get(i).onAnimationEnd(SpringAnimator.this);
                    }
                }
            }

            @Override
            public void onSpringActivate(Spring spring) {
//                Log.d("log", "onSpringActivate");
            }

            @Override
            public void onSpringEndStateChange(Spring spring) {
//                Log.d("log", "onSpringEndStateChange");
            }
        });
        spring.setEndValue(1);


        if (mListeners != null) {
            for (int i = 0; i < mListeners.size(); i++) {
                mListeners.get(i).onAnimationStart(SpringAnimator.this);
            }
        }

    }

}
