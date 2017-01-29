package com.baculsoft.sample.dagger2.injectors.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}