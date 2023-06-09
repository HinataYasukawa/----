import java.util.Scanner;

public class autobattle {
    static int[][] board = new int[3][3];
    static int m = 1;
    static int b = 2;
    static boolean end = false;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

        while (end == false) {
            System.out.print("input:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int c;

            if (parts[2].equals("m")) {
                c = 1;
            } else if (parts[2].equals("b")) {
                c = 2;
            } else {
                System.out.println("please input m or b");
                continue;
            }

            if (x < 0 || x >= 3 || y < 0 || y >= 3) {
                System.out.println("please input 0 or 1 or 2");
                continue;
            }

            // Update board
            board[x][y] = c;

            // Print board
            printBoard();

            int winner = checkWinner();
            if (winner != 0) {
                System.out.println("Player " + (winner == 1 ? "m" : "b") + " wins!");
                end = true;
            }

            int filled = checkAllFilled();
            if (filled == 0) {
                System.out.println("draw");
                end = true;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return board[i][0];
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return board[0][i];
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return board[0][2];
        }

        // No winner
        return 0;
    }

    public static int checkAllFilled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}