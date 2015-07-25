package com.lab49.di.module;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * Created with IntelliJ IDEA.
 * User: Bolek
 * Date: 7/19/15
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, PARAMETER, METHOD})
@BindingAnnotation
public @interface Right {
}
