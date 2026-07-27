class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> vocabulary = new HashSet<>(wordDict);
        int n = s.length();

        int reach = 0;
        for (String w : wordDict) reach = Math.max(reach, w.length());

        boolean[] canFinish = new boolean[n + 1];
        canFinish[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            int cap = Math.min(reach, n - i);
            for (int len = 1; len <= cap; len++) {
                if (canFinish[i + len] && vocabulary.contains(s.substring(i, i + len))) {
                    canFinish[i] = true;
                    break;
                }
            }
        }

        return canFinish[0];
    }
}