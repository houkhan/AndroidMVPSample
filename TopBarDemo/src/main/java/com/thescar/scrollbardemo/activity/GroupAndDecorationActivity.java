package com.thescar.scrollbardemo.activity;

import android.os.Bundle;

import com.thescar.scrollbardemo.R;
import com.thescar.scrollbardemo.adapter.GroupAdapter;
import com.thescar.scrollbardemo.bean.TestData;
import com.thescar.scrollbardemo.widget.GroupDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lihongxin on 2019/1/22
 */
public class GroupAndDecorationActivity extends AppCompatActivity {


    private List<TestData> testDataList;
    private LinearLayoutManager linearLayoutManager;
    private GroupAdapter groupAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_and_decoration);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        initData();
        initView();
    }

    private void initView() {
        linearLayoutManager = new LinearLayoutManager(this);
        groupAdapter = new GroupAdapter(testDataList);
        recyclerView.addItemDecoration(new GroupDecoration(this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(groupAdapter);


    }

    private void initData() {
        testDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testDataList.add(new TestData(String.format("第一组%d号", i + 1), "第一组"));
        }
        for (int i = 0; i < 16; i++) {
            testDataList.add(new TestData(String.format("第二组%d号", i + 1), "第二组"));
        }
        for (int i = 0; i < 22; i++) {
            testDataList.add(new TestData(String.format("第三组%d号", i + 1), "第三组"));
        }
        for (int i = 0; i < 28; i++) {
            testDataList.add(new TestData(String.format("第四组%d号", i + 1), "第四组"));
        }
    }
}
