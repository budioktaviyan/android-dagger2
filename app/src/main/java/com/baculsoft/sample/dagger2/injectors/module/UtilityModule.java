package com.baculsoft.sample.dagger2.injectors.module;

import com.baculsoft.sample.dagger2.utils.Commons;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Module
public class UtilityModule {

    @Provides
    @Singleton
    public Commons provideCommonUtils() {
        return new Commons();
    }
}