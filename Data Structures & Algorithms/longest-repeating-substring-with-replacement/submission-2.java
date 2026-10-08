class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0; 
        int end = 0;  
        int result = 0; 
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
            int windowLength = end - start + 1;
            int maxOccurences = Collections.max(map.values());
            int diff = windowLength - maxOccurences; 
            if(diff <= k){
                result = Math.max(result, windowLength);
            }else{
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++; 
            }

            end++; 
        }
        return result; 
    }
}
