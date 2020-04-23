package com.crystallake.cod.component;

import android.widget.ImageView;

import com.crystallake.cod.module.TestModule;
import com.crystallake.cod.test.TestActivity;

import dagger.Component;

/**
 * Created by yds
 * on 2020/4/23.
 */

@Component(modules = TestModule.class)
public interface TestComponent {
    void inject(TestActivity activity);
}
