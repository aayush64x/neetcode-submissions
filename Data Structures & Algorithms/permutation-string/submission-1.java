class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        int start = 0;
        int end = s1.length(); // window is s2[start, end)

        // Count s1 and the FIRST window — the only full loop
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            if (s1Map.containsKey(c1)) {
                s1Map.put(c1, s1Map.get(c1) + 1);
            } else {
                s1Map.put(c1, 1);
            }

            char c2 = s2.charAt(i);
            if (s2Map.containsKey(c2)) {
                s2Map.put(c2, s2Map.get(c2) + 1);
            } else {
                s2Map.put(c2, 1);
            }
        }

        while (end < s2.length()) {
            if (s1Map.equals(s2Map)) {
                return true;
            }

            // letter coming in
            char in = s2.charAt(end);
            if (s2Map.containsKey(in)) {
                s2Map.put(in, s2Map.get(in) + 1);
            } else {
                s2Map.put(in, 1);
            }

            // letter leaving
            char out = s2.charAt(start);
            if (s2Map.get(out) == 1) {
                s2Map.remove(out); // drop it at 0, or equals() breaks
            } else {
                s2Map.put(out, s2Map.get(out) - 1);
            }

            start++;
            end++;
        }

        return s1Map.equals(s2Map); // check the last window
    }
}