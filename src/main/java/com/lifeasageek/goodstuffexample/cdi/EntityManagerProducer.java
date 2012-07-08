package com.lifeasageek.goodstuffexample.cdi;

import java.util.Stack;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@ApplicationScoped
public class EntityManagerProducer
{
   private static EntityManagerFactory emf;
   
   private static ThreadLocal<Stack<EntityManager>> threadEntityManagers = new ThreadLocal<>();
   
   public void register(boolean requireNew)
   {
      if (emf == null)
      {
         emf = Persistence.createEntityManagerFactory("goodstuff");
      }
      if (threadEntityManagers.get() == null)
      {
         threadEntityManagers.set(new Stack<EntityManager>());
      }
      Stack<EntityManager> emStack = threadEntityManagers.get();
      if (emStack.isEmpty())
      {
         emStack.push(emf.createEntityManager());
      }
      else
      {
         EntityManager em = emStack.peek();
         EntityTransaction tx = em.getTransaction();
         if (tx.isActive() && requireNew)
         {
            emStack.push(emf.createEntityManager());
         }
      }
   }
   
   public EntityManager get()
   {
      Stack<EntityManager> emStack = threadEntityManagers.get();
      if (emStack == null || emStack.isEmpty())
      {
         register(false);
         emStack = threadEntityManagers.get();
      }
      EntityManager em = emStack.peek();
      return em;
   }
   
   public void unregister(EntityManager em)
   {
      Stack<EntityManager> emStack = threadEntityManagers.get();
      emStack.remove(em);
   }    
}
