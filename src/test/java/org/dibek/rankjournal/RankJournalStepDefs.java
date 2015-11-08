package org.dibek.rankjournal;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.dibek.rankjournal.domain.Journal;
import org.dibek.rankjournal.service.RankService;
import org.dibek.rankjournal.service.RankServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dibek on 08/11/15.
 */
public class RankJournalStepDefs {

    List<Journal> journals;

    private RankService rankService;

    @Before
    public void initService() {
        rankService = new RankServiceImpl();
    }

    @Given("^the following journals have scores for (\\d+):$")
    public void the_following_journals_have_scores_for_(int arg1, List<Journal> listJournal) throws Throwable {
        assertTrue(listJournal.size() > 0);
        journals = listJournal;

    }

    @When("^the user views the ranked journals$")
    public void the_user_views_the_ranked_journals() throws Throwable {
        journals = rankService.rankJournals(new ArrayList<Journal>(journals));
        assertTrue(true);
    }

    @Then("^the order and rank should be:$")
    public void the_order_and_rank_should_be(List<Journal> listSortedJournal) throws Throwable {
        for (int i= 0; i< journals.size();i++) {
            assertTrue(journals.get(i).getName().equals(listSortedJournal.get(i).getName()));
            assertTrue(journals.get(i).getScore().equals(listSortedJournal.get(i).getScore()));
        }
    }

    @Then("^the order should be determined by score then journal name:$")
    public void the_order_should_be_determined_by_score_then_journal_name(List<Journal> listSortedJournal) throws Throwable {
        for (int i= 0; i< journals.size();i++) {
            assertTrue(journals.get(i).getName().equals(listSortedJournal.get(i).getName()));
        }
    }

     @When("^the journals are ranked$")
    public void the_journals_are_ranked() throws Throwable {
         journals = rankService.rankJournalsNoRewiew(new ArrayList<Journal>(journals));
    }

    @Then("^the order should be:$")
    public void the_order_should_be(List<Journal> listSortedJournal) throws Throwable {
        for (int i= 0; i< journals.size();i++) {
            assertTrue(journals.get(i).getName().equals(listSortedJournal.get(i).getName()));
        }
    }

    @And("^\"([^\"]*)\" is a review journal$")
    public void is_a_review_journal(String arg1) throws Throwable {
        List<Journal> listWithReview = new ArrayList<Journal>();
        for (Journal journal: journals){
            if (journal.getName().equals(arg1)){
                journal.setIsReview(true);
            }
            listWithReview.add(journal);
        }
        journals = listWithReview;
    }
}