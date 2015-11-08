package org.dibek.rankjournal.service;

import org.dibek.rankjournal.domain.Journal;

import java.util.List;

/**
 * Created by dibek on 08/11/15.
 */
public interface RankService {

    /**
     * Rank and order the journals
     * @param journals
     * @return
     */
    public List<Journal> rankJournals(List<Journal> journals);

    /**
     * Rank, order and remove the reviews
     * @param journals
     * @return
     */
    public List<Journal> rankJournalsNoRewiew(List<Journal> journals);

}
