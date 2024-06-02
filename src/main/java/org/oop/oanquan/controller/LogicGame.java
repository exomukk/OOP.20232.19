package org.oop.oanquan.controller;

import org.oop.oanquan.model.OVuong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogicGame {
    private Map<Integer, OVuong> board;
    private int currentPlayer;
    private int player1Score;
    private int player2Score;

    public LogicGame() {
        board = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            if (i == 5 || i == 11) {
                board.put(i, new OVuong(0, 1)); // Quan positions
            } else {
                board.put(i, new OVuong(5, 0)); // Dan positions
            }
        }

        currentPlayer = 1;
        player1Score = 0;
        player2Score = 0;
    }

    public void move(int start, boolean direction) {
        if ((currentPlayer == 1 && (start < 0 || start > 4)) || (currentPlayer == 2 && (start < 6 || start > 10))) {
            System.out.println("Người chơi " + currentPlayer + " chỉ được chọn ô tương ứng.");
            return;
        }

        if (start == 5 || start == 11) {
            System.out.println("Không được chọn ô quan. Chọn lại.");
            return;
        }

        if (board.get(start).getSoDan() == 0) {
            System.out.println("Ô chọn không có quân. Chọn lại.");
            return;
        }

        int stones = board.get(start).getSoDan();
        board.get(start).setSoDan(0);
        int currentPosition = start;

        while (stones > 0) {
            currentPosition = (direction) ? (currentPosition + 1) % 12 : (currentPosition - 1 + 12) % 12;
            board.get(currentPosition).setSoDan(board.get(currentPosition).getSoDan() + 1);
            stones--;
        }

        while (true) {
            int nextPosition = direction ? (currentPosition + 1) % 12 : (currentPosition - 1 + 12) % 12;

            if (board.get(nextPosition).getSoDan() == 0 && board.get(nextPosition).getSoQuan() == 0) {
                int targetPosition = direction ? (nextPosition + 1) % 12 : (nextPosition - 1 + 12) % 12;

                if (board.get(targetPosition).getSoDan() == 0 && board.get(targetPosition).getSoQuan() == 0) {
                    currentPlayer = 3 - currentPlayer;
                    return;
                } else {
                    System.out.println("Người chơi " + currentPlayer + " ăn ô " + targetPosition + " với " + board.get(targetPosition).getSoDan() + " dân và " + board.get(targetPosition).getSoQuan() + " quan.");
                    if (currentPlayer == 1) {
                        player1Score += board.get(targetPosition).getSoDan() + board.get(targetPosition).getSoQuan() * 5;
                    } else {
                        player2Score += board.get(targetPosition).getSoDan() + board.get(targetPosition).getSoQuan() * 5;
                    }
                    board.get(targetPosition).setSoDan(0);
                    board.get(targetPosition).setSoQuan(0);
                    currentPlayer = 3 - currentPlayer;
                    return;
                }
            } else {
                stones = board.get(nextPosition).getSoDan();
                board.get(nextPosition).setSoDan(0);
                currentPosition = nextPosition;

                while (stones > 0) {
                    currentPosition = (direction) ? (currentPosition + 1) % 12 : (currentPosition - 1 + 12) % 12;
                    board.get(currentPosition).setSoDan(board.get(currentPosition).getSoDan() + 1);
                    stones--;
                }
            }
        }
    }

    public int checkWin() {
        boolean hasMoves = false;
        for (int i = 0; i < 12; i++) {
            if (board.get(i).getSoDan() > 0) {
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
        System.out.println("    0   1   2   3   4");
        System.out.println("11                  5");
        System.out.println("   10   9   8   7   6");

        for (int i = 0; i < 5; i++) {
            System.out.print(board.get(i).getSoDan() + " ");
        }
        System.out.println();

        System.out.print(board.get(11).getSoDan() + " ");
        System.out.print("                    ");
        System.out.println(board.get(5).getSoDan());

        for (int i = 10; i > 5; i--) {
            System.out.print(board.get(i).getSoDan() + " ");
        }
        System.out.println();

        System.out.println("Điểm người chơi 1: " + player1Score);
        System.out.println("Điểm người chơi 2: " + player2Score);
        System.out.println("Lượt người chơi " + currentPlayer + ":");
    }

    public OVuong[] exportBoardStateAsOVuongArray() {
        OVuong[] boardArray = new OVuong[12];
        for (int i = 0; i < 12; i++) {
            boardArray[i] = board.get(i);
        }
        return boardArray;
    }

    public static void main(String[] args) {
        LogicGame game = new LogicGame();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();
            System.out.println("Người chơi " + game.currentPlayer + ", chọn ô để di chuyển (0-4 cho người chơi 1, 6-10 cho người chơi 2):");
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
