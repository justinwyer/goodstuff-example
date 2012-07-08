package com.lifeasageek.goodstuffexample;

import com.lifeasageek.goodstuffexample.cdi.Good;
import com.lifeasageek.goodstuffexample.cdi.Transactional;
import com.lifeasageek.goodstuffexample.entity.Deed;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@Transactional
@Good
public class GoodStuff implements Serializable
{
   private static final String[] altruists = {"Bill", "Melinda", "Warren", "Larry", "Richard"};
   private static final String[] recipients = {"John", "Jane", "Sally", "Simon", "Spot"};
    
   @Inject
   private EntityManager em;
   
   @PostConstruct
   private void init()
   {
      System.out.println("A GoodStuff bean has been constructed.");
   }
   
   public Deed doSomethingGood()
   {
      Deed deed = new Deed(altruists[new Random().nextInt(5)], recipients[new Random().nextInt(5)]);
      em.persist(deed);
      return deed;
   }
   
   public Deed doGoodDeed(String altruist, String recipient)
   {
      Deed deed = new Deed(altruist, recipient);
      em.persist(deed);
      return deed;
   }
   
   public Deed getDeed(Integer id)
   {
      return em.find(Deed.class, id);
   }
   
   public List<Deed> getDeeds()
   {
      return em.createQuery("select d from Deed d", Deed.class).getResultList();
   }
}
