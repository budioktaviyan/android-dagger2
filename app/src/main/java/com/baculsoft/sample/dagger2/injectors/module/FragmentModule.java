package com.baculsoft.sample.dagger2.injectors.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.baculsoft.sample.dagger2.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Module
public class FragmentModule {
    private final Fragment mFragment;

    public FragmentModule(final Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    public Context provideFragmentContext() {
        return mFragment.getContext();
    }
}