import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day12 {

    public static void main(String[] args) throws IOException {

        int[][] map = Files.readAllLines(Path.of("src/input12.txt")).stream()
                .map(s -> s.chars().map(Day12::parseChar).toArray())
                .toArray(int[][]::new);

        int endX = endXY(map)[0];
        int endY = endXY(map)[1];


        // We start at the end point and travers the map backwards until we reach the starting point S.
        System.out.println(findShortestPath(map, new int[map.length][map[0].length], endX, endY, 27));
        // Same we but search for the first a instead.
        System.out.println(findShortestPath(map, new int[map.length][map[0].length], endX, endY, 26));

    }

    // Dijkstra’s Algorithm
    private static int findShortestPath(int[][] map, int[][] minKnownPath, int x, int y, int goal) {

        int pathToThisSquare = minKnownPath[x][y] + 1;

        int lowestNrOfSteps = Integer.MAX_VALUE;

        for (Direction direction : Direction.values()) {
            int nx = x + direction.getX();
            int ny = y + direction.getY();

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                boolean canMakeStep = map[nx][ny] <= map[x][y] + 1;
                boolean isShorterPath = (minKnownPath[nx][ny] == 0 || pathToThisSquare < minKnownPath[nx][ny]);
                if(canMakeStep && isShorterPath) {
                    minKnownPath[nx][ny] = pathToThisSquare;
                    if(map[nx][ny] == goal) {
                        return pathToThisSquare;
                    }
                    // Update the lowest number of steps required to reach the goal by searching from the next square
                    lowestNrOfSteps = Math.min(lowestNrOfSteps, findShortestPath(map, minKnownPath, nx, ny, goal));
                }
            }
        }
        return lowestNrOfSteps;
    }

    private static int parseChar(int c) {
        return switch (c) {
            case 'S' -> 27;
            case 'E' -> 0;
            default -> 'z' + 1 - c;
        };
    }

    private static int[] endXY(int[][] map) {
        int[] endXY = new int[2];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y  < map[0].length; y++) {
                if (map[x][y] == 0){
                    endXY[0] = x;
                    endXY[1] = y;
                }
            }
        }
        return endXY;
    }
}

enum Direction {
    UP(0, -1),
    LEFT(-1, 0),
    DOWN(0, 1),
    RIGHT(1, 0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
