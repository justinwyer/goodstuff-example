package com.lifeasageek.goodstuffexample;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
public class App
{

   private static String[] jettyConfigurationClasses =
   {
      "org.eclipse.jetty.webapp.WebInfConfiguration",
      "org.eclipse.jetty.webapp.WebXmlConfiguration",
      "org.eclipse.jetty.webapp.MetaInfConfiguration",
      "org.eclipse.jetty.webapp.FragmentConfiguration",
      "org.eclipse.jetty.plus.webapp.EnvConfiguration",
      "org.eclipse.jetty.webapp.JettyWebXmlConfiguration"
   };
   private static Server server;

   private static void initServer()
   {
      try
      {
         server = new Server(8080);
         HandlerList handlerList = new HandlerList();

         WebAppContext webapp = new WebAppContext();
         webapp.setConfigurationClasses(jettyConfigurationClasses);

         String webappPath = App.class.getClassLoader().getResource("webapp").toExternalForm();

         webapp.setDescriptor(webappPath + "/WEB-INF/web.xml");
         webapp.setContextPath("/");
         webapp.setResourceBase(webappPath);
         webapp.setClassLoader(Thread.currentThread().getContextClassLoader());


         ServletContextHandler servletContextHandler;
         servletContextHandler = new ServletContextHandler(getServer(), "/", ServletContextHandler.SESSIONS);

         ResourceHandler resourceHandler = new ResourceHandler();
         resourceHandler.setResourceBase(webappPath);

         handlerList.addHandler(servletContextHandler);
         handlerList.addHandler(resourceHandler);
         handlerList.addHandler(webapp);
         getServer().setHandler(handlerList);
         getServer().start();
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
      root.setLevel(Level.INFO);
      initServer();
   }

   /**
    * @return the server
    */
   public static Server getServer()
   {
      return server;
   }
}
