package com.lifeasageek.goodstuffexample;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@Path("/deed")
@RequestScoped
public class DeedService
{
   @Inject
   private GoodStuff goodStuff;
   
   @POST
   @Path("/good")
   public Response doGoodDeed()
   {
      goodStuff.doSomethingGood();
      try
      {
         return Response.created(new URI("http://www.lifeasageek.com")).build();
      }
      catch (URISyntaxException ex)
      {
         return Response.serverError().build();
      }
   }
}
