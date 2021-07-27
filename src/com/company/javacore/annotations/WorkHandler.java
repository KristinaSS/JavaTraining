package com.company.javacore.annotations;

import javafx.beans.DefaultProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* retention source - exits only in source file, discarded by compiler
* retention class - compiled into class file, discarded at runtime
* retention runtime - loaded into runtime, accessible with reflection
* */
//order doesn't matter
@Target(ElementType.METHOD) //say what your annotation target type is gonna be
@Retention(RetentionPolicy.RUNTIME)// say when you want your annotation to be available
public @interface WorkHandler {
    //Creating annotations

    boolean useThreadPool();

    // @WorkHandler (useThreadPool = false)
}
