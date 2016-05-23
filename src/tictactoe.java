/*Calvin Brooks
 * Tic Tac Toe
 * This program creates a 3x3 game board in which 2 players
 * enter coordinates on the board to input an "X" or an "O".
 * The first player is assumed to input "X".
 * 
 */
import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String gameBoard[][] = new String[3][3];
		int row; //initialized for row input
		int column; //initialized for column input
		int counter = 1; //initialized to count turns
		input.nextLine();
		String ch = "y"; //initialized ch to continue of stop while loop
		gameBoard[0][0] = "   "; //game board coordinates
		gameBoard[0][1] = "   ";
		gameBoard[0][2] = "   ";
		gameBoard[1][0] = "   ";
		gameBoard[1][1] = "   ";
		gameBoard[1][2] = "   ";
		gameBoard[2][0] = "   ";
		gameBoard[2][1] = "   ";
		gameBoard[2][2] = "   ";

		while (ch.equals("y")) {
			System.out.println("Enter X,Y coordinates for your move:");
			row = input.nextInt();
			column = input.nextInt();
			input.nextLine();
			getXorO(gameBoard, row, column, counter);
			input.nextLine();
			ch = xWins(gameBoard, ch);
			ch = oWins(gameBoard, ch);
			ch = tieGame(counter, ch);
			counter++; //counter adds +1 after each turn
			getGameBoard(gameBoard);
		}
		input.close();
	}

	public static String tieGame(int counter, String ch) {//This method will end the game in a tie after 9 turns
		if (counter == 9) {
			System.out.println("Game is a tie");
			ch = "n";
		}
		return ch;
	}

	public static void getGameBoard(String[][] gameBoard) {//This method prints the game board GUI
		System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2] + "\n" + "---" + "|" + "---"
				+ "|" + "---" + "\n" + gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2] + "\n" + "---"
				+ "|" + "---" + "|" + "---" + "\n" + gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
	}

	public static String xWins(String[][] gameBoard, String ch) {//Method to determine to whether X wins or not if it meets any of the criteria of the if statement
		if (gameBoard[0][0].equals("X  ") && gameBoard[0][1].equals("X  ") && gameBoard[0][2].equals("X  ")
				|| gameBoard[1][0].equals("X  ") && gameBoard[1][1].equals("X  ") && gameBoard[2][2].equals("X  ")
				|| gameBoard[2][0].equals("X  ") && gameBoard[2][1].equals("X  ") && gameBoard[2][2].equals("X  ")
				|| gameBoard[0][0].equals("X  ") && gameBoard[1][0].equals("X  ") && gameBoard[2][0].equals("X  ")
				|| gameBoard[0][1].equals("X  ") && gameBoard[1][1].equals("X  ") && gameBoard[2][1].equals("X  ")
				|| gameBoard[0][2].equals("X  ") && gameBoard[1][2].equals("X  ") && gameBoard[2][2].equals("X  ")
				|| gameBoard[0][0].equals("X  ") && gameBoard[1][1].equals("X  ") && gameBoard[2][2].equals("X  ")
				|| gameBoard[0][2].equals("X  ") && gameBoard[1][1].equals("X  ") && gameBoard[2][0].equals("X  ")) {
			System.out.println("X wins!");
			ch = "n";
		}
		return ch;
	}

	public static String oWins(String[][] gameBoard, String ch) {//Method to determine to whether O wins or not if it meets any of the criteria of the if statement
		if (gameBoard[0][0].equals("O  ") && gameBoard[0][1].equals("O  ") && gameBoard[0][2].equals("O  ")
				|| gameBoard[1][0].equals("O  ") && gameBoard[1][1].equals("O  ") && gameBoard[2][2].equals("O  ")
				|| gameBoard[2][0].equals("O  ") && gameBoard[2][1].equals("O  ") && gameBoard[2][2].equals("O  ")
				|| gameBoard[0][0].equals("O  ") && gameBoard[1][0].equals("O  ") && gameBoard[2][0].equals("O  ")
				|| gameBoard[0][1].equals("O  ") && gameBoard[1][1].equals("O  ") && gameBoard[2][1].equals("O  ")
				|| gameBoard[0][2].equals("O  ") && gameBoard[1][2].equals("O  ") && gameBoard[2][2].equals("O  ")
				|| gameBoard[0][0].equals("O  ") && gameBoard[1][1].equals("O  ") && gameBoard[2][2].equals("O  ")
				|| gameBoard[0][2].equals("O  ") && gameBoard[1][1].equals("O  ") && gameBoard[2][0].equals("O  ")) {
			System.out.println("O wins!");
			ch = "n";
		}
		return ch;
	}

	public static void getXorO(String[][] gameBoard, int row, int column, int counter) {//If the counter falls on any of the following number, then it's the turn of X. Otherwise, It's the turn of O
		if (counter == 1 || counter == 3 || counter == 5 || counter == 7 || counter == 9) {
			gameBoard[row][column] = "X  ";
		} else {
			gameBoard[row][column] = "O  ";
		}
	}

}
