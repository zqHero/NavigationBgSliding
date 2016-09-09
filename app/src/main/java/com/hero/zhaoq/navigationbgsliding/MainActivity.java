package com.hero.zhaoq.navigationbgsliding;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.hero.zhaoq.navigationbgsliding.adapter.FragmentAdapter;
import com.hero.zhaoq.navigationbgsliding.fragments.BaseFragment;
import com.hero.zhaoq.navigationbgsliding.fragments.CompletedFragment;
import com.hero.zhaoq.navigationbgsliding.fragments.HadOverFragment;
import com.hero.zhaoq.navigationbgsliding.fragments.OnDoingFragment;
import com.hero.zhaoq.navigationbgsliding.widgets.MyTabLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * 仿写   导航背景滑动效果
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager tabViewPager;

    private MyTabLayout myTab;
    private ViewPager myVp;

    private List<BaseFragment> fragments;
    private FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用 TabLayout
        initFragment();
        //init MyTabLayout
        initMyTabLayout();
    }
//---------------------------------------
    private void initMyTabLayout() {

        fragments = new LinkedList<BaseFragment>(); //方便 遍历

        //初始化  数据
        fragments.add(new OnDoingFragment());
        fragments.add(new CompletedFragment());
        fragments.add(new HadOverFragment());

        //第一步：实现自定义  TabLayout  初始化 数据
        String[] mTitle = {"进行时","已完成","已关闭"};
        myTab = (MyTabLayout) findViewById(R.id.my_tab);
        myVp = (ViewPager) findViewById(R.id.my_viewPager);
        FragmentPagerAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),this,fragments);
        //第二步：初始化  导航
        //获取   表头数据
        myTab.setTabData(fragments);
        myVp.setAdapter(adapter);
        //第三步：分别设置监听事件：
        myTab.setOnTabSelectListener(new MyTabLayout.OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                myVp.setCurrentItem(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
        myVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                myTab.setCurrentTab(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
//---------------------------------------
    //初始化  Fragment
    private void initFragment() {

        fragments = new LinkedList<BaseFragment>(); //方便 遍历

        //初始化  数据
        fragments.add(new OnDoingFragment());
        fragments.add(new CompletedFragment());
        fragments.add(new HadOverFragment());

        tab = (TabLayout) findViewById(R.id.tab_title);
        tabViewPager = (ViewPager) findViewById(R.id.tab_viewpager);

        adapter = new FragmentAdapter(getSupportFragmentManager(),this,fragments);

        //第一步：设置适配器  给  ViewPager
        tabViewPager.setAdapter(adapter);
        //第二步：tab和  ViewPager联动显示 需要ViewPager 内部指定的Adapter
        // 必须要重写 getPageTitle() 方法   封装了 TabLayout 与 ViewPager的联动
        tab.setupWithViewPager(tabViewPager);
        //第三步：更新适配器
        adapter.notifyDataSetChanged();
        //第四步：设置  导航点击监听事件
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //实现联动效果
                tabViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
