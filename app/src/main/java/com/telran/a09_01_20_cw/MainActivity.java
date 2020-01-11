package com.telran.a09_01_20_cw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    float scale = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentManager manager = getSupportFragmentManager();
//        MyFragment fragment = new MyFragment();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.fragmentConteiner,fragment);
//        transaction.commit();
    }

    public void add(View view){
        Random rnd = new Random();
        int color = Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
        MyFragment fr = new MyFragment(scale,color);
        scale -= 0.1;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentConteiner,fr,"FR" + count)
                .addToBackStack(null)
                .commit();
        count++;
    }

    public void replace(View view){
        MyFragment fr = new MyFragment( 1.0F,Color.rgb(0,255,0));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentConteiner,fr)
                .commit();
    }

    public void remove(View view){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("FR2");
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }

    public void attach(View view){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("FR1");
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }
    }

    public void detach(View view){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("FR1");
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .detach(fragment)
                    .commit();
        }
    }
}
