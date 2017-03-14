/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-13 LearningPatterns Inc.
 */

package com.javatunes.persist;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;


// TODO: Add annotations to declare an entity class, and specify the correct database table name 
public class MusicItem {
   // properties

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   // TODO: Specify the correct database column name 
   private Long       id;
   private String     title;
   private String     artist;
   private BigDecimal price;


   public MusicItem() { }

   public MusicItem(String title,  String artist, BigDecimal price)
   {
      this.setTitle(title);
      this.setArtist(artist);
      this.setPrice(price);
   }

   public Long getId() { return id; }
   public String getTitle() { return title; }
   public String getArtist() { return artist; }
   public BigDecimal getPrice() { return price; }

   private void setId(Long id) { this.id = id; }
   public void setTitle(String title) { this.title = title; }
   public void setArtist(String artist) { this.artist = artist; }
   public void setPrice(BigDecimal price) { this.price = price; }

   // override Object.equals
   public boolean equals(Object compare)
   {
      boolean result = false;
      MusicItem other = null;

      if (compare instanceof MusicItem)
      {
         // cast to MusicItem
         other = (MusicItem) compare;

         // if all the ids are equal, the objects are equal
         result = other.getId().equals(this.getId()) ;
      }
      return result;
   }

   // override Object.toString
   public String toString()
   {
      return this.getClass().getName() +
         ": id=" + this.getId() +
         " title=" + this.getTitle() +
         " artist=" + this.getArtist() +
         " price=" + this.getPrice();
   }
}
