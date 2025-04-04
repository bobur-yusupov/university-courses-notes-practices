package election;

import java.util.ArrayList;
import java.util.List;

import election.candidate.Candidate;

public class Election {
    private int[] voteCounts = new int[4];

    public Election() {

    }

    public int[] getVoteCounts() {
        return voteCounts;
    }

    public void setVoteCounts(int[] voteCounts) {
        this.voteCounts = voteCounts;
    }


    public void addVote(Candidate candidate) {
        this.voteCounts[candidate.ordinal()] = 1;
    }

    public void addVotes(Candidate candidate, int n) {
        this.voteCounts[candidate.ordinal()] += n;
    }

    private int getCandidateCountWithMoreVotesThan(int votes) {
        int count = 0;

        for (int vote : voteCounts) {
            if (vote > votes) {
                count++;
            }
        }

        return count;
    }

    public Candidate[] getCandidatesWithMoreVotesThan(int votes) {
        List<Candidate> candidates = new ArrayList<>();

        for (Candidate candidate : Candidate.values()) {
            if (voteCounts[candidate.ordinal()] > votes) {
                candidates.add(candidate);
            }
        }

        Candidate[] candidatesArray = new Candidate[candidates.size()];
        return candidates.toArray(candidatesArray);
    }

    public Candidate getWinner() {
        if (this.voteCounts.length == 0) {
            return Candidate.JACK;
        }
        int winnerIdx = getWinningIdx();
        return Candidate.values()[winnerIdx];
    }

    private int getWinningIdx() {
        int maxVotes = -1;
        int winnerIdx = -1;

        for (int i = 0; i < voteCounts.length; i++) {
            if (voteCounts[i] > maxVotes) {
                maxVotes = voteCounts[i];
                winnerIdx = i;
            }
        }

        return winnerIdx;
    }

}
