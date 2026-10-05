class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> m1= new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
     
        for (char c : s.toCharArray()){
            if(m1.containsKey(c)){
                m1.put(c, m1.get(c)+ 1);
            }
            else{
                m1.put(c, 1);
            }
        }
        for (char c : t.toCharArray()){
            if(m2.containsKey(c)){
                m2.put(c, m2.get(c)+ 1);
            }
            else{
                m2.put(c, 1);
            }
        }
        return m1.equals(m2);
    }
}
