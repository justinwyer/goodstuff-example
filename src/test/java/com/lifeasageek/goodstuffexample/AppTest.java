package com.lifeasageek.goodstuffexample;

import com.lifeasageek.goodstuffexample.cdi.EntityManagerProducer;
import com.lifeasageek.goodstuffexample.cdi.EntityManagerWrapper;
import com.lifeasageek.goodstuffexample.cdi.Good;
import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Justin Wyer <jwyer@lifeasageek.com>
 */
@RunWith(Arquillian.class)
public class AppTest
{
   @Deployment
   public static JavaArchive createDeployment()
   {
      return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(
            GoodStuff.class, Good.class, EntityManagerProducer.class,
            EntityManagerWrapper.class).
            addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }
   @Inject
   private GoodStuff goodStuff;

   @Test
   public void testDoSomethingGood() throws Exception
   {
      goodStuff.doSomethingGood();
   }
}
