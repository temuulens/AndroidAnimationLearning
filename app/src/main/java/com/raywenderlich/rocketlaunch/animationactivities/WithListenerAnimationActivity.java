package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.widget.Toast;

public class WithListenerAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
      final ValueAnimator animator = ValueAnimator.ofFloat(0, -mScreenHeight);

      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
              float value = (float) animator.getAnimatedValue();
              mRocket.setTranslationY(value);
              mDoge.setTranslationY(value);
          }
      });

      animator.addListener(new Animator.AnimatorListener() {
          @Override
          public void onAnimationStart(Animator animator) {
              Toast.makeText(WithListenerAnimationActivity.this, "Doge took off", Toast.LENGTH_SHORT)
                      .show();
          }

          @Override
          public void onAnimationEnd(Animator animator) {
              Toast.makeText(WithListenerAnimationActivity.this, "Doge is on the moon", Toast.LENGTH_SHORT)
                      .show();
              finish();

          }

          @Override
          public void onAnimationCancel(Animator animator) {

          }

          @Override
          public void onAnimationRepeat(Animator animator) {

          }
      });

      animator.setDuration(5000L);
      animator.start();

  }
}
