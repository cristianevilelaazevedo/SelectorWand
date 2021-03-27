package com.uemg.cristiane.selectorwand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView varinha;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varinha = findViewById(R.id.varinha);
        final Button mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int newDirection = random.nextInt(3600) + 360;
                float pivoitX = (float) varinha.getWidth() / 2;
                float pivoitY = (float) varinha.getHeight() / 2;

                Animation rotate = new RotateAnimation(lastDirection, newDirection, pivoitX, pivoitY);
                rotate.setDuration(2000);
                rotate.setFillAfter(true);

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mButton.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mButton.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                lastDirection = newDirection;

                varinha.startAnimation(rotate);
            }
        });
    }
}