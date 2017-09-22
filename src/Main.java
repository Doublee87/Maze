import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) {

		UserInterface uInterface = new UserInterface();
		
		int x = uInterface.validInt("Enter row number within range", 0, 9);
		
		int y = uInterface.validInt("Enter column number within range", 0, 9);
		
		Maze myMaze = new Maze(10,10, "maze.txt");
		try {
			myMaze.readMazeFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		myMaze.printAll();
		myMaze.solver(x, y);
	}

}
