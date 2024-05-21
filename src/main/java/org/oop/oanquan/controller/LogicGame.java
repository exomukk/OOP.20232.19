package org.oop.oanquan.controller;

import java.util.Scanner;

public class LogicGame {
    private int[] board;           // Mảng chứa số lượng quân cờ mỗi ô
    private int currentPlayer;     // Nguười chơi hiện tại
    private int player1Score;      // Điểm của người chơi 1 và 2
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

    // Hàm move(): Tính toán bước di chuyển của từng người chơi -> Đưa ra kết quả
    // Nhập vào vị trí bắt đầu trên bảng (start) và hướng đi (direction)
    public void move(int start, boolean direction) {
        // Kiểm tra ô bắt đầu có quân cờ không
        if (board[start] == 0) {
            System.out.println("Ô chọn không có quân. Chọn lại.");
            return;
        }

        // Gán số lượng quân cờ ở vị trí bắt đầu vào 1 biến (stones) rồi làm rỗng vị trí bắt đầu
        // Đặt vị trí cuối cùng là vị trí bắt đầu
        int stones = board[start];
        board[start] = 0;
        int lastPos = start;

        // Lặp lại việc thả quân theo hướng đã chọn cho đến khi không còn quân cở nào
        // Cập nhật vị trí cuối cùng sau mỗi lượt di chuyển
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

        // Kiểm tra vị trí cuối cùng chỉ có quân cờ hay không ?
        // Nếu có: Kiểm tra vị trí tiếp theo theo hướng di chuyển
        // Nếu không: Kiểm tra vị trí tiếp theo -> Nếu có: "ăn" các quân cờ -> Cộng điểm người chơi
        // Nếu vị trí cuối cùng có nhiều hơn 1 quân cờ, lặp lại quá trình thả quân cờ
        // Cuối cùng đổi lượt cho người chơi còn lại
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

    // Kiểm tra nếu bàn cờ không còn quân cờ -> Kết thúc trò chơi, so sánh điểm
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

    // Hàm in bàn cờ ra terminal
    // Thiết kế GUI rồi thì phần này không quan trọng lắm
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

    // Hàm main() test game
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