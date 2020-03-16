import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A game of Tic Tac Toe
 * @author whyroland
 * @date 3/15/20
 */
public class TicTacToe {
	
	private JFrame frame;
	private JPanel panel;
	private static JLabelBox B1, B2, B3, B4, B5, B6, B7, B8, B9; // The game board
	private static JLabel message;
	private JLabel gamemodeLabel;
	private static JLabel player1wins, player2wins;
	private JButton clearBoard, clearWins;
	private JComboBox gameModes;
	
	private static String[][] gameBoard = { {"", "", ""}, {"", "", ""}, {"", "", ""} };
	private static JLabelBox[][] gameBoardBoxes = { {B1, B2, B3}, {B4, B5, B6}, {B7, B8, B9} };
	private String currentGameMode = "PP"; // PP = Player vs Player; PB = Player vs Bot, BB = Bot vs Bot
	private static String currentMove = "X";
	private static int xWins = 0;
	private static int oWins = 0;
	
	public TicTacToe() {

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 520);
		frame.setResizable(false);
		frame.setTitle("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		B1 = new JLabelBox();
		B1.setHorizontalAlignment(SwingConstants.CENTER);
		B1.setOpaque(true);
		B1.setBackground(Color.WHITE);
		B1.setForeground(Color.BLACK);
		B1.setBounds(10, 10, 150, 150);
		B1.setFont(new Font("Roboto", Font.BOLD, 125));
		B1.row = 0;
		B1.col = 0;
		B1.addMouseListener(new LabelAdapter(B1));
		panel.add(B1);
		
		B2 = new JLabelBox();
		B2.setHorizontalAlignment(SwingConstants.CENTER);
		B2.setOpaque(true);
		B2.setBackground(Color.WHITE);
		B2.setForeground(Color.BLACK);
		B2.setBounds(170, 10, 150, 150);
		B2.setFont(new Font("Roboto", Font.BOLD, 125));
		B2.row = 0;
		B2.col = 1;
		B2.addMouseListener(new LabelAdapter(B2));
		panel.add(B2);
		
		B3 = new JLabelBox();
		B3.setHorizontalAlignment(SwingConstants.CENTER);
		B3.setOpaque(true);
		B3.setBackground(Color.WHITE);
		B3.setForeground(Color.BLACK);
		B3.setBounds(330, 10, 150, 150);
		B3.setFont(new Font("Roboto", Font.BOLD, 125));
		B3.row = 0;
		B3.col = 2;
		B3.addMouseListener(new LabelAdapter(B3));
		panel.add(B3);
		
		B4 = new JLabelBox();
		B4.setHorizontalAlignment(SwingConstants.CENTER);
		B4.setOpaque(true);
		B4.setBackground(Color.WHITE);
		B4.setForeground(Color.BLACK);
		B4.setBounds(10, 170, 150, 150);
		B4.setFont(new Font("Roboto", Font.BOLD, 125));
		B4.row = 1;
		B4.col = 0;
		B4.addMouseListener(new LabelAdapter(B4));
		panel.add(B4);
		
		B5 = new JLabelBox();
		B5.setHorizontalAlignment(SwingConstants.CENTER);
		B5.setOpaque(true);
		B5.setBackground(Color.WHITE);
		B5.setForeground(Color.BLACK);
		B5.setBounds(170, 170, 150, 150);
		B5.setFont(new Font("Roboto", Font.BOLD, 125));
		B5.row = 1;
		B5.col = 1;
		B5.addMouseListener(new LabelAdapter(B5));
		panel.add(B5);
		
		B6 = new JLabelBox();
		B6.setHorizontalAlignment(SwingConstants.CENTER);
		B6.setOpaque(true);
		B6.setBackground(Color.WHITE);
		B6.setForeground(Color.BLACK);
		B6.setBounds(330, 170, 150, 150);
		B6.setFont(new Font("Roboto", Font.BOLD, 125));
		B6.row = 1;
		B6.col = 2;
		B6.addMouseListener(new LabelAdapter(B6));
		panel.add(B6);
		
		B7 = new JLabelBox();
		B7.setHorizontalAlignment(SwingConstants.CENTER);
		B7.setOpaque(true);
		B7.setBackground(Color.WHITE);
		B7.setForeground(Color.BLACK);
		B7.setBounds(10, 330, 150, 150);
		B7.setFont(new Font("Roboto", Font.BOLD, 125));
		B7.row = 2;
		B7.col = 0;
		B7.addMouseListener(new LabelAdapter(B7));
		panel.add(B7);
		
		B8 = new JLabelBox();
		B8.setHorizontalAlignment(SwingConstants.CENTER);
		B8.setOpaque(true);
		B8.setBackground(Color.WHITE);
		B8.setForeground(Color.BLACK);
		B8.setBounds(170, 330, 150, 150);
		B8.setFont(new Font("Roboto", Font.BOLD, 125));
		B8.row = 2;
		B8.col = 1;
		B8.addMouseListener(new LabelAdapter(B8));
		panel.add(B8);
		
		B9 = new JLabelBox();
		B9.setHorizontalAlignment(SwingConstants.CENTER);
		B9.setOpaque(true);
		B9.setBackground(Color.WHITE);
		B9.setForeground(Color.BLACK);
		B9.setBounds(330, 330, 150, 150);
		B9.setFont(new Font("Roboto", Font.BOLD, 125));
		B9.row = 2;
		B9.col = 2;
		B9.addMouseListener(new LabelAdapter(B9));
		panel.add(B9);
		
		message = new JLabel("It is " + currentMove + "'s turn.");
		message.setForeground(Color.BLACK);
		message.setBounds(520, 430, 200, 30);
		message.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(message);
		
		clearBoard = new JButton("Clear Board");
		clearBoard.setBounds(520, 350, 150, 30);
		clearBoard.setForeground(Color.BLACK);
		clearBoard.setBackground(Color.WHITE);
		clearBoard.setFont(new Font("Roboto", Font.BOLD, 15));
		clearBoard.addActionListener(new ButtonListener());
		panel.add(clearBoard);
		
		clearWins = new JButton("Clear Wins");
		clearWins.setBounds(700, 350, 150, 30);
		clearWins.setForeground(Color.BLACK);
		clearWins.setBackground(Color.WHITE);
		clearWins.setFont(new Font("Roboto", Font.BOLD, 15));
		clearWins.addActionListener(new ButtonListener());
		panel.add(clearWins);
		
		player1wins = new JLabel("X wins : " + xWins);
		player1wins.setBounds(520, 60, 250, 30);
		player1wins.setForeground(Color.BLACK);
		player1wins.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(player1wins);
		
		player2wins = new JLabel("O wins : " + oWins);
		player2wins.setBounds(520, 170, 250, 30);
		player2wins.setForeground(Color.BLACK);
		player2wins.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(player2wins);
		
		gameBoardBoxes[0][0] = B1;
		gameBoardBoxes[0][1] = B2;
		gameBoardBoxes[0][2] = B3;
		gameBoardBoxes[1][0] = B4;
		gameBoardBoxes[1][1] = B5;
		gameBoardBoxes[1][2] = B6;
		gameBoardBoxes[2][0] = B7;
		gameBoardBoxes[2][1] = B8;
		gameBoardBoxes[2][2] = B9;

		frame.setVisible(true);
		
	}
	
	/**
	 * Checks to see if there is a winner
	 * @return Whether a winner exists
	 */
	public static boolean checkWinner() {
		boolean winner = false;
		// Check horizontal
		for (int i = 0; i < gameBoard.length; i++)
			if (gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2]) && gameBoard[i][0].length() > 0)
				winner = true;
		// Check vertical
		for (int i = 0; i < gameBoard.length; i++)
			if (gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[1][i].equals(gameBoard[2][i]) && gameBoard[0][i].length() > 0)
				winner = true;
		// Check diagonal
		if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]) && gameBoard[0][0].length() > 0)
			winner = true;
		if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]) && gameBoard[0][2].length() > 0)
			winner = true;
		return winner;
	}
	
	/**
	 * Lights up the boxes to make the winner more easily shown
	 */
	public static void showWinner() {
		// Update horizontal
		for (int i = 0; i < gameBoard.length; i++)
			if (gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2]) && gameBoard[i][0].length() > 0)
				for (int z = 0; z <= 2; z++)
					gameBoardBoxes[i][z].setBackground(Color.GRAY);
		// Update vertical
		for (int i = 0; i < gameBoard.length; i++)
			if (gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[1][i].equals(gameBoard[2][i]) && gameBoard[0][i].length() > 0)
				for (int z = 0; z <= 2; z++)
					gameBoardBoxes[z][i].setBackground(Color.GRAY);
		// Update diagonal
		if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]) && gameBoard[0][0].length() > 0)
			for (int i = 0; i <= 2; i++)
				gameBoardBoxes[i][i].setBackground(Color.GRAY);
		if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]) && gameBoard[0][2].length() > 0)
			for (int i = 0; i <= 2; i++)
				gameBoardBoxes[i][2-i].setBackground(Color.GRAY);
	}
	
	/**
	 * Updates the message below and the status of the game
	 */
	public static void updateMessage() { 
		if (checkWinner()) {
			message.setText(currentMove + " Wins!");
			updateCounter(currentMove);
			showWinner();
			disableBoard();
		}
		else if (isBoardFull())
			message.setText("It's a Draw!");
		else {
			if (currentMove.equals("X"))
				currentMove = "O";
			else
				currentMove = "X";
			message.setText("It's " + currentMove + "'s turn.");
		}
	}
	
	/**
	 * Updates the counters
	 */
	public static void updateCounter(String winner) {
		if (winner.equals("X")) {
			xWins++;
			player1wins.setText("X wins : " + xWins);
		}
		else {
			oWins++;
			player2wins.setText("O wins : " + oWins);
		}
			
	}
	
	/**
	 * Checks to see if the board is full
	 * @return Whether the board is full or not
	 */
	public static boolean isBoardFull() {
		for (String[] row : gameBoard)
			for (String col : row)
				if (col.equals(""))
					return false;
		return true;
	}
	
	/**
	 * Disables the gameboard
	 */
	public static void disableBoard() {
		for (int i = 0; i < gameBoard.length; i++)
			for (int z = 0; z < gameBoard.length; z++)
				gameBoard[i][z] = "GG";
	}
	
	/**
	 * Clears the board
	 */
	public static void clearBoard() {
		for (int i = 0; i <= 2; i++)
			for (int z = 0; z <= 2; z++) {
				gameBoard[i][z] = "";
				gameBoardBoxes[i][z].setText("");
				gameBoardBoxes[i][z].setBackground(Color.WHITE);
			}
		updateMessage();
	}
	
	/**
	 * Clears counters
	 */
	public static void clearCounters() {
		xWins = 0;
		oWins = 0;
		player1wins.setText("X wins : " + xWins);
		player2wins.setText("O wins : " + oWins);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == clearBoard)
				clearBoard();
			if (event.getSource() == clearWins)
				clearCounters();
		}
		
	}
	
	/**
	 * Reacts to when the box is clicked
	 * @author Roland
	 *
	 */
	private class LabelAdapter extends MouseAdapter {
		
		private JLabelBox sender;
		
		public LabelAdapter(JLabelBox sender) {
			this.sender = sender;
		}
		
		public void mouseReleased(MouseEvent event) {
			if (gameBoard[sender.row][sender.col].equals("")) {
				sender.setText(currentMove);
				gameBoard[sender.row][sender.col] = currentMove;
				updateMessage();
			}
		}
		
	}
	
	/**
	 * Makes the class for the box
	 * @author Roland
	 *
	 */
	public class JLabelBox extends JLabel {
		
		private static final long serialVersionUID = 1L;
		
		// So the row and column can be identified
		public int row = 0;
		public int col = 0;
		
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
}
