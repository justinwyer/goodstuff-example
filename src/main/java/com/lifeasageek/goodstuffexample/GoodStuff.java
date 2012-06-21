package com.lifeasageek.goodstuffexample;

import javax.annotation.PostConstruct;

/**
 *
 * @author Justin Wyer <jwyer@lifeasageek.com>
 */
@Good
public class GoodStuff
{
   @PostConstruct
   private void init()
   {
      System.out.println("A GoodStuff bean has been constructed.");
   }
   
   public void doSomethingGood()
   {
      System.out.println("Something good just happened!");
   }
         
}
