class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
            Two heaviest stone and smash them 
            y is the heaviest one and x is the next heaviest. 
            if they are equal we move on to next two x and y 
            else y new weight is y - x 
            it looks a max heap problem 

            make a max heap out of the array of stones. 
            poll 2 stones from the top if 0 poll another two else reorder and poll 2 again do it untill there is one remaining. 
        */     

        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            maxHeap.offer(stone); 
        }
        while(maxHeap.size() >1){
            int y = maxHeap.poll(); 
            int x = maxHeap.poll(); 

            if( y != x){
                maxHeap.offer(y-x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek(); 
    }

}
