class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int[] arr = new int[k];
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>
            ((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        int i = 0; 
        while(i != k){
            arr[i] = queue.poll().getKey(); 
            i++;
        }
        return arr; 
    }
}
