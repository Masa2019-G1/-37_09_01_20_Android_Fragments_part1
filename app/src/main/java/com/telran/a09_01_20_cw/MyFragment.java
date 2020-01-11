package com.telran.a09_01_20_cw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MyFragment extends Fragment {
    private float scale;
    private int color;

    public MyFragment(float scale, int color) {
        this.scale = scale;
        this.color = color;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        TextView myTxt = view.findViewById(R.id.titleTxt);
        myTxt.setText("Hello");
        view.setScaleY(scale);
        view.setScaleX(scale);
        view.setBackgroundColor(color);
        return view;
    }
}
