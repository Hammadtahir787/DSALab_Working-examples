import java.util.Arrays;

public class Solution {
    
    // Function to calculate the frequency of the lexicographically smallest character in a string
    private int frequencyOfSmallestChar(String s) {
        char smallestChar = s.charAt(0);
        int count = 1;

        // Find the smallest character and count its frequency
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < smallestChar) {
                smallestChar = s.charAt(i);
                count = 1; // Reset count for the new smallest character
            } else if (s.charAt(i) == smallestChar) {
                count++;
            }
        }
        return count;
    }

    public int[] numSmallerFrequencies(String[] queries, String[] words) {
        int m = words.length;
        int[] wordFrequencies = new int[m];

        // Precompute frequencies for all words
        for (int i = 0; i < m; i++) {
            wordFrequencies[i] = frequencyOfSmallestChar(words[i]);
        }

        // Sort the frequencies
        Arrays.sort(wordFrequencies);

        // Prepare the result array
        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int queryFrequency = frequencyOfSmallestChar(queries[i]);
            // Count how many frequencies are greater than queryFrequency
            int countGreater = 0;
            for (int freq : wordFrequencies) {
                if (freq > queryFrequency) {
                    countGreater++;
                }
            }
            result[i] = countGreater;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] queries1 = {"cbd"};
        String[] words1 = {"zaaaz"};
        System.out.println(Arrays.toString(solution.numSmallerFrequencies(queries1, words1))); // Output: [1]

        String[] queries2 = {"bbb", "cc"};
        String[] words2 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(Arrays.toString(solution.numSmallerFrequencies(queries2, words2))); // Output: [1, 2]
    }
}
