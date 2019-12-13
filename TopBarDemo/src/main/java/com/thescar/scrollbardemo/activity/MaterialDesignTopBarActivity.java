package com.thescar.scrollbardemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.thescar.scrollbardemo.R;
import com.thescar.scrollbardemo.adapter.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihongxin on 2019/1/21
 */
public class MaterialDesignTopBarActivity extends AppCompatActivity {
    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MaterialDesignTopBarActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        initList();
        initView();

    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "");
        }
    }

    private void initView() {
        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(normalAdapter);
    }
}
