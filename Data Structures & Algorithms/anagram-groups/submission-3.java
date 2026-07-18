class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>(); 
        
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = 
            new HashMap<HashMap<Character, Integer>, ArrayList<String>>();

        for(String s : strs) {
            HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();

            for(char c : s.toCharArray()) {
                if(map1.containsKey(c)) {
                    int value = map1.get(c) + 1;
                    map1.put(c, value);
                }
                else {
                    map1.put(c, 1);
                }
            }

            if(map.containsKey(map1)) {
                ArrayList<String> l = map.get(map1);
                l.add(s);
            }
            else {
                ArrayList<String> p = new ArrayList<String>();
                p.add(s);
                map.put(map1, p);
            }
        }

        map.forEach((key, value) -> {
            list.add(value);
        });

        return list;
    }
}