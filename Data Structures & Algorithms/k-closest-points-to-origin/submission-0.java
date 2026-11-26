
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getDistance(), a.getDistance())
        );

        for (int[] point : points) {
            Point p = new Point(point);

            maxHeap.offer(p);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getPoint();
        }

        return result;
    }
}

class Point {
    int[] point;
    int distance;

    public Point(int[] point) {
        this.point = point;

        int x = point[0];
        int y = point[1];

        this.distance = x * x + y * y;
    }

    public int getDistance() {
        return this.distance;
    }

    public int[] getPoint() {
        return this.point;
    }
}
