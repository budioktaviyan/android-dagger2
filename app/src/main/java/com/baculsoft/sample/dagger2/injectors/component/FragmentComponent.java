package com.baculsoft.sample.dagger2.injectors.component;

import android.content.Context;

import com.baculsoft.sample.dagger2.injectors.module.FragmentModule;
import com.baculsoft.sample.dagger2.injectors.scope.ActivityContext;
import com.baculsoft.sample.dagger2.injectors.scope.FragmentScope;
import com.baculsoft.sample.dagger2.views.MainFragment;

import dagger.Component;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@FragmentScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { FragmentModule.class })
public interface FragmentComponent {

    @ActivityContext
    Context getContext();

    void inject(MainFragment mainFragment);
}