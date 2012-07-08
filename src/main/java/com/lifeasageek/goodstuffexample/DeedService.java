package com.lifeasageek.goodstuffexample;

import com.lifeasageek.goodstuffexample.entity.Deed;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@Path("deed")
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
   
   @POST
   public Response doDeed(@FormParam("altruist") String altruist, @FormParam("recipient") String recipient)
   {
      Deed deed = goodStuff.doGoodDeed(altruist, recipient);
      try
      {
         return Response.created(new URI("http://localhost:8080/rest/deed/" + deed.getId())).build();
      }
      catch (URISyntaxException ex)
      {
         return Response.serverError().build();
      }
   }
   
   @GET
   @Path("/{id}")
   public Deed getDeed(@PathParam("id") Integer id)
   {
      return goodStuff.getDeed(id);
   }
   
   @GET
   public List<Deed> getDeeds()
   {
      return goodStuff.getDeeds();
   }
}
