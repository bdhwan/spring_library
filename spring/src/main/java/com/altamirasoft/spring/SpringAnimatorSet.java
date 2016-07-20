package com.altamirasoft.spring;

import android.support.annotation.Nullable;
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
public class SpringAnimatorSet {


    ArrayList<SpringAnimator> mAnimationList = null;

    public void start() {
        if(mAnimationList!=null){
            for(int i =0;i<mAnimationList.size();i++){
                mAnimationList.get(i).start();
            }
        }
    }

    public void cancel(){
        if(mAnimationList!=null){
            for(int i =0;i<mAnimationList.size();i++){
                mAnimationList.get(i).cancel();
            }
        }
    }


    public void end(){
        if(mAnimationList!=null){
            for(int i =0;i<mAnimationList.size();i++){
                mAnimationList.get(i).end();
            }
        }
    }


    public SpringAnimatorSet(){
        mAnimationList = new ArrayList<SpringAnimator>();
    }


    public void addAnimation(SpringAnimator animator){
        mAnimationList.add(animator);
    }

    public  ArrayList<SpringAnimator> getAnimationList(){
        return mAnimationList;
    }


    public static SpringAnimatorSet createAnimationSet(@Nullable SpringAnimator... animators){
        SpringAnimatorSet mInstance = new SpringAnimatorSet();
        if(animators!=null){
            for(int i =0;i<animators.length;i++){
                mInstance.mAnimationList.add(animators[i]);
            }
        }
        return mInstance;
    }






}
