package model;

import java.util.Scanner;

public class LogicGame {
	private int danPoints = 0;
    private int quanPoints = 0;
    private int currentPlayer = 1; // 1 for Dân, 2 for Quan
    public int[] board;

	public LogicGame() {
		// Initialize the game here
		board = new int[12];
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 6) {
                board[i] = 1; // Quan
            } else {
                board[i] = 5; // Dân
            }
        }
	}
	
	// Check for winner -> scoreboard
	public String checkWin() {
        if (danPoints > quanPoints) {
            return "Dan";
        } else if (quanPoints > danPoints) {
            return "Quan";
        } else {
            return "Draw";
        }
    }
	
    // Get point function for players
	public void getPoint(String player, int points) {
        if (player.equals("Dan")) {
            danPoints += points;
        } else if (player.equals("Quan")) {
            quanPoints += points;
        }
    }

    // Checking if the game is over or not
	// The game ends when 1 of the 2 players have 0 beans on the play board
    public boolean isGameOver(int[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    // Determine current player
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    
    // Get move and make move logics
    public int getMoveFromPlayer(int player) {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
        	System.out.println("Player " + player + ", please enter your move: ");
        	move = scanner.nextInt();
        } while (move < 0 || move >= 12); // Ensure the move is valid
        return move;
    }

    public void makeMove(int[] board, int move, int player) {
    	int beans = board[move];
        board[move] = 0;

        while (beans > 0) {
            move++;
            if (move >= 12) {
                move = 0;
            }
            board[move]++;
            beans--;
        }

        // Update points
        if (player == 1 && move >= 0 && move <= 5) {
            getPoint("Dan", board[move]);
            board[move] = 0;
        } else if (player == 2 && move >= 6 && move <= 11) {
            getPoint("Quan", board[move]);
            board[move] = 0;
        }

        // Switch the current player
        currentPlayer = 3 - currentPlayer;
    }
    
	// Logic function here
	public void logicGame() {
		// Create play board for 2 players
		int[] board = new int[12];
	    for (int i = 0; i < 12; i++) {
	        if (i == 0 || i == 6) {
	            board[i] = 1; // Quan
	        } else {
	            board[i] = 5; // Dân
	        }
	    }
	    
	    // Running the moves until game end (isGameOver)
	    while (!isGameOver(board)) {
	        // Current player turn 
	        int player = getCurrentPlayer();
	        int move = getMoveFromPlayer(player);

	        // Update move of player
	        makeMove(board, move, player);
	    }
	    
	    String winner = checkWin();
	    System.out.println("Người thắng cuộc là: " + winner);
	}

}
