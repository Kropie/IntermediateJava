package demo.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Collection has an abstract factory method called iterator() which returns an Iterator (interface type)
 * different collections return different types of Iterators
 * the "$" in the classname indicates an inner class (discussed later)
 */
public class IteratorTest {
  
  public static void main(String[] args) {
    Collection<String> names1 = new ArrayList<>();
    System.out.println("ArrayList: " + names1.iterator().getClass().getName());
    
    Collection<String> names2 = new LinkedList<>();
    System.out.println("LinkedList: " + names2.iterator().getClass().getName());

    Collection<String> names3 = new HashSet<>();
    System.out.println("HashSet: " + names3.iterator().getClass().getName());
    
    Collection<String> names4 = new LinkedHashSet<>();
    System.out.println("LinkedHashSet: " + names4.iterator().getClass().getName());
  }
}