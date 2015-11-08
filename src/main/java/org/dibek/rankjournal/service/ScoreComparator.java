package org.dibek.rankjournal.service;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.dibek.rankjournal.domain.Journal;

import java.util.Comparator;

/**
 * Created by dibek on 08/11/15.
 */
public class ScoreComparator implements Comparator<Journal> {
    public int compare(Journal jor1, Journal jor2) {
        return new CompareToBuilder()
                .append(jor2.getScore(), jor1.getScore())
                .toComparison();
    }
}
