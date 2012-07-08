package com.lifeasageek.goodstuffexample.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@Good
@Interceptor
public class GoodInterceptor
{
   @AroundInvoke
   public Object doOnlyGood(InvocationContext ctx) throws Exception
   {
      System.out.println("Do only good is better than do no evil right?");
      return ctx.proceed();
   }
}
