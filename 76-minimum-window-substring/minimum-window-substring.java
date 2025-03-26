
//used array of 52 size instead of map
class Solution {
    public static boolean areAllValuesPresent(int[] freq1, int[] freq2) {
        for (int i = 0; i < 52; i++) {
            if (freq2[i] > freq1[i]) {
                return false;
            }
        }
        return true;
    }

    private static int getIndex(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a';  // 'a' to 'z' → index 0 to 25
        } else {
            return c - 'A' + 26;  // 'A' to 'Z' → index 26 to 51
        }
    }

    public String minWindow(String s, String t) {
        StringBuilder str = new StringBuilder();
        int len = Integer.MAX_VALUE;  

        // Frequency arrays for storing character counts
        int[] freq2 = new int[52];  // Stores char frequency of 't'
        int[] freq1 = new int[52];  // Stores char frequency of current window in 's'

        // Fill freq2 with frequency of characters in 't'
        for (int i = 0; i < t.length(); i++) {
            freq2[getIndex(t.charAt(i))]++;
        }

        int i = 0, j = 0;

        while (j < s.length()) {
            // Add current character in freq1
            freq1[getIndex(s.charAt(j))]++;

            // Check if all values are present
            if (!areAllValuesPresent(freq1, freq2)) {
                j++;  // Expand the window if all characters are not yet present
            } else {
                while (areAllValuesPresent(freq1, freq2)) {
                    // Compute minimum length substring
                    if (j - i + 1 < len) {
                        len = j - i + 1;
                        str = new StringBuilder(s.substring(i, j + 1));  // Direct substring extraction
                    }

                    // Remove ith value and increment i
                    freq1[getIndex(s.charAt(i))]--;
                    i++;
                }
                j++;  // Move j forward
            }
        }

        return len == Integer.MAX_VALUE ? "" : str.toString();
    }
}
