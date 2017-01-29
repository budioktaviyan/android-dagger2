package com.baculsoft.sample.dagger2.injectors.module;

import android.app.Activity;
import android.content.Context;

import com.baculsoft.sample.dagger2.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    public Context provideActivityContext() {
        return mActivity;
    }
}