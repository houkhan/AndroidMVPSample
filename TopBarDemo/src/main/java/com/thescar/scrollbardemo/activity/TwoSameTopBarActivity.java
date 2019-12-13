package com.thescar.scrollbardemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.thescar.scrollbardemo.R;
import com.thescar.scrollbardemo.adapter.NormalAdapter;
import com.thescar.scrollbardemo.util.ViewUtils;
import com.thescar.scrollbardemo.widget.MyScrollView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihongxin on 2019/1/18
 */
public class TwoSameTopBarActivity extends AppCompatActivity {


    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int topHeight;
    private LinearLayout insideFixedBar;
    private RecyclerView recyclerView;
    private MyScrollView scrollView;
    private LinearLayout llOutsideFixed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_bar);
        insideFixedBar = (LinearLayout) findViewById(R.id.inside_fixed_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        llOutsideFixed = (LinearLayout) findViewById(R.id.ll_outside_fixed);
        initList();
        initView();
    }

    private void initView() {
        topHeight = ViewUtils.dip2px(this, 200);

        linearLayoutManager = new LinearLayoutManager(this);
        normalAdapter = new NormalAdapter(list);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(normalAdapter);

        scrollView.setScrollChangeListener(new MyScrollView.ScrollChangedListener() {
            @Override
            public void onScrollChangedListener(int x, int y, int oldX, int oldY) {
                Log.d("test", "当前x：" + x + "当前y:" + y);
                if (y >= topHeight) {
                    //重点 通过距离变化隐藏内外固定栏实现
                    llOutsideFixed.setVisibility(View.VISIBLE);
                    insideFixedBar.setVisibility(View.GONE);
                    recyclerView.setNestedScrollingEnabled(true);
                } else {
                    llOutsideFixed.setVisibility(View.GONE);
                    insideFixedBar.setVisibility(View.VISIBLE);
                    recyclerView.setNestedScrollingEnabled(false);
                }

            }
        });
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "");
        }
    }
}

