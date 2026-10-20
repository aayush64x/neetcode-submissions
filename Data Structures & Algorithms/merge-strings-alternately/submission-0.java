class Solution {
    public String mergeAlternately(String word1, String word2) {
        int max = Math.max(word1.length(), word2.length());
        char[] arr = new char[word1.length() + word2.length()];
        int k = 0; // where to write next in arr

        for (int i = 0; i < max; i++) {
            if (i < word1.length()) {
                arr[k] = word1.charAt(i);
                k++;
            }
            if (i < word2.length()) {
                arr[k] = word2.charAt(i);
                k++;
            }
        }

        return new String(arr);
    }
}