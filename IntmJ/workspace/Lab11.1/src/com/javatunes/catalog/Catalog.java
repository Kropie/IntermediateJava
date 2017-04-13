/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.util.Collection;

public interface Catalog {
    MusicItem findById(Long id);

    Collection<MusicItem> findByKeyword(String keyword);

    Collection<MusicItem> findByCategory(MusicCategory category);

    int size();

    Collection<MusicItem> getAll();
}