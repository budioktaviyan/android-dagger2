package com.baculsoft.sample.dagger2.injectors.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}