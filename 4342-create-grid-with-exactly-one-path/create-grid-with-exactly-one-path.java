
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] sol = new char[m][n];
        String[] res = new String[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            sol[0][j] = '.';
        }

        for (int i = 0; i < m; i++) {
            sol[i][n - 1] = '.';
        }

        for (int i = 0; i < m; i++) {
            res[i] = new String(sol[i]);
        }

        return res;
    }
}
