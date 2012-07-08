package com.lifeasageek.goodstuffexample.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@Transactional
@Interceptor
public class TransactionInterceptor
{
   @Inject
   private EntityManagerProducer emp;
   private boolean owner = false;
   private EntityTransaction tx;
   
   @AroundInvoke 
   public Object manageTransaction(InvocationContext ctx) throws Exception
   {
      emp.register(false);
      EntityManager em = emp.get();
      em.setFlushMode(FlushModeType.COMMIT);
      tx = em.getTransaction();
      try
      {
         if (!tx.isActive())
         {
            tx.begin();
            owner = true;
         }
         Object result = ctx.proceed();
         if (tx.isActive() && owner)
         {
            tx.commit();
         }
         return result;
      }
      catch (Exception ex)
      {
         if (tx.isActive() && !owner)
         {
            tx.setRollbackOnly();
         }
         if (tx.isActive() && owner)
         {
            tx.rollback();
         }
         throw ex;
      }
      finally
      {
         try
         {
            if (tx.isActive() && tx.getRollbackOnly() && owner)
            {
                tx.rollback();
            }
         }
         catch (Exception ex)
         {
             // Something is horribly wrong!
             ex.printStackTrace();
         }
         finally
         {
            if (owner)
            {
                emp.unregister(em);
                em.close();
            }
         }
      }
   }
}
