class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0;
        int end = s1.length();

        HashMap<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s1Map.containsKey(c)) {
                s1Map.put(c, s1Map.get(c) + 1);
            } else {
                s1Map.put(c, 1);
            }
        }

        while (end <= s2.length()) {
            String sub = s2.substring(start, end);
            HashMap<Character, Integer> s2Map = new HashMap<>();

            for (int i = 0; i < sub.length(); i++) {
                char c = sub.charAt(i);
                if (s2Map.containsKey(c)) {
                    s2Map.put(c, s2Map.get(c) + 1);
                } else {
                    s2Map.put(c, 1);
                }
            }

            if (s1Map.equals(s2Map)) {
                return true;
            } else {
                start++;
                end++;
            }
        }

        return false;
    }
}