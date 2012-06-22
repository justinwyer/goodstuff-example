package com.lifeasageek.goodstuffexample;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
public class RestConfig extends Application
{
   @Override
   public Set<Class<?>> getClasses()
   {
      Set<Class<?>> classes = new HashSet<>();
      classes.add(DeedService.class);
      return classes;
   }
}
