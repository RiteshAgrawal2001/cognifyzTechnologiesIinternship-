import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char currentPlayer = 'X';
        boolean gameWon = false;

        while (true) {
            printBoard(board);
            int[] move = getPlayerMove(board);
            int row = move[0];
            int col = move[1];

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer, row, col);

                if (gameWon) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static int[] getPlayerMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print("Player, enter row (0, 1, or 2) and column (0, 1, or 2) separated by a space: ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    public static boolean checkWin(char[][] board, char player, int row, int col) {
        // Check row, column, and diagonals for a win
        return (board[row][0] == player && board[row][1] == player && board[row][2] == player) ||
               (board[0][col] == player && board[1][col] == player && board[2][col] == player) ||
               (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
