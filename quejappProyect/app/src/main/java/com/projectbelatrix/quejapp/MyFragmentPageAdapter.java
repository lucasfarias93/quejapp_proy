package com.projectbelatrix.quejapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Elias on 25/01/2017.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragments;
    public MyFragmentPageAdapter (FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }
    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
