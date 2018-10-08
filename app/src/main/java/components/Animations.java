package components;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class Animations {

    public static Animation getFadeOut(Long time){
        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setDuration(time);
        return fadeOut;
    }

    public static Animation getFadeIn(Long time){
        Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setDuration(time);
        return fadeIn;
    }

    public static Animation getEditTextOut(){
        final Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setDuration(100);

        final TranslateAnimation transOut = new TranslateAnimation(0,90,0,0);
        transOut.setDuration(100);
        transOut.setInterpolator(new AccelerateInterpolator());

        final AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeOut);
        animation.addAnimation(transOut);
        return animation;
    }

    public static Animation getEditTextIn(){
        final Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setDuration(100);

        final TranslateAnimation transOut = new TranslateAnimation(0,-90,0,0);
        transOut.setDuration(100);
        transOut.setInterpolator(new DecelerateInterpolator());

        final AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        animation.addAnimation(transOut);
        return animation;
    }

}
