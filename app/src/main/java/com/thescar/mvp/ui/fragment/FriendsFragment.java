package com.thescar.mvp.ui.fragment;

import android.app.Activity;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.R;
import com.thescar.mvp.base.BasePresenter;
import com.thescar.mvp.base.MvpBaseFragment;
import com.thescar.scrollbardemo.activity.DecorationActivity;
import com.thescar.scrollbardemo.activity.GroupAndDecorationActivity;
import com.thescar.scrollbardemo.activity.ListViewAddHeaderActivity;
import com.thescar.scrollbardemo.activity.MaterialDesignTopBarActivity;
import com.thescar.scrollbardemo.activity.OneTopBarActivity;
import com.thescar.scrollbardemo.activity.TwoSameTopBarActivity;

import butterknife.OnClick;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:22
 * @Email :han_shuaishuai@126.com
 * @Description : FriendsFragment
 */
public class FriendsFragment extends MvpBaseFragment {

    private Activity activity = getActivity();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onFragmentFirstVisible() {
        LogUtils.d("Fragment", "FriendsFragment---onFragmentFirstVisible");
    }

    @Override
    protected void onFragmentResume() {
        LogUtils.d("Fragment", "FriendsFragment---onFragmentResume");
    }

    @Override
    protected void onFragmentPause() {
        LogUtils.d("Fragment", "FriendsFragment---onFragmentPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friends;
    }

    @OnClick({R.id.btn_two_header, R.id.btn_listview, R.id.btn_one_header, R.id.btn_material_design, R.id.btn_rv_decoration, R.id.btn_group_and_decoration})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_two_header:
                ActivityUtils.startActivity(TwoSameTopBarActivity.class);
                break;
            case R.id.btn_listview:
                ActivityUtils.startActivity(ListViewAddHeaderActivity.class);
                break;
            case R.id.btn_one_header:
                ActivityUtils.startActivity(OneTopBarActivity.class);
                break;
            case R.id.btn_material_design:
                ActivityUtils.startActivity(MaterialDesignTopBarActivity.class);
                MaterialDesignTopBarActivity.start(activity);
                break;
            case R.id.btn_rv_decoration:
                ActivityUtils.startActivity(DecorationActivity.class);
                break;
            case R.id.btn_group_and_decoration:
                ActivityUtils.startActivity(GroupAndDecorationActivity.class);
                break;
        }
    }
}
