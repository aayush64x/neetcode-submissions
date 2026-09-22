
class Solution {

    public String encode(List<String> strs) {
        String word = "";

        for (String str : strs) {
            int length = str.length();
            String prefix = length + "#";
            word += (prefix + str);
        }

        return word;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = str.indexOf('#', i);

            int num = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + 1 + num);

            list.add(word);

            i = j + 1 + num;
        }

        return list;
    }
}
