package com.thescar.scrollbardemo.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.thescar.scrollbardemo.R;
import com.thescar.scrollbardemo.adapter.NormalAdapter;
import com.thescar.scrollbardemo.widget.FixedBarDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihongxin on 2019/1/22
 */
public class DecorationActivity extends AppCompatActivity {
    private View headerView;
    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);
        recyclerView = (RecyclerView)findViewById(R.id.rv_list);
        initList();
        initView();
    }

    private void initView() {
        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);
        recyclerView.addItemDecoration(new FixedBarDecoration(this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(normalAdapter);
        headerView = LayoutInflater.from(this).inflate(R.layout.header, recyclerView, false);
        normalAdapter.setmHeaderView(headerView);


    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "");
        }
    }
}
