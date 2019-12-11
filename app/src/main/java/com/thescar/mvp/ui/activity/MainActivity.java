package com.thescar.mvp.ui.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.thescar.mvp.R;
import com.thescar.mvp.adapter.ViewPagerAdapter;
import com.thescar.mvp.ui.base.BaseActivity;
import com.thescar.mvp.ui.fragment.FriendsFragment;
import com.thescar.mvp.ui.fragment.JokeFragment;
import com.thescar.mvp.ui.fragment.MineFragment;
import com.thescar.mvp.ui.fragment.SpaceFragment;
import com.thescar.mvp.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:21
 * @Email :han_shuaishuai@126.com
 * @Description : MainActivity
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {
    @BindView(R.id.home_view_pager)
    CustomViewPager mHomeViewPager;
    @BindView(R.id.home_rb_message)
    RadioButton mHomeRbMessage;
    @BindView(R.id.home_rb_friends)
    RadioButton mHomeRbFriends;
    @BindView(R.id.home_rb_space)
    RadioButton mHomeRbSpace;
    @BindView(R.id.home_rb_mine)
    RadioButton mHomeRbMine;
    @BindView(R.id.home_rg)
    RadioGroup mHomeRg;
    private List<Fragment> mFragments;

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mFragments = new ArrayList<>();
        JokeFragment jokeFragment = new JokeFragment();
        FriendsFragment friendsFragment = new FriendsFragment();
        SpaceFragment spaceFragment = new SpaceFragment();
        MineFragment mineFragment = new MineFragment();
        mFragments.add(jokeFragment);
        mFragments.add(friendsFragment);
        mFragments.add(spaceFragment);
        mFragments.add(mineFragment);
        mHomeViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragments));
        mHomeRg.setOnCheckedChangeListener(this);
        mHomeViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.home_rb_message:
                mHomeViewPager.setCurrentItem(PAGE_MESSAGE);
                break;
            case R.id.home_rb_friends:
                mHomeViewPager.setCurrentItem(PAGE_FRIENDS);
                break;
            case R.id.home_rb_space:
                mHomeViewPager.setCurrentItem(PAGE_SPACE);
                break;
            case R.id.home_rb_mine:
                mHomeViewPager.setCurrentItem(PAGE_MINE);
                break;
        }
    }

    /**
     * 重写ViewPager页面切换的处理方法
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        /*state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕*/
        if (state == 2) {
            switch (mHomeViewPager.getCurrentItem()) {
                case PAGE_MESSAGE:
                    mHomeRbMessage.setChecked(true);
                    break;
                case PAGE_FRIENDS:
                    mHomeRbFriends.setChecked(true);
                    break;
                case PAGE_SPACE:
                    mHomeRbSpace.setChecked(true);
                    break;
                case PAGE_MINE:
                    mHomeRbMine.setChecked(true);
                    break;
            }
        }
    }
}
