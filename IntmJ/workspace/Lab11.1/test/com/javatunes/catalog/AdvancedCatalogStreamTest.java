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

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class AdvancedCatalogStreamTest {

    private Collection<MusicItem> allMusicItems;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog();
        allMusicItems = catalog.getAll();
    }

    /**
     * TASK: determine average price of our low-cost, extensive catalog of music.
     * <p>
     * RESULT: 15.309 (via calculator)
     */
    @Test
    public void testAveragePrice() {
        OptionalDouble avgPriceOptional = allMusicItems.stream()
                .mapToDouble(MusicItem::getPrice)  // item -> item.getPrice()
                .average();
        double avgPrice = (avgPriceOptional.isPresent()) ? avgPriceOptional.getAsDouble() : 0D;

        assertEquals(15.309, avgPrice, .001);
    }

    /**
     * TASK: determine the titles of all "pop" items, sorted by natural order.
     * <p>
     * RESULT:
     */
    @Test
    public void testTitlesPopSortNaturalOrder() {
        List<MusicItem> popItems = allMusicItems.stream()
                .filter(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.POP))
                .sorted(comparing(MusicItem::getTitle))
                .collect(toList());

        assertEquals(Long.valueOf(1L), popItems.get(0).getId());
        assertEquals(Long.valueOf(14L), popItems.get(popItems.size() -1).getId());
    }

    /**
     * TASK: are all items priced at least $10?
     * <p>
     * RESULT:
     */
    @Test
    public void testAllPriceGreaterThanEqual() {
        boolean areItemsPricedGreaterThanTenDollars = allMusicItems.stream()
                .allMatch(musicItem -> musicItem.getPrice() >= 10);

        assertFalse(areItemsPricedGreaterThanTenDollars);
    }

    /**
     * TASK: do we sell any "jazz" items?
     * <p>
     * RESULT:
     */
    @Test
    public void testAnyMusicCategory() {
        boolean anyJazzAlbums = allMusicItems.stream()
                .anyMatch(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.JAZZ));

        assertFalse(anyJazzAlbums);
    }

    /**
     * TASK: how many "blues" items do we sell?
     * <p>
     * RESULT:
     */
    @Test
    public void testCountMusicCategory() {
        long bluesItemCount = allMusicItems.stream()
                .filter(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.BLUES))
                .count();

        assertEquals(2L, bluesItemCount);
    }

    /**
     * TASK: print to stdout any 3 "rock" items.
     * <p>
     * RESULT:
     */
    @Test
    public void testPrintAny3MusicCategory() {
        allMusicItems.stream()
                .filter(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.ROCK))
                .peek(System.out::println)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * TASK: determine the average price of the 3 most recent items we sell.
     * <p>
     * RESULT:
     */
    @Test
    public void testAvgPrice3Newest() {
        OptionalDouble optionalDouble = allMusicItems.stream()
                .sorted(comparing(MusicItem::getReleaseDate))
                .limit(3)
                .mapToDouble(MusicItem::getPrice)
                .average();

        assertEquals(11.97D, optionalDouble.getAsDouble(), 0.00001);
    }

    /**
     * TASK: determine the 2 highest-priced MusicItems, sorted by title.
     * HINT: you will need to sort twice in the pipeline.
     * <p>
     * RESULT:
     */
    @Test
    public void testPrice2HighestSortTitle() {
        List<MusicItem> items = allMusicItems.stream()
                .sorted(comparing(MusicItem::getPrice).reversed())
                .limit(2)
                .sorted(comparing(MusicItem::getTitle))
                .collect(Collectors.toList());

        assertEquals(2, items.size());
        assertEquals(Long.valueOf(15L), items.get(0).getId());
        assertEquals(Long.valueOf(12L), items.get(1).getId());
    }

    /**
     * TASK: what is the price of our cheapest "pop" item?
     * <p>
     * RESULT:
     */
    @Test
    public void testMinPriceMusicCategory() {
        double minPopAlbumPrice = allMusicItems.stream()
                .filter(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.POP))
                .mapToDouble(MusicItem::getPrice)
                .min()
                .getAsDouble();

        assertEquals(13.99D, minPopAlbumPrice, 0.0D);
    }
}