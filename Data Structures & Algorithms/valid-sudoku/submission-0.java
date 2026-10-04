class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> set = new HashSet<>();

        // Check rows
        for (int i = 0; i < board.length; i++) {
            set.clear();

            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];

                if (current != '.') {
                    if (!set.add(current)) {
                        return false;
                    }
                }
            }
        }

        // Check columns
        for (int i = 0; i < board.length; i++) {
            set.clear();

            for (int j = 0; j < board[i].length; j++) {
                char current = board[j][i];

                if (current != '.') {
                    if (!set.add(current)) {
                        return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i += 3) {          // corner row: 0, 3, 6
            for (int j = 0; j < board[i].length; j += 3) {   // corner column: 0, 3, 6
                set.clear();

                for (int r = 0; r < 3; r++) {                // step down inside the box
                    for (int c = 0; c < 3; c++) {            // step right inside the box
                        char current = board[i + r][j + c];

                        if (current != '.') {
                            if (!set.add(current)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}