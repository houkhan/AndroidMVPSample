package com.thescar.scrollbardemo.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.thescar.scrollbardemo.R;
import com.thescar.scrollbardemo.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by lihongxin on 2019/1/18
 */
public class ListViewAddHeaderActivity extends AppCompatActivity {

    FrameLayout flOutSideBar;

    private View mHeaderView;
    private View mTopBarView;
    private ListViewAdapter mAdapter;
    private List<String> list;
    private ListView mLv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mLv = (ListView) findViewById(R.id.lv);
        initList();
        initView();
    }

    private void initView() {


        mHeaderView = LayoutInflater.from(this).inflate(R.layout.header, mLv, false);
        mTopBarView = LayoutInflater.from(this).inflate(R.layout.inside_fixed_bar, mLv, false);

        mLv.addHeaderView(mHeaderView);
        mLv.addHeaderView(mTopBarView);
        mAdapter = new ListViewAdapter(list);
        mLv.setAdapter(mAdapter);
        mLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /* 判断ListView头部(mHeaderView)当前是否可见
                 * 来决定隐藏或显示浮动栏(mFloatBar)*/
                if (firstVisibleItem >= 1) {
                    flOutSideBar.setVisibility(View.VISIBLE);
                } else {
                    flOutSideBar.setVisibility(View.GONE);
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
