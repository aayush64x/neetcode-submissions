class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>(); 

        int value = 1; 

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, value); 
            }
        }

        List<Map.Entry<Integer, Integer>> entries =
            new ArrayList<>(map.entrySet());

        entries.sort((a, b) ->
            Integer.compare(b.getValue(), a.getValue())
        );

        int i = 0; 

        for (Map.Entry<Integer, Integer> entry : entries) {
            arr[i] = entry.getKey();
            i++;

            if (i == k) break;
        }

        return arr;
    }
}