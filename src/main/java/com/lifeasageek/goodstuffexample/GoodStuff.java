package com.lifeasageek.goodstuffexample;

import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Justin Wyer <jwyer@lifeasageek.com>
 */
@Good
public class GoodStuff implements Serializable
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
   
   public String doGoodDeed(String altruist, String recipient)
   {
      return String.format("%s did a good deed for %s", altruist, recipient);
   }
}
