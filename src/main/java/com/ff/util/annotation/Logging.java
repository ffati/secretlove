package com.ff.util.annotation;

import java.lang.annotation.*;

/**
 * @author: ff
 * @date: 2020/1/15 18:22
 * @param:
 * @return:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Logging {

    String description() default "";

}
