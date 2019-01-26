/**
 * RatInMaze
 */
public class RatInMaze {

  public static void ratInAMaze(int maze[][]) {
    int size = maze.length;
    int[][] solution = new int[size][size];
    ratInAMaze(maze, solution, 0, 0, size);
  }

  private static void ratInAMaze(int[][] maze, int[][] solution, int row, int col, int size) {
    if(row == size - 1 && col == size - 1) {
      solution[row][col] = 1;
      printPath(solution, size);
      solution[row][col] = 0;
      return;
    }
    if(row>= size || col >= size || row < 0 || col < 0 || maze[row][col] == 0 || solution[row][col] == 1) {
      return;
    }
    solution[row][col] = 1;
    ratInAMaze(maze, solution, row - 1, col, size);
    ratInAMaze(maze, solution, row + 1, col, size);
    ratInAMaze(maze, solution, row, col + 1, size);
    ratInAMaze(maze, solution, row, col - 1, size);
    solution[row][col] = 0;
  }

  private static void printPath(int[][] solution, int n) {
    for(int i = 0; i < n; i++)
      for(int j = 0; j < n; j++)
        System.out.print(solution[i][j] + " ");
      System.out.println();
  }

  public static void main(String[] args) {
    int[][] maze = {
      {1, 0, 1},
      {1, 1, 1},
      {1, 1, 1}
    };
    ratInAMaze(maze);
  }
}
