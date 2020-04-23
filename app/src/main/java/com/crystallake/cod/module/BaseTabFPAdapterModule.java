package com.crystallake.cod.module;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.crystallake.cod.adapter.BaseTabFragmentPagerAdapter;
import com.crystallake.cod.itf.ChoiceInstance;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yds
 * on 2020/4/23.
 */
@Module
public class BaseTabFPAdapterModule {
    private FragmentManager fm;
    private List<Fragment> mFragmentList;
    public BaseTabFPAdapterModule(FragmentManager fm, List<Fragment> mFragmentList){
        this.fm = fm;
        this.mFragmentList = mFragmentList;
    }

    @ChoiceInstance(choiceType = ChoiceInstance.TWO_PARAMS)
    @Provides
    public BaseTabFragmentPagerAdapter provideBaseTFPA(FragmentManager fm, List<Fragment> mFragmentList){
        return new BaseTabFragmentPagerAdapter(fm,mFragmentList);
    }

    @Provides
    public FragmentManager provideFragmentManager(){
        return fm;
    }

    @Provides
    public List<Fragment> provideList(){
        return mFragmentList;
    }
}
