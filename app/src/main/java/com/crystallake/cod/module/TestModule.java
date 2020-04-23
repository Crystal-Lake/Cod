package com.crystallake.cod.module;


import com.crystallake.cod.constants.ChoiceType;
import com.crystallake.cod.itf.ChoiceInstance;
import com.crystallake.cod.test.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yds
 * on 2020/4/23.
 */
@Module
public class TestModule {
    private String name;

    public TestModule(String name) {
        this.name = name;
    }

    @ChoiceInstance
    @Provides
    public Student provideStu() {
        return new Student();
    }

    @Provides
    public String provideName() {
        return name;
    }

    @ChoiceInstance(choiceType = ChoiceInstance.ONE_PARAMS)
    @Provides
    public Student provideStudent(String name) {
        return new Student(name);
    }
}
