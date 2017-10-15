package com.xing.lazyfragmentsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"Android", "iOS", "福利", "all"};

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private FragmentViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void initData() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(TabFragment.newInstance("Android"));
        fragmentList.add(TabFragment.newInstance("iOS"));
        fragmentList.add(TabFragment.newInstance("福利"));
        fragmentList.add(TabFragment.newInstance("all"));
        adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.setPages(fragmentList, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        // 需要在 setupWithViewPager 之后调用
//        tabLayout.addOnTabSelectedListener(onTabSelectedListener);

    }


    class FragmentViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        private String[] titles;

        public FragmentViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setPages(List<Fragment> list, String[] titles) {
            fragments = list;
            this.titles = titles;
        }


        @Override
        public int getCount() {
            return fragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];

        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        /**
         * 在没有重写FragmentPagerAdapter 的 destroyItem(),切换过的 Fragment 再次显示时，会销毁重新创建，
         * 请求的数据也丢失，为了保留已经加载过的 Fragment 数据，需要 Fragment 不销毁。
         * 即不调用父类方法
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
//            super.destroyItem(container, position, object);
        }
    }


}
