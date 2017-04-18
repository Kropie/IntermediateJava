/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;


import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

public class CollectorsTest {

    private Collection<MusicItem> allMusicItems;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog();
        allMusicItems = catalog.getAll();
    }

    @Test
    public void testCollectorsDefaultImpl() {
        // TODONE: obtain a List of music categories via Collectors.toList() and print the name of the List impl class
        List<MusicCategory> categoryList = allMusicItems.stream()
                .map(MusicItem::getMusicCategory)
                .collect(Collectors.toList());

        // TODONE: verify size of list via JUnit assertion (should be same as size of allMusicItems)
        assertTrue(categoryList.size() == allMusicItems.size());


        // TODONE: obtain a Set of music categories via Collectors.toSet() and print the name of the Set impl class


        // TODONE: verify size of set (hint: no duplicates)

    }

    @Test
    public void testCollectorsSpecifiedImpl() {
        // TODONE: obtain a Deque (double-ended queue, pronounced "deck") of music items, sorted by artist natural order
        // Use java.util.ArrayDeque as the implementation - it is a standard java.util collection
        ArrayDeque<MusicItem> arrayDeque = new ArrayDeque<>(allMusicItems.stream()
                .sorted(comparing(MusicItem::getArtist))
                .collect(toList()));

        // TODONE: verify the specified Deque impl class is being used

        // TODONE: verify first and last elements in the collection are what you expect (hint: see Deque API)
        // First artist is Aerosmith (id of 15), last artist is Yes (id of 16)
        assertTrue(arrayDeque.getFirst().getArtist().equals("Aerosmith"));
        assertTrue(arrayDeque.getLast().getId().equals(16L));
    }

    @Test
    public void testCollectorsReturnType() {
        // TODONE: change the type of the "result" variable from Object to a more specific, more meaningful type
        // Hint: See javadoc for Collectors.joining()
        String result = allMusicItems.stream()
                .filter(item -> item.getMusicCategory() == MusicCategory.POP)
                .map(MusicItem::getArtist)
                .sorted()
                .collect(Collectors.joining(" \\o/ "));

        // TODONE: write a JUnit assertion to verify the result value
        System.out.println(result);
    }
}
