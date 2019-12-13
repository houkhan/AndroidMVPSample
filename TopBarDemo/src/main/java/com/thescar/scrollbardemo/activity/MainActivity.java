package com.thescar.scrollbardemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.thescar.scrollbardemo.R;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
    }

    public void onClickTwoTopBar(View view) {

    }

    public void onClickOneTopBar(View view) {

    }

    public void onClickListView(View view) {

    }

    public void onClickMaterialDesign(View view) {

    }

    public void onClickDecoration(View view) {

    }

    public void onClickGroupAndDecoration(View view) {

    }
}

