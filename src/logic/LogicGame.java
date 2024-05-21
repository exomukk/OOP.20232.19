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
            board[i] = 5; // Mỗi ô ban đầu có 5 quân
        }
        currentPlayer = 1; // Người chơi 1 bắt đầu trò chơi
        player1Score = 0;
        player2Score = 0;
    }

    public void move(int start, boolean direction) {
        if (board[start] == 0) {
            System.out.println("Ô chọn không có quân. Chọn lại.");
            return;
        }

        int stones = board[start];
        board[start] = 0;
        int lastPos = start;

        while (stones > 0) {
            if (direction) {
                start++;
                if (start > 11) start = 0;
            } else {
                start--;
                if (start < 0) start = 11;
            }

            board[start]++;
            stones--;
            lastPos = start;
        }

        while (true) {
            if (board[lastPos] == 1) {
                int targetPos = direction ? (lastPos + 1) % 12 : (lastPos - 1 + 12) % 12;

                if (board[targetPos] == 0) {
                    targetPos = direction ? (targetPos + 1) % 12 : (targetPos - 1 + 12) % 12;

                    if (board[targetPos] > 0) {
                        System.out.println("Người chơi " + currentPlayer + " ăn ô " + targetPos + " với " + board[targetPos] + " quân.");
                        if (currentPlayer == 1) {
                            player1Score += board[targetPos];
                        } else {
                            player2Score += board[targetPos];
                        }
                        board[targetPos] = 0;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                stones = board[lastPos];
                board[lastPos] = 0;

                while (stones > 0) {
                    if (direction) {
                        lastPos++;
                        if (lastPos > 11) lastPos = 0;
                    } else {
                        lastPos--;
                        if (lastPos < 0) lastPos = 11;
                    }

                    board[lastPos]++;
                    stones--;
                }
            }
        }

        currentPlayer = 3 - currentPlayer; // Đổi người chơi
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

        return 0; // Chưa có người thắng
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
        System.out.println("Lượt người chơi: " + currentPlayer);
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