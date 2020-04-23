package com.crystallake.cod.component;

import android.content.Context;

import com.crystallake.cod.activity.MainActivity;
import com.crystallake.cod.module.BaseTabFPAdapterModule;

import dagger.Component;

/**
 * Created by yds
 * on 2020/4/23.
 */
@Component(modules = BaseTabFPAdapterModule.class)
public interface BaseTabFPAdapterComponent {
    void inject(MainActivity activity);
}
