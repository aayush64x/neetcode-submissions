class Solution {
    public int findKthLargest(int[] nums, int k) {
        //i could use binary tree but that would not be optimal big O(n) searching for element would be O(log n) but adding element woudl be O(n); 
        
        // I could build a heap but which heap to build its asking for kth largest element

        //I could do a max heap and keep polling untill k = 0 and return that when k = 0; 

        // is there a better way to do it. 

        //i could use min heap. track k elements. if ele 

        // idk if minheap would be that optimal? at worst my my solution with woudl be 0(n)

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

        for(int i : nums){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
            
        }
        return minHeap.poll();
    }
}
