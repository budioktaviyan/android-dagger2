package com.baculsoft.sample.dagger2;

import android.app.Application;

import com.baculsoft.sample.dagger2.injectors.component.ApplicationComponent;
import com.baculsoft.sample.dagger2.injectors.component.DaggerApplicationComponent;
import com.baculsoft.sample.dagger2.injectors.module.ApplicationModule;
import com.baculsoft.sample.dagger2.injectors.module.UtilityModule;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class App extends Application {
    private static volatile ApplicationComponent component;

    public static synchronized ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                                              .applicationModule(new ApplicationModule(this))
                                              .utilityModule(new UtilityModule())
                                              .build();
    }
}