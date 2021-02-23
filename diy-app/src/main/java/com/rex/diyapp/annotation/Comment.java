package com.rex.diyapp.annotation;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comment {

	String value() default "";

	String description() default "";

	Class<?> clazz() default Comment.class;

}