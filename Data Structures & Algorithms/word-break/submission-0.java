class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        int longestWord = 0;
        for (String word : wordDict) {
            longestWord = Math.max(longestWord, word.length());
        }

        int n = s.length();
        boolean[] reachable = new boolean[n + 1];
        reachable[0] = true;

        for (int end = 1; end <= n; end++) {
            int lowerBound = Math.max(0, end - longestWord);
            for (int start = lowerBound; start < end; start++) {
                if (!reachable[start]) continue;
                if (dictionary.contains(s.substring(start, end))) {
                    reachable[end] = true;
                    break;
                }
            }
        }

        return reachable[n];
    }
}