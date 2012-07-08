package com.lifeasageek.goodstuffexample.cdi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional
{
}
