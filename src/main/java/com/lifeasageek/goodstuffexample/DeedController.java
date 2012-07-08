package com.lifeasageek.goodstuffexample;

import com.lifeasageek.goodstuffexample.entity.Deed;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
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
   private List<Deed> deeds;
   
   @PostConstruct
   private void init()
   {
      System.out.println("A DeedController bean has been constructed.");
      loadDeeds();
   }
   
   private void loadDeeds()
   {
      deeds = goodStuff.getDeeds();
   }
   
   public void doGoodDeed()
   {
      Deed deed = goodStuff.doGoodDeed(altruist, recipient);
      response = String.format("%s did something good for %s.", deed.getAltruist(), deed.getRecipient());
      loadDeeds();
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

   /**
    * @return the deeds
    */
   public List<Deed> getDeeds()
   {
      return deeds;
   }
}