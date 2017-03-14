package org.hibernate.jpa;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import com.javatunes.jpa.MusicItem;

public class EntityClassRealizer {
  
  public static void main(String[] args)
  throws Exception {
    /*
     * Pretending you are the Hibernate code, you've just read a row from the ITEM 
     * table (ITEM_ID 19) and have extracted the column values from the result set.
     * 
     * Your job now is to instantiate a MusicItem from scratch and set its 
     * fields directly with these values (because the MusicItem developer 
     * chose to annotate its fields, versus its setter methods).
     * 
     * We've hardcoded the values below, but it's the same as if they were read from a table.
     */
    Long id = 19L;
    String num = "CD519";
    String title = "Greatest Hits";
    String artist = "Jay and the Americans";
    Date releaseDate = Date.valueOf("1966-12-05");
    BigDecimal listPrice = new BigDecimal("13.99");
    BigDecimal price = new BigDecimal("9.97");
    
    Class<MusicItem> klass = MusicItem.class;
    
    // create a MusicItem object via Class.newInstance()
    MusicItem item = klass.newInstance();
    
    // set all its fields directly
    Field idField = klass.getDeclaredField("id");
    idField.setAccessible(true);
    idField.set(item, id);
    
    Field numField = klass.getDeclaredField("num");
    numField.setAccessible(true);
    numField.set(item, num);
    
    Field titleField = klass.getDeclaredField("title");
    titleField.setAccessible(true);
    titleField.set(item, title);
    
    Field artistField = klass.getDeclaredField("artist");
    artistField.setAccessible(true);
    artistField.set(item, artist);
    
    Field releaseDateField = klass.getDeclaredField("releaseDate");
    releaseDateField.setAccessible(true);
    releaseDateField.set(item, releaseDate);
    
    Field listPriceField = klass.getDeclaredField("listPrice");
    listPriceField.setAccessible(true);
    listPriceField.set(item, listPrice);
    
    Field priceField = klass.getDeclaredField("price");
    priceField.setAccessible(true);
    priceField.set(item, price);
    
    System.out.println(item);
  }
}