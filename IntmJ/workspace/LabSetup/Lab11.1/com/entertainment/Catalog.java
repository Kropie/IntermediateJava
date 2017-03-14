/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

package com.entertainment;

import java.util.ArrayList;
import java.util.Collection;

public class Catalog
{
   // catalog of Television objects
   private static Collection<Television> c_catalog = new ArrayList<Television>();   
   
   // searches catalog by brand
   public static Collection<Television> searchByBrand(String brand)
   {
      // create a bucket for results
      Collection<Television> result = new ArrayList<Television>();
      
      // iterate through our catalog, looking for a match
      for (Television tv : c_catalog) 
      {
         if (tv.getBrand().equals(brand))
         {
            result.add(tv);
         }
      }
      
      // return the result
      return result;
   }
   
   // return entire catalog
   public static Collection<Television> getInventory()
   {
      return c_catalog;
   }
      
   // loads catalog with data
   static
   {
       try {

    	   Television newTV;
    	   	   
    	   newTV = new Television();
    	   newTV.setBrand("Zenith");
    	   newTV.setVolume(0);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Sony");
    	   newTV.setVolume(4);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Sony");
    	   newTV.setVolume(94);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Zenith");
    	   newTV.setVolume(33);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("RCA");
    	   newTV.setVolume(54);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Zenith");
    	   newTV.setVolume(86);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Hitachi");
    	   newTV.setVolume(13);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Hitachi");
    	   newTV.setVolume(40);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Zenith");
    	   newTV.setVolume(46);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("RCA");
    	   newTV.setVolume(36);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("Sony");
    	   newTV.setVolume(97);
    	   c_catalog.add(newTV);
    	   newTV = new Television();
    	   newTV.setBrand("RCA");
    	   newTV.setVolume(2);
    	   c_catalog.add(newTV);

    	   PortableTelevision newPTV;

    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Sony");
    	   newPTV.setVolume(33);
    	   newPTV.setRechargeLevel(30);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Hitachi");
    	   newPTV.setVolume(87);
    	   newPTV.setRechargeLevel(10);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Zenith");
    	   newPTV.setVolume(37);
    	   newPTV.setRechargeLevel(20);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("RCA");
    	   newPTV.setVolume(31);
    	   newPTV.setRechargeLevel(3);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Sony");
    	   newPTV.setVolume(87);
    	   newPTV.setRechargeLevel(8);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Hitachi");
    	   newPTV.setVolume(39);
    	   newPTV.setRechargeLevel(9);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Zenith");
    	   newPTV.setVolume(27);
    	   newPTV.setRechargeLevel(21);
    	   c_catalog.add(newPTV);
    	   newPTV = new PortableTelevision();
    	   newPTV.setBrand("Zenith");
    	   newPTV.setVolume(12);
    	   newPTV.setRechargeLevel(21);
    	   c_catalog.add(newPTV);

    	   ColorTelevision newCTV;

    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("RCA");
    	   newCTV.setVolume(10);
    	   newCTV.setColorTint(4);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("Hitachi");
    	   newCTV.setVolume(44);
    	   newCTV.setColorTint(3);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("RCA");
    	   newCTV.setVolume(4);
    	   newCTV.setColorTint(9);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("RCA");
    	   newCTV.setVolume(2);
    	   newCTV.setColorTint(1);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("RCA");
    	   newCTV.setVolume(39);
    	   newCTV.setColorTint(6);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("Sony");
    	   newCTV.setVolume(28);
    	   newCTV.setColorTint(2);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("Zenith");
    	   newCTV.setVolume(5);
    	   newCTV.setColorTint(6);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("Zenith");
    	   newCTV.setVolume(65);
    	   newCTV.setColorTint(17);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("Sony");
    	   newCTV.setVolume(22);
    	   newCTV.setColorTint(15);
    	   c_catalog.add(newCTV);
    	   newCTV = new ColorTelevision();
    	   newCTV.setBrand("RCA");
    	   newCTV.setVolume(87);
    	   newCTV.setColorTint(11);
    	   c_catalog.add(newCTV);

       }
       catch (Exception e) { e.printStackTrace(); }
   }
}
