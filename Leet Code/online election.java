import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {
    private int[] times;
    private int[] leaders;
    private Map<Integer, Integer> voteCount;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[times.length];
        this.voteCount = new HashMap<>();
        
        int maxVotes = 0;
        int currentLeader = -1;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            // Count the votes
            voteCount.put(person, voteCount.getOrDefault(person, 0) + 1);
            int votes = voteCount.get(person);
            
            // Determine the current leader
            if (votes >= maxVotes) {
                maxVotes = votes;
                currentLeader = person;
            }
            
            // Store the current leader at this time
            leaders[i] = currentLeader;
        }
    }

    public int q(int t) {
        // Binary search to find the right time
        int left = 0, right = times.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // If left is out of bounds, return the last leader
        if (left > 0 && times[left - 1] <= t) {
            return leaders[left - 1];
        }
        
        return leaders[left]; // This will be the leader at the last time <= t
    }
}
