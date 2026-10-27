
class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String score : operations) {
            if (score.equals("C")) {
                list.remove(list.size() - 1);
            }
            else if (score.equals("D")) {
                int last = list.get(list.size() - 1);
                list.add(last * 2);
            }
            else if (score.equals("+")) {
                int last = list.get(list.size() - 1);
                int secondLast = list.get(list.size() - 2);
                list.add(last + secondLast);
            }
            else {
                list.add(Integer.parseInt(score));
            }
        }

        int total = 0;
        for (int points : list) {
            total += points;
        }

        return total;
    }
}
