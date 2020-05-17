package com.sitech.aicp.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoggerAnnotation {
    String value() default "";
}
