import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int xSize = 0;
    int ySize = 0;

    public int solution(String[] maps) {
        xSize = maps[0].length();
        ySize = maps.length;
        
        int[] start = findPosition(maps, 'S');
        int[] lever = findPosition(maps, 'L');
        int[] exit = findPosition(maps, 'E');
        
        int distanceToLever = bfs(maps, start, 'L');
        if (distanceToLever == -1) return -1;

        int distanceToExit = bfs(maps, lever, 'E');
        if (distanceToExit == -1) return -1;

        return distanceToLever + distanceToExit;
    }

    private int[] findPosition(String[] maps, char target) {
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (maps[y].charAt(x) == target) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    private int bfs(String[] maps, int[] start, char target) {
        boolean[][] visited = new boolean[ySize][xSize];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[1]][start[0]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (maps[y].charAt(x) == target) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize 
                        && !visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1;
    }
}