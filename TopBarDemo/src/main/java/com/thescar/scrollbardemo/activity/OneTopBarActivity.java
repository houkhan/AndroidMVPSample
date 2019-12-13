package com.thescar.scrollbardemo.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
 * Created by lihongxin on 2019/1/21
 */
public class OneTopBarActivity extends AppCompatActivity {


    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int topHeight;
    private RelativeLayout rlInsideFixed;
    private LinearLayout insideFixedBarParent;
    private RecyclerView recyclerView;
    private MyScrollView scrollView;
    private LinearLayout llFixed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_bar);
        rlInsideFixed = (RelativeLayout) findViewById(R.id.rl_inside_fixed);
        insideFixedBarParent = (LinearLayout) findViewById(R.id.inside_fixed_bar_parent);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        llFixed = (LinearLayout) findViewById(R.id.ll_fixed_parent);
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
                if (y >= topHeight) {
                    if (rlInsideFixed.getParent() != llFixed) {
                        insideFixedBarParent.removeView(rlInsideFixed);
                        llFixed.addView(rlInsideFixed);
                        recyclerView.setNestedScrollingEnabled(true);

                    }
                } else {
                    if (rlInsideFixed.getParent() != insideFixedBarParent) {
                        llFixed.removeView(rlInsideFixed);
                        insideFixedBarParent.addView(rlInsideFixed);
                        recyclerView.setNestedScrollingEnabled(false);
                    }
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
