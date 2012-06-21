package com.lifeasageek.goodstuffexample;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Justin Wyer <jwyer@lifeasageek.com>
 */
@Good
@Interceptor
public class GoodInterceptor
{
   @AroundInvoke
   public void doOnlyGood(InvocationContext ctx) throws Exception
   {
      System.out.println("Do only good is better than do no evil right?");
      ctx.proceed();
   }
}
