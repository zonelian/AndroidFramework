package com.zonelian.androidframework.demo.first;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.base.MVPActivity;

import java.util.List;

/**
 * Created by kernel on 2016/10/30.
 * Email: 372786297@qq.com
 */

public class FirstActivity extends MVPActivity<FirstPresenter> implements FirstView {
    private EditText mEtInsertName;
    private RecyclerView mRecyclerViewResult;
    private UserListAdapter mResultAdapter;

    @Override
    public FirstPresenter createPresenter() {
        return new FirstPresenter();
    }

    @Override
    public void initPresenter(FirstPresenter presenter) {
        presenter.setView(this);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_first;
    }

    @Override
    public void initView() {
        mEtInsertName = getViewById(R.id.etName);
        mRecyclerViewResult = getViewById(R.id.recyclerviewResult);
        mRecyclerViewResult.setLayoutManager(new LinearLayoutManager(this));
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnInsert:
                        getPresenter().insert(getInsertName());
                        break;
                    case R.id.btnQuery:
                        getPresenter().query();
                        break;
                }
            }
        }, R.id.btnInsert, R.id.btnQuery);
    }

    @Override
    public void initData() {
        getPresenter().initData();
    }

    @Override
    public void showInsertEnable(boolean enable) {
        getButtonById(R.id.btnInsert).setEnabled(enable);
    }

    @Override
    public String getInsertName() {
        return mEtInsertName.getText().toString().trim();
    }

    @Override
    public void showQueryEnable(boolean enable) {
        getButtonById(R.id.btnQuery).setEnabled(enable);
    }

    @Override
    public void showQuerying() {
    }

    @Override
    public void showQueryComplete() {
    }

    @Override
    public void showQueryResult(List<UserData> result) {
        if(mResultAdapter == null) {
            mResultAdapter = new UserListAdapter();
            mResultAdapter.addItemAll(result);
            mRecyclerViewResult.setAdapter(mResultAdapter);
        }else {
            mResultAdapter.replace(result);
            mResultAdapter.notifyDataSetChanged();
        }
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, FirstActivity.class));
    }
}
