package model;

import java.util.Arrays;

public class TestGame {
	public static void main(String[] args) {
        // Tạo một trò chơi mới
        LogicGame game = new LogicGame();

        // Thực hiện một số nước đi và in ra trạng thái của trò chơi sau mỗi nước đi
        int[] moves = {2, 7, 3, 8, 4, 9, 5, 10, 6, 11}; // Các nước đi mẫu
        for (int i = 0; i < moves.length; i++) {
            int player = game.getCurrentPlayer();
            game.makeMove(game.board, moves[i], player);
            System.out.println("Player " + player + " moves from position " + moves[i]);
            System.out.println(Arrays.toString(game.board));
        }

        // In ra người thắng cuộc
        String winner = game.checkWin();
        System.out.println("Người thắng cuộc là: " + winner);
    }

	public TestGame() {
		// TODO Auto-generated constructor stub
	}

}
