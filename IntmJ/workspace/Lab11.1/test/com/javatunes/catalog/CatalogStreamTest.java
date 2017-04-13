/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class CatalogStreamTest {

    private Collection<MusicItem> allMusicItems;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog();
        allMusicItems = catalog.getAll();
    }

    /**
     * TASK: find all MusicItems whose artist starts with "D" and sort them by price.
     * <p>
     * RESULT: MusicItems 11 and 10, in that order.
     */
    @Test
    public void testArtistStartsWithSortPrice() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(item -> item.getArtist().startsWith("D"))
                .sorted(Comparator.comparing(item -> item.getPrice()))
                .collect(Collectors.toList());

        assertEquals(2, items.size());
        assertEquals(Long.valueOf(11), items.get(0).getId());
        assertEquals(Long.valueOf(10), items.get(1).getId());
    }

    /**
     * TASK: find all MusicItems where title is same as artist and sort them by natural order.
     * MusicItem implements Comparable: natural order is id increasing.
     * <p>
     * RESULT:
     */
    @Test
    public void testTitleEqualsArtistSortNaturalOrder() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(musicItem -> musicItem.getArtist().equals(musicItem.getTitle()))
                .sorted(Comparator.comparing(MusicItem::getArtist))
                .collect(Collectors.toList());

        assertEquals(2, items.size());
        assertEquals(Long.valueOf(7L), items.get(0).getId()); // Ian Moore
        assertEquals(Long.valueOf(6L), items.get(1).getId()); // Seal
    }

    /**
     * TASK: find all MusicItems whose price is less than 12.00 and sort them by genre (MusicCategory).
     * The natural order of an enum is the order in which they're declared (it's not alphabetical).
     * We'll provide that for you here: BLUES, CLASSICAL, JAZZ, RAP, COUNTRY, POP, ALTERNATIVE, ROCK, CLASSIC_ROCK
     * <p>
     * RESULT:
     */
    @Test
    public void testPriceLessThanSortMusicCategory() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(musicItem -> musicItem.getPrice() < 12.00D)
                .sorted(Comparator.comparing(MusicItem::getMusicCategory))
                .collect(Collectors.toList());

        assertEquals(5, items.size());
        assertEquals(Long.valueOf(7L), items.get(0).getId());
        assertEquals(Long.valueOf(13L), items.get(1).getId());
        assertEquals(Long.valueOf(16L), items.get(2).getId());
        assertEquals(Long.valueOf(17L), items.get(3).getId());
        assertEquals(Long.valueOf(18L), items.get(4).getId());
    }

    /**
     * TASK: find all "rock" items under 15 dollars and sort them by release date (oldest first).
     * <p>
     * RESULT:
     */
    @Test
    public void testSortMusicCategorySortReleaseDateDesc() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(musicItem -> musicItem.getMusicCategory().equals(MusicCategory.ROCK))
                .filter(musicItem -> musicItem.getPrice() < 15)
                .sorted(Comparator.comparing(MusicItem::getReleaseDate))
                .collect(Collectors.toList());

        assertEquals(3, items.size());
        assertEquals(Long.valueOf(16L), items.get(0).getId());
        assertEquals(Long.valueOf(17L), items.get(1).getId());
        assertEquals(Long.valueOf(8L), items.get(2).getId());
    }

    /**
     * TASK: find all items that cost more than 17 dollars and sort them by price descending, then by artist.
     * You can use visual inspection (sysout) on this one if you're getting tight on time.
     * <p>
     * RESULT:
     */
    @Test
    public void testPriceGreaterThanSortPriceDescThenMusicCategory() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(musicItem -> musicItem.getPrice() > 17)
                .sorted(Comparator.comparing(MusicItem::getArtist))
                .collect(Collectors.toList());

        assertEquals(7, items.size());
        assertEquals(Long.valueOf(15L), items.get(0).getId());
        assertEquals(Long.valueOf(6L), items.get(items.size() - 1).getId());
    }

    /**
     * TASK: find all items under 12 dollars released in the 80s and sort them by artist.
     * Hint: To see if an item was released in the 80s, use item.getReleaseDate().toString().startsWith("198")
     * <p>
     * RESULT:
     */
    @Test
    public void testReleaseDateSortArtist() {
        List<MusicItem> items = allMusicItems.stream()
                .filter(musicItem -> musicItem.getReleaseDate().compareTo(Date.valueOf("1980-01-01")) >= 0)
                .filter(musicItem -> musicItem.getReleaseDate().compareTo(Date.valueOf("1990-01-01")) < 0)
                .sorted(Comparator.comparing(MusicItem::getArtist))
                .collect(Collectors.toList());

        assertEquals(7, items.size());
        assertEquals(Long.valueOf(13L), items.get(0).getId());
        assertEquals(Long.valueOf(16L), items.get(items.size() - 1).getId());
    }
}