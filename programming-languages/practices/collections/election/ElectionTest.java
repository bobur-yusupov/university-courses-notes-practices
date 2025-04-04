package election;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import election.Election;
import election.candidate.Candidate;

public class ElectionTest {
    @Test
    public void noVotes() {
        Election election = new Election();

        assertEquals(Candidate.JACK, election.getWinner());
    }

    @Test
    public void singleCandidate() {
        Election election = new Election();

        election.addVotes(Candidate.JACK, 10);

        assertEquals(Candidate.JACK, election.getWinner());
    }

    @Test
    public void twoCandidatesSameVoteCount() {
        Election election = new Election();

        election.addVotes(Candidate.JACK, 10);
        election.addVotes(Candidate.JILL, 0);

        assertEquals(Candidate.JACK, election.getWinner());
    }

    @ParameterizedTest
    @CsvSource({
        "0, JACK,JILL,SAM,MAX",
        "1, JILL,SAM,MAX",
        "2, JILL,SAM",
        "3, JILL",
        "4, "
    })
    public void testGetCandidatesWithMoreVotesThan(int votes, String expectedCandidates) {
        Election election = new Election();
        election.addVotes(Candidate.JACK, 1);
        election.addVotes(Candidate.JILL, 4);
        election.addVotes(Candidate.SAM, 3);
        election.addVotes(Candidate.MAX, 2);

        Candidate[] expected = parseCandidates(expectedCandidates);
        assertArrayEquals(expected, election.getCandidatesWithMoreVotesThan(votes));
    }

    private Candidate[] parseCandidates(String candidateString) {
        if (candidateString == null || candidateString.trim().isEmpty()) {
            return new Candidate[0];
        }
        String[] names = candidateString.split(",");
        Candidate[] candidates = new Candidate[names.length];
        for (int i = 0; i < names.length; i++) {
            candidates[i] = Candidate.valueOf(names[i].trim());
        }
        return candidates;
    }
}
