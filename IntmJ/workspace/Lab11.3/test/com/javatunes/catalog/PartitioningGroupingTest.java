/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;
import org.junit.Before;
import org.junit.Test;

public class PartitioningGroupingTest {

    private Collection<MusicItem> allMusicItems;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog();
        allMusicItems = catalog.getAll();
    }

    /**
     * TASK: partition MusicItems into self-titled albums (artist = title), and all others.
     * <p>
     * RESULT:
     * true    List<MusicItem>[6,7]
     * false   List<MusicItem>[1,2,3,4,5,8,9,10,11,12,13,14,15,16,17,18]
     */
    @Test
    public void testPartitionBySelfTitled() {
        Map<Boolean, List<MusicItem>> itemMap = allMusicItems.stream()
                .collect(partitioningBy(item -> item.getArtist().equals(item.getTitle())));

        // all partition maps have exactly two entries, one of the entries might contain an empty List
        assertEquals(2, itemMap.size());

        List<MusicItem> trueList = itemMap.get(true);
        List<MusicItem> falseList = itemMap.get(false);

        assertEquals(2, trueList.size());
        assertEquals(16, falseList.size());

        // A neat JUnit technique
        // Recall that Collection has a forEach(Consumer) method
        // However, this isn't testing your code, it just verifies that partitioningBy works correctly (it better!)
        trueList.forEach(item -> assertTrue(item.getArtist().equals(item.getTitle())));
        falseList.forEach(item -> assertFalse(item.getArtist().equals(item.getTitle())));

        // convenient way to dump a Map to stdout
        dumpMap(itemMap);
    }

    /**
     * TASK: partition MusicItems by price <= 14.00.
     * <p>
     * RESULT:
     */
    @Test
    public void testPartitionByPrice() {
        // TODONE
        Map<Boolean, List<MusicItem>> pricePartition = allMusicItems.stream()
                .collect(Collectors.partitioningBy(o -> o.getPrice() >= 14.00));

        List<MusicItem> lessThanList = pricePartition.get(false);
        List<MusicItem> moreThanList = pricePartition.get(true);

        lessThanList.forEach(musicItem -> assertTrue(musicItem.getPrice() < 14.00));
        moreThanList.forEach(musicItem -> assertTrue(musicItem.getPrice() >= 14.00));
    }

    /**
     * TASK: partition MusicItems into ROCK+CLASSIC_ROCK, and all others. Verify.
     * <p>
     * RESULT:
     */
    @Test
    public void testPartitionByMusicCategoryRock() {
        // TODONE
        Map<Boolean, List<MusicItem>> partitionMap = allMusicItems.stream()
                .collect(partitioningBy(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.ROCK)
                        || musicItem.getMusicCategory().equals(MusicCategory.POP)));

        List<MusicItem> popRockList = partitionMap.get(true);
        List<MusicItem> notList = partitionMap.get(false);

        popRockList.forEach(musicItem -> assertTrue(musicItem.getMusicCategory().equals(MusicCategory.ROCK)
                || musicItem.getMusicCategory().equals(MusicCategory.POP)));
        notList.forEach(musicItem -> assertFalse(musicItem.getMusicCategory().equals(MusicCategory.ROCK)
                || musicItem.getMusicCategory().equals(MusicCategory.POP)));
    }

    /**
     * TASK: group MusicItems by music category. Verify each entry in the map.
     * <p>
     * RESULT:
     */
    @Test
    public void testGroupByMusicCategory() {
        // TODONE
        Map<MusicCategory, List<MusicItem>> musicCategoryListMap = allMusicItems.stream()
                .collect(groupingBy(MusicItem::getMusicCategory));

        List<MusicCategory> musicCategoryList = Arrays.asList(MusicCategory.values());
        musicCategoryList.forEach(musicCategory -> {
            if (musicCategoryListMap.containsKey(musicCategory))
                musicCategoryListMap.get(musicCategory).forEach(musicItem -> musicItem.getMusicCategory().equals
                        (musicCategory));
        });
    }

    /**
     * TASK: group MusicItems by price and verify.
     * <p>
     * RESULT:
     */
    @Test
    public void testGroupByPrice() {
        // TODONE
        Map<Double, List<MusicItem>> musicCategoryListMap = allMusicItems.stream()
                .collect(groupingBy(MusicItem::getPrice));

        musicCategoryListMap.keySet().forEach(aDouble -> musicCategoryListMap.get(aDouble).forEach(musicItem ->
                assertTrue(musicItem.getPrice().equals(aDouble))));
    }

    /*
     * Helper method to dump map to standard out. Map is assumed to have entries with Collections.
     */
    private static void dumpMap(Map<?, ? extends Collection<?>> map) {
        map.entrySet().forEach(System.out::println);
        System.out.println();

        // Map.forEach() takes a BiConsumer<K,V>. This block lambda is passed key-value pairs each iteration.
        map.forEach((key, list) -> {
            System.out.println(key);
            list.forEach(System.out::println);
        });
    }
}