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

        int c = decideFirst();

        while (end == false) {
            int x = (int) Math.round(Math.random() * 2);
            int y = (int) Math.round(Math.random() * 2);

            // check board
            if (board[x][y] == 0) {

                // Update board
                board[x][y] = c;

                // Print board
                printBoard();

                // change order
                if (c == m) {
                    c = b;
                } else if (c == b) {
                    c = m;
                }

                int winner = checkWinner();
                int filled = checkAllFilled();

                if (winner != 0) {
                    System.out.println("Player " + (winner == 1 ? "m(1)" : "b(2)") + " wins!");
                    end = true;
                } else if (filled == 0) {
                    System.out.println("draw");
                    end = true;
                }
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
        System.out.print("\n");
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

    public static int decideFirst() {
        int first = (int) Math.round(Math.random());

        if (first <= 0.5) {
            // m first
            System.out.println("first is m(1)");
            return m;
        }
        // b first
        System.out.println("first is b(2)");
        return b;
    }
}