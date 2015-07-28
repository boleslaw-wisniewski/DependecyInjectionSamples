package com.lab49.di;

import java.lang.annotation.Retention;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.inject.Singleton;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Singleton
public class JSR330AtAGlance
{
    @Inject
    @Named("basic")
    Provider<MessageFormat> format;

    @Scope
    @Retention(RUNTIME)
    public @interface PerThread {}

    @Qualifier
    @Retention(RUNTIME)
    public @interface Logger {}
}
