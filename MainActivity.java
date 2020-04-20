package com.example.secondsession;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;

    Button Btn1, Btn2, Btn3;
    public static TextView label;       // to be able to get it from Fragment1 & Fragment2 classes
    Animation shake;
    Animation rotate;
    Animation bounce;
    Animation zoom_in;
    Animation zoom_out;
    Animation blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = findViewById(R.id.Btn1);
        Btn2 = findViewById(R.id.Btn2);
        Btn3 = findViewById(R.id.Btn3);
        label = findViewById(R.id.txt1);

        // set a new fragment on a layout
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frag, new Fragment1());
        transaction.commit();

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        shake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frag, new Fragment1());
                transaction.commit();
                label.startAnimation(shake);
            }
        });

        rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frag, new Fragment2());
                transaction.commit();
                label.startAnimation(rotate);
            }
        });

        //Scale animation --> slide down or slide up animation
        bounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);

        zoom_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);

        zoom_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);

        // because of android:repeatMode="Reverse", it consist of both fade_in and fade_out animations.
        blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frag, new Fragment3());
                transaction.commit();
                //label.startAnimation(bounce);
                //label.startAnimation(zoom_in);
                //label.startAnimation(zoom_out);
                label.startAnimation(blink);
            }
        });
    }
}
