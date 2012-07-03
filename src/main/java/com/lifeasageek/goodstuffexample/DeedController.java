package com.lifeasageek.goodstuffexample;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Justin Wyer <jwyer@rogueware.org>
 */
@Named
@SessionScoped
public class DeedController implements Serializable
{
   @Inject
   private GoodStuff goodStuff;
   
   private String altruist;
   private String recipient;
   private String response;
   
   @PostConstruct
   private void init()
   {
      System.out.println("A DeedController bean has been constructed.");
   }
   
   public void doGoodDeed()
   {
      response = goodStuff.doGoodDeed(altruist, recipient);
   }

   public String getAltruist()
   {
      return altruist;
   }

   public void setAltruist(String altruist)
   {
      this.altruist = altruist;
   }

   public String getRecipient()
   {
      return recipient;
   }

   public void setRecipient(String recipient)
   {
      this.recipient = recipient;
   }

   public String getResponse()
   {
      return response;
   }

   public void setResponse(String response)
   {
      this.response = response;
   }
}