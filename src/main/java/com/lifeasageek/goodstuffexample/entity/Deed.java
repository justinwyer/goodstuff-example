package com.lifeasageek.goodstuffexample.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Justin Wyer <justin@lifeasageek.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Deed implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   @Column
   private String altruist;
   @Column
   private String recipient;

   public Deed()
   {
   }

   public Deed(String altruist, String recipient)
   {
      this.altruist = altruist;
      this.recipient = recipient;
   }

   /**
    * @return the id
    */
   public Integer getId()
   {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(Integer id)
   {
      this.id = id;
   }

   /**
    * @return the altruist
    */
   public String getAltruist()
   {
      return altruist;
   }

   /**
    * @param altruist the altruist to set
    */
   public void setAltruist(String altruist)
   {
      this.altruist = altruist;
   }

   /**
    * @return the recipient
    */
   public String getRecipient()
   {
      return recipient;
   }

   /**
    * @param recipient the recipient to set
    */
   public void setRecipient(String recipient)
   {
      this.recipient = recipient;
   }
}
