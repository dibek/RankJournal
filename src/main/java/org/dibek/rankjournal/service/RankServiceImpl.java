package org.dibek.rankjournal.service;

import org.dibek.rankjournal.domain.Journal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dibek on 08/11/15.
 */
public class RankServiceImpl implements RankService {

    public List<Journal> rankJournals(List<Journal> journals) {
        Collections.sort(journals, new ScoreNameComparator());
        AtomicInteger ranker = new AtomicInteger();
        for (Journal journal: journals){
            journal.setRank(ranker.incrementAndGet());
        }
        return journals;
    }

    public List<Journal> rankJournalsNoRewiew(List<Journal> journals) {
        journals = removeReviews(journals);
        return this.rankJournals(journals);
    }

    private List<Journal> removeReviews(List<Journal> journals) {
        List<Journal> listRemovedRevs = new ArrayList<Journal>();
        for (Journal journal: journals){
            if (!journal.getIsReview()){
                listRemovedRevs.add(journal);
            }
        }
        return listRemovedRevs;
    }
}
