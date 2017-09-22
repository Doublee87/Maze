
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Maze {


	private char[][] maze; 
	private int rows;
	private int columns;
	private String fileName;
	private boolean done = false;
	private int moveCounter = 0;

	public Maze(int row, int col, String file){
		
		rows = row;
		columns = col;
		
		fileName = file;
		
		maze = new char[rows][columns];
	}

	public void readMazeFile() throws FileNotFoundException{
		File mazeFile = new File(fileName);
		int lineNum = -1;
		String str;
		Scanner sc;
		try{
			sc = new Scanner(mazeFile);

			while(sc.hasNext()){
				lineNum++; 
				str = sc.nextLine();
	
				for(int i = 0; i < columns; i++){
					maze[lineNum][i] = str.charAt(i);
				}

			}	
		}catch (FileNotFoundException e) {
			System.out.println("File not found.");

		}




	}

	public void printAll(){
		System.out.println(moveCounter + " moves");
		
		for(int i = 0; i < rows; i++){
			
			for ( int j = 0; j < columns; j++){
				System.out.print(maze[i][j]);
			}
			
			System.out.println("");
		}
		
		System.out.println("");
	}

	public void solver(int r, int c){

		if(maze[r][c] == '|'){
			System.out.println("There is a wall in current start position... ");
		}else{

			maze[r][c] = '%';
			escape(r-1,c);
			escape(r,c-1);
			escape(r,c+1);
			escape(r+1,c);

		}
		if(done == false){
			System.out.println("There is no solution for current position");
		}else if(done == true){
			System.out.println("Success...");
		}
	}

	private void escape(int r, int c){
		if(maze[r][c] == '%'){
			return;
		}

		if(maze[r][c] == '*'){
			return;
		}

		if(maze[r][c] == '|'){
			return;
		}
		if(done == true){
			return;
		}


		if(maze[r][c] == 'E'){
			done = true;
		}else{

	

			maze[r][c] = '*';
			moveCounter++;
			printAll();
			escape(r-1,c);
			escape(r,c-1);
			escape(r,c+1);
			escape(r+1,c);

		}


	}




}
