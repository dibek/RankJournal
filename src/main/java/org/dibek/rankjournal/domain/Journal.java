package org.dibek.rankjournal.domain;

/**
 * Created by dibek on 08/11/15.
 */
public class Journal {

    private String name;
    private Double score;
    private Integer rank;
    private boolean isReview;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public boolean getIsReview() {
        return isReview;
    }

    public void setIsReview(boolean isReview) {
        this.isReview = isReview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        if (isReview != journal.isReview) return false;
        if (name != null ? !name.equals(journal.name) : journal.name != null) return false;
        if (score != null ? !score.equals(journal.score) : journal.score != null) return false;
        return !(rank != null ? !rank.equals(journal.rank) : journal.rank != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (isReview ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                ", isReview=" + isReview +
                '}';
    }
}
