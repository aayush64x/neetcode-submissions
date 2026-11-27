
class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int size = list.size();

        if (size % 2 == 0) {
            int m1 = size / 2 - 1;
            int m2 = size / 2;

            double sum = (double) list.get(m1) + list.get(m2);
            return sum / 2;
        } else {
            int mid = size / 2;
            return (double) list.get(mid);
        }
    }
}
