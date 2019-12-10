package com.thescar.mvp.adapter;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:13
 * @Email :han_shuaishuai@126.com
 * @Description :viewpager适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> frags;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> frags) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.frags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}