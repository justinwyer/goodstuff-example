package com.lifeasageek.goodstuffexample;

import java.io.IOException;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.servlet.*;
import org.eclipse.jetty.plus.jndi.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
public class AppServlet implements Servlet
{
   Logger log = LoggerFactory.getLogger(AppServlet.class);
   
   @Inject
   private GoodStuff goodStuff;

   @Override
   public void init(ServletConfig sc) throws ServletException
   {
      try
      {
         App.getServer().join();
      }
      catch (InterruptedException ex)
      {
         log.error(ex.getMessage(), ex);
      }
      
      // Lets do something good!
      goodStuff.doSomethingGood();
   }

   @Override
   public ServletConfig getServletConfig()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void service(ServletRequest sr, ServletResponse sr1) throws ServletException, IOException
   {
   }

   @Override
   public String getServletInfo()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void destroy()
   {
   }
}
