package com.crystallake.cod.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crystallake.cod.R;
import com.crystallake.cod.component.DaggerTestComponent;
import com.crystallake.cod.itf.ChoiceInstance;
import com.crystallake.cod.module.TestModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yds
 * on 2020/4/23.
 */
public class TestActivity extends Activity {
    @BindView(R.id.btn_test)
    public Button btn;

    @ChoiceInstance(choiceType = ChoiceInstance.ONE_PARAMS)
    @Inject
    Student mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(TestActivity.this);

        DaggerTestComponent.builder()
                .testModule(new TestModule("yds"))
                .build().inject(this);

    }

    @OnClick(R.id.btn_test)
    public void clickTest() {
        Toast.makeText(TestActivity.this, mStudent.getName(), Toast.LENGTH_SHORT).show();
    }
}
