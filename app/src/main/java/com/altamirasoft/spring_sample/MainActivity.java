package com.altamirasoft.spring_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.altamirasoft.spring.SpringAnimator;
import com.altamirasoft.spring.SpringAnimatorSet;

public class MainActivity extends AppCompatActivity {




    View object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        object = findViewById(R.id.object);


        object.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getActionMasked();
                if(action==MotionEvent.ACTION_DOWN){
                    Log.d("log","value = ACTION_DOWN");


                    SpringAnimator.ofFloat(object,"scale",1f,0.5f).setTensionFriction(400,20).start();

                    return true;

                }
                else if(action==MotionEvent.ACTION_UP){
                    Log.d("log","value = ACTION_UP");
                    //with animator set



                    SpringAnimator animX = SpringAnimator.ofFloat(object,"scaleX",1f);

                    animX.addUpdateListener(new SpringAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(SpringAnimator animation) {
                            float value = animation.getAnimatedValue();
                            Log.d("log","value = "+value);


                        }
                    });



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


                    SpringAnimator animY = SpringAnimator.ofFloat(object,"scaleY",1f);






                    SpringAnimatorSet set = SpringAnimatorSet.createAnimationSet(animX,animY);
                    set.start();



                    return true;
                }

                return false;
            }
        });



    }
}
