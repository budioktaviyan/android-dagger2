package com.baculsoft.sample.dagger2.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.baculsoft.sample.dagger2.App;
import com.baculsoft.sample.dagger2.R;
import com.baculsoft.sample.dagger2.injectors.component.ActivityComponent;
import com.baculsoft.sample.dagger2.injectors.component.DaggerActivityComponent;
import com.baculsoft.sample.dagger2.injectors.module.ActivityModule;
import com.baculsoft.sample.dagger2.utils.Commons;

import javax.inject.Inject;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainActivity extends AppCompatActivity {

    @Inject
    MainFragment mFragment;

    @Inject
    Commons mCommonUtils;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInjector();
        initToolbar();
        showMessage();
        addButtonListener();
    }

    private void initInjector() {
        ActivityComponent component = DaggerActivityComponent.builder()
                                                             .applicationComponent(App.getComponent())
                                                             .activityModule(new ActivityModule(this))
                                                             .build();
        component.inject(this);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
    }

    private void showMessage() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_main);
        mCommonUtils.makeSnackbar(relativeLayout, "Welcome!").show();
    }

    private void addButtonListener() {
        Button button = (Button) findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_main, mFragment, MainFragment.class.getSimpleName());
                fragmentTransaction.commit();
            }
        });
    }
}