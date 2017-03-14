/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Reflectorizer {
  // pretty output
  private static final String tab = "  ";
    
  public static void dumpAll(Class<?> klass, boolean includeAnnotations) {
    dumpClassInfo(klass, includeAnnotations);
    dumpFields(klass, includeAnnotations);
    dumpConstructors(klass, includeAnnotations);
    dumpMethods(klass, includeAnnotations);
  }
  
  public static void dumpClassInfo(Class<?> klass, boolean includeAnnotations) {
    checkRealClass(klass);
    Class<?> superClass = klass.getSuperclass();
    Class<?>[] interfaces = klass.getInterfaces();
    System.out.println("*** Class info for class " + klass.getTypeName() + " ***");
    
    System.out.println(tab + "Superclass: " + superClass.getTypeName());
    System.out.println(tab + "Implemented interfaces: " + ((interfaces.length == 0) ? "<none>" : ""));
    for (Class<?> intf : interfaces) {
      System.out.println(tab + tab + intf.getTypeName());
    }
    
    if (includeAnnotations) {
      processAnnotations(klass);
    }
    System.out.println();
  }
  
  public static void dumpFields(Class<?> klass, boolean includeAnnotations) {
    checkRealClass(klass);
    Field[] fields = klass.getDeclaredFields();
    System.out.println("*** Fields for class " + klass.getTypeName() + " ***");
    
    for (Field f : fields) {
      String name = f.getName();
      Class<?> type = f.getType();
      int modifiers = f.getModifiers();
      
      System.out.println(tab + "Name: " + name);
      System.out.println(tab + "Type: " + type.getTypeName());
      System.out.println(tab + "Modifiers: " + Modifier.toString(modifiers));
      System.out.println();
    }
  }

  public static void dumpConstructors(Class<?> klass, boolean includeAnnotations) {
    checkRealClass(klass);
    Constructor<?>[] ctors = klass.getDeclaredConstructors();
    System.out.println("*** Constructors for class " + klass.getTypeName() + " ***");
    
    for (Constructor<?> ctor : ctors) {
      String name = ctor.getName();  // of course, it's just the name of the class
      Parameter[] params = ctor.getParameters();
      int modifiers = ctor.getModifiers();
      
      System.out.println(tab + "Name: " + name);
      System.out.println(tab + "Parameters: " + ((params.length == 0) ? "<none>" : ""));
      for (Parameter param : params) {
        Class<?> paramType = param.getType();
        System.out.println(tab + tab + paramType.getTypeName());
      }
      System.out.println(tab + "Modifiers: " + Modifier.toString(modifiers));
      System.out.println();
    }
  }
  
  public static void dumpMethods(Class<?> klass, boolean includeAnnotations) {
    checkRealClass(klass);
    Method[] methods = klass.getDeclaredMethods();
    System.out.println("*** Methods for class " + klass.getTypeName() + " ***");
    
    for (Method m : methods) {
      String name = m.getName();
      Parameter[] params = m.getParameters();
      Class<?> returnType = m.getReturnType();
      int modifiers = m.getModifiers();
      
      System.out.println(tab + "Name: " + name);
      System.out.println(tab + "Parameters: " + ((params.length == 0) ? "<none>" : ""));
      for (Parameter param : params) {
        Class<?> paramType = param.getType();
        System.out.println(tab + tab + paramType.getTypeName());
      }
      System.out.println(tab + "Return type: " + returnType.getTypeName());
      System.out.println(tab + "Modifiers: " + Modifier.toString(modifiers));
      
      if (includeAnnotations) {
        processAnnotations(m);
      }
      System.out.println();
    }
  }
  
  /**
   * array type, primitive type, or void not considered a "real" class
   */
  private static void checkRealClass(Class<?> klass) {
    if (klass.isArray() || klass.isPrimitive() || klass.equals(void.class)) {
      throw new IllegalArgumentException(klass.getTypeName() + " is array type, primitive type, or void");
    }
  }

  /**
   * the arg passed in is actually a Method, Field, Constructor, or Class,
   * and we want to show its annotations
   */
  private static void processAnnotations(AnnotatedElement annotated) {
    Annotation[] annotations = annotated.getDeclaredAnnotations();
    System.out.println(tab + "Annotations: " + ((annotations.length == 0) ? "<none>" : ""));
    for (Annotation annt : annotations) {
      Class<? extends Annotation> annotationType = annt.annotationType();
      System.out.println(tab + tab + annotationType.getTypeName());
      for (Method m : annotationType.getDeclaredMethods()) {
        try {
          Object value = m.invoke(annt, (Object[]) null);
          System.out.println(tab + tab + tab + m.getName() + ": " + value);
        }
        catch (Exception ignored) { }
      }
    }
  }
  
  
  public static void main(String[] args)
  throws Exception {
    if (args.length == 0) {
      System.out.println("Usage: Reflectorizer <classname>");
      return;
    }
    dumpAll(Class.forName(args[0]), true);
  }
}