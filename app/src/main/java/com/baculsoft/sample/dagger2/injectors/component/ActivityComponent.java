package com.baculsoft.sample.dagger2.injectors.component;

import android.content.Context;

import com.baculsoft.sample.dagger2.injectors.module.ActivityModule;
import com.baculsoft.sample.dagger2.injectors.scope.ActivityContext;
import com.baculsoft.sample.dagger2.injectors.scope.ActivityScope;
import com.baculsoft.sample.dagger2.views.MainActivity;

import dagger.Component;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { ActivityModule.class })
public interface ActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(MainActivity mainActivity);
}