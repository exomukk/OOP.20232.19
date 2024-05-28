package logic;

import java.util.Scanner;

public class LogicGame {
    private int[] board;
    private int currentPlayer;
    private int player1Score;
    private int player2Score;

    public LogicGame() {
        board = new int[12];
        for (int i = 0; i < 12; i++) {
            board[i] = 5;
        }
        currentPlayer = 1;
        player1Score = 0;
        player2Score = 0;
    }

    public void move(int start, boolean direction) {
        if (start == 0 || start == 6) {
            System.out.println("Không được chọn ô quan. Chọn lại.");
            return;
        }

        if (board[start] == 0) {
            System.out.println("Ô chọn không có quân. Chọn lại.");
            return;
        }

        int stones = board[start];
        board[start] = 0;
        int currentPosition = start;

        // Rải quân từ ô được chọn
        while (stones > 0) {
            if (direction) {
                currentPosition++;
                if (currentPosition > 11) currentPosition = 0;
            } else {
                currentPosition--;
                if (currentPosition < 0) currentPosition = 11;
            }

            board[currentPosition]++;
            stones--;
        }

        // Kiểm tra và xử lý theo logic mới
        while (true) {
            int nextPosition = direction ? (currentPosition + 1) % 12 : (currentPosition - 1 + 12) % 12;

            if (board[nextPosition] == 0) {
                int targetPosition = direction ? (nextPosition + 1) % 12 : (nextPosition - 1 + 12) % 12;

                if (board[targetPosition] == 0) {
                    // Ô bên cạnh ô bên cạnh cũng là 0, kết thúc lượt
                    currentPlayer = 3 - currentPlayer;
                    return;
                } else {
                    // Ô bên cạnh ô bên cạnh khác 0, ăn quân và kết thúc lượt
                    System.out.println("Người chơi " + currentPlayer + " ăn ô " + targetPosition + " với " + board[targetPosition] + " quân.");
                    if (currentPlayer == 1) {
                        player1Score += board[targetPosition];
                    } else {
                        player2Score += board[targetPosition];
                    }
                    board[targetPosition] = 0;
                    currentPlayer = 3 - currentPlayer;
                    return;
                }
            } else {
                // Ô bên cạnh ô kết thúc khác 0, tiếp tục rải từ ô này
                stones = board[nextPosition];
                board[nextPosition] = 0;
                currentPosition = nextPosition;

                while (stones > 0) {
                    if (direction) {
                        currentPosition++;
                        if (currentPosition > 11) currentPosition = 0;
                    } else {
                        currentPosition--;
                        if (currentPosition < 0) currentPosition = 11;
                    }

                    board[currentPosition]++;
                    stones--;
                }
            }
        }
    }

    public int checkWin() {
        boolean hasMoves = false;
        for (int i = 0; i < 12; i++) {
            if (board[i] > 0) {
                hasMoves = true;
                break;
            }
        }

        if (!hasMoves) {
            if (player1Score > player2Score) {
                return 1;
            } else if (player1Score < player2Score) {
                return 2;
            } else {
                return 3; // Hòa
            }
        }

        return 0;
    }

    public void printBoard() {
        System.out.println("Bàn chơi hiện tại:");
        for (int i = 0; i < 12; i++) {
            System.out.print(board[i] + " ");
            if (i == 5 || i == 11) {
                System.out.println();
            }
        }
        System.out.println("Điểm người chơi 1: " + player1Score);
        System.out.println("Điểm người chơi 2: " + player2Score);
        System.out.println("Lượt người chơi " + currentPlayer + ":");
    }

    public static void main(String[] args) {
        LogicGame game = new LogicGame();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();
            System.out.println("Người chơi " + game.currentPlayer + ", chọn ô để di chuyển (0-11):");
            int start = scanner.nextInt();
            System.out.println("Chọn hướng di chuyển (0 cho trái, 1 cho phải):");
            boolean direction = scanner.nextInt() == 1;

            game.move(start, direction);

            int result = game.checkWin();
            if (result != 0) {
                game.printBoard();
                if (result == 1) {
                    System.out.println("Người chơi 1 thắng!");
                } else if (result == 2) {
                    System.out.println("Người chơi 2 thắng!");
                } else {
                    System.out.println("Trò chơi hòa!");
                }
                break;
            }
        }
        scanner.close();
    }
}