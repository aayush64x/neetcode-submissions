class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(char i : s.toCharArray()){
            if(map1.containsKey(i)){
                int value = map1.get(i);
                map1.put(i, value+1);
            }
            else{
                map1.put(i, 1);
            }
        }
        for(char j : t.toCharArray()){
            if(map2.containsKey(j)){
                int value = map2.get(j);
                map2.put(j, value+1);
            }
            else{
                map2.put(j, 1);
            }
        }
        return map1.equals(map2);
    }
}
