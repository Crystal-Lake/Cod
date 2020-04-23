package com.crystallake.cod.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crystallake.cod.R;
import com.crystallake.cod.adapter.BaseTabFragmentPagerAdapter;
import com.crystallake.cod.component.DaggerBaseTabFPAdapterComponent;
import com.crystallake.cod.fragment.AttentionFragment;
import com.crystallake.cod.fragment.HomeFragment;
import com.crystallake.cod.fragment.JevelFragment;
import com.crystallake.cod.fragment.MeFragment;
import com.crystallake.cod.fragment.NotificationFragment;
import com.crystallake.cod.itf.ChoiceInstance;
import com.crystallake.cod.module.BaseTabFPAdapterModule;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_bottom_tabLayout)
    public TabLayout mBottomTabLayout;
    @BindView(R.id.bottom_tab_viewpager)
    public ViewPager mBottomViewPager;

    private List<Fragment> mFragmentList;

    @ChoiceInstance(choiceType = ChoiceInstance.TWO_PARAMS)
    @Inject
    public BaseTabFragmentPagerAdapter mAdapter;


    private int[] mTabImages = new int[]{
            R.drawable.tabbar_subscription_img_selecter,
            R.drawable.tabbar__follow_img_selecter,
            R.drawable.tabbar_jewel_img_selecter,
            R.drawable.tabbar_notification_img_selecter,
            R.drawable.tabbar_me_img_selecter
    };
    private String[] mTabTitles = new String[]{"首页", "关注", "简书钻", "消息", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setTabs(mTabTitles, mTabImages);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new AttentionFragment());
        mFragmentList.add(new JevelFragment());
        mFragmentList.add(new NotificationFragment());
        mFragmentList.add(new MeFragment());

        DaggerBaseTabFPAdapterComponent.builder()
                .baseTabFPAdapterModule(new BaseTabFPAdapterModule(getSupportFragmentManager(), mFragmentList))
                .build().inject(this);

        mBottomViewPager.setAdapter(mAdapter);

        mBottomViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBottomTabLayout));
        mBottomTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mBottomViewPager));
    }

    private void setTabs(String[] bottomTabTitles, int[] bottomTabImages) {
        if (bottomTabImages != null && bottomTabTitles != null) {
            for (int i = 0; i < bottomTabTitles.length; i++) {
                TabLayout.Tab tab = mBottomTabLayout.newTab();
                View view = getLayoutInflater().inflate(R.layout.main_module_layout_home_tab_item, null);
                tab.setCustomView(view);

                TextView tabTitle = view.findViewById(R.id.home_item_tv);
                tabTitle.setText(bottomTabTitles[i]);


                ImageView tabImage = view.findViewById(R.id.home_item_iv);
                tabImage.setImageResource(bottomTabImages[i]);
                if (i == 0) {
                    mBottomTabLayout.addTab(tab, true);
                } else {
                    mBottomTabLayout.addTab(tab, false);
                }
            }
        }

    }

}
