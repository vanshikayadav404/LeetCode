class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        // litterIndex[i][j] tells which bit belongs to this L
        int[][] litterIndex = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                litterIndex[i][j] = -1;
            }
        }

        int litterCount = 0;

        // Find S and assign bits to L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (ch == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;

        /*
            visited[row][col][energy][mask]
        */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        /*
            state:
            [0] = row
            [1] = col
            [2] = energy
            [3] = mask
        */

        java.util.Queue<int[]> queue =
            new java.util.LinkedList<>();

        queue.add(new int[]{
            startRow,
            startCol,
            energy,
            0
        });

        visited[startRow][startCol][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int q = 0; q < size; q++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == targetMask) {
                    return moves;
                }

                // No energy
                if (currentEnergy == 0) {
                    continue;
                }

                // Try 4 directions
                for (int d = 0; d < 4; d++) {

                    int newRow = row + dr[d];
                    int newCol = col + dc[d];

                    // Boundary check
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    // Wall
                    if (classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    int newEnergy = currentEnergy - 1;
                    int newMask = mask;

                    char nextCell =
                        classroom[newRow].charAt(newCol);

                    // Recharge
                    if (nextCell == 'R') {
                        newEnergy = energy;
                    }

                    // Litter
                    if (nextCell == 'L') {

                        int index =
                            litterIndex[newRow][newCol];

                        newMask =
                            newMask | (1 << index);
                    }

                    // Visit only new states
                    if (!visited[newRow][newCol]
                                    [newEnergy][newMask]) {

                        visited[newRow][newCol]
                               [newEnergy][newMask] = true;

                        queue.add(new int[]{
                            newRow,
                            newCol,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}