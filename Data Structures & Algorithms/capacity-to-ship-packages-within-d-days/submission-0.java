class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int w : weights) {
            low = Math.max(low, w);   // biggest single package
            high += w;                // total of all packages
        }

        for (int c = low; c <= high; c++) {
            if (canShip(weights, days, c)) {
                return c;
            }
        }
        return high;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int load = 0;
        for (int w : weights) {
            if (load + w > capacity) {
                daysUsed++;
                load = 0;
            }
            load += w;
        }
        return daysUsed <= days;
    }
}