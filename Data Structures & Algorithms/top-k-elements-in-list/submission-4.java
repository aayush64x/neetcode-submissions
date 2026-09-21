class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        // 1. Count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 2. Create a max-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
            );

        // 3. Put every map entry into the PriorityQueue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        // 4. Remove the highest-frequency entries
        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll().getKey();
        }

        return arr;
    }
}