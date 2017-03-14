/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-13 LearningPatterns Inc.
 */

package com.javatunes.persist.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.javatunes.persist.MusicItem;

public class JPATest {
	public static void main(String[] args) {

		// TODO: Initialize the EMF and the EM
		EntityManagerFactory emf = null; 
		EntityManager em = null;
		
		try	{
			em.getTransaction().begin();
			Long id = new Long(1);
			// TODO: Use the EntityManger to find the MusicItem by the id declared above. 
			MusicItem m = null; 
			System.out.println(m);
			System.out.println("***");

/*
// TODO: Uncomment for last JPA lab			
		    TypedQuery<MusicItem> q = em.createQuery(
		            "SELECT mi FROM MusicItem mi WHERE mi.artist = 'Madonna'", 
		            MusicItem.class);
			List<MusicItem> resultList = q. getResultList();
			for (MusicItem cur : resultList) {
				System.out.println(cur);
			}
			System.out.println("***");
			
			MusicItem newItem = new MusicItem();
			newItem.setArtist("Madonna");
			newItem.setTitle("Material Girl");
			em.persist(newItem);

			// Query again - should have our new item.
			resultList = q. getResultList();
			for (MusicItem cur : resultList) {
				System.out.println(cur);
			}
*/

			em.getTransaction().commit();
		} 
		catch (Exception ex) { ex.printStackTrace(); }
		finally { 
			em.close();
			emf.close();
		}
	}
}
