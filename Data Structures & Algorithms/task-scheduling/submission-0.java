
class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequencies
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max heap: highest frequency first
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int val : map.values()) {
            maxHeap.offer(val);
        }

        // Cooldown queue
        Queue<Schedule> q = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {

            // Check whether a task's cooldown has expired
            if (!q.isEmpty() && q.peek().getTurn() <= time) {
                Schedule s = q.poll();
                maxHeap.offer(s.getRemaining());
            }

            // Execute the most frequent available task
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;

                // If executions remain, put task in cooldown
                if (remaining > 0) {
                    q.offer(new Schedule(remaining, time + n + 1));
                }
            }

            // Advance time (even if idle)
            time++;
        }

        return time;
    }
}

class Schedule {
    int remaining;
    int nextTurn;

    public Schedule(int remaining, int turn) {
        this.remaining = remaining;
        this.nextTurn = turn;
    }

    public int getTurn() {
        return this.nextTurn;
    }

    public int getRemaining() {
        return this.remaining;
    }
}
