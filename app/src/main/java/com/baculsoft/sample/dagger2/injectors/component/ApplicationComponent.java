package com.baculsoft.sample.dagger2.injectors.component;

import android.app.Application;
import android.content.Context;

import com.baculsoft.sample.dagger2.injectors.module.ApplicationModule;
import com.baculsoft.sample.dagger2.injectors.module.UtilityModule;
import com.baculsoft.sample.dagger2.injectors.scope.ApplicationContext;
import com.baculsoft.sample.dagger2.utils.Commons;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        UtilityModule.class
})
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    void inject(Application application);

    // Utility Module
    Commons getCommonUtils();
}