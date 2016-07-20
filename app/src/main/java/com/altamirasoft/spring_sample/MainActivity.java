package com.altamirasoft.spring_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.altamirasoft.spring.SpringAnimator;

public class MainActivity extends AppCompatActivity {


    View object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        object = findViewById(R.id.object);

        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final SpringAnimator anim =  SpringAnimator.ofFloat(object,"translationY",0,200);
                anim.addUpdateListener(new SpringAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(SpringAnimator animation) {
                        float value = animation.getAnimatedValue();
                        object.setTranslationX(value);
                    }
                });

                anim.addListener(new SpringAnimator.AnimatorListener() {
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
                anim.start();

            }
        });



    }
}
