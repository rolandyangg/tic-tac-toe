import javax.swing.*;
import java.awt.*;

/**
 * A game Tic Tac Toe
 * @author whyroland
 * @date 3/15/20
 */
public class TicTacToe {
	
	private String[][] gameBoard = { {"", "", ""}, {"", "", ""}, {"", "", ""} };
	private String currentGameMode = "PP"; // PP = Player vs Player; PB = Player vs Bot, BB = Bot vs Bot
	private String currentMove = "X";
	
	private JFrame frame;
	private JPanel panel;
	private JLabel B1, B2, B3, B4, B5, B6, B7, B8, B9; // The game board
	private JLabel message, gamemodeLabel, player1wins, player2wins;
	private JComboBox gameModes;
	
	public TicTacToe() {

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 520);
		frame.setResizable(false);
		frame.setTitle("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		B1 = new JLabel("X");
		B1.setHorizontalAlignment(SwingConstants.CENTER);
		B1.setOpaque(true);
		B1.setBackground(Color.WHITE);
		B1.setForeground(Color.BLACK);
		B1.setBounds(10, 10, 150, 150);
		B1.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B1);
		
		B2 = new JLabel("X");
		B2.setHorizontalAlignment(SwingConstants.CENTER);
		B2.setOpaque(true);
		B2.setBackground(Color.WHITE);
		B2.setForeground(Color.BLACK);
		B2.setBounds(170, 10, 150, 150);
		B2.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B2);
		
		B3 = new JLabel("X");
		B3.setHorizontalAlignment(SwingConstants.CENTER);
		B3.setOpaque(true);
		B3.setBackground(Color.WHITE);
		B3.setForeground(Color.BLACK);
		B3.setBounds(330, 10, 150, 150);
		B3.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B3);
		
		B4 = new JLabel("X");
		B4.setHorizontalAlignment(SwingConstants.CENTER);
		B4.setOpaque(true);
		B4.setBackground(Color.WHITE);
		B4.setForeground(Color.BLACK);
		B4.setBounds(10, 170, 150, 150);
		B4.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B4);
		
		B5 = new JLabel("X");
		B5.setHorizontalAlignment(SwingConstants.CENTER);
		B5.setOpaque(true);
		B5.setBackground(Color.WHITE);
		B5.setForeground(Color.BLACK);
		B5.setBounds(170, 170, 150, 150);
		B5.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B5);
		
		B6 = new JLabel("X");
		B6.setHorizontalAlignment(SwingConstants.CENTER);
		B6.setOpaque(true);
		B6.setBackground(Color.WHITE);
		B6.setForeground(Color.BLACK);
		B6.setBounds(330, 170, 150, 150);
		B6.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B6);
		
		B7 = new JLabel("X");
		B7.setHorizontalAlignment(SwingConstants.CENTER);
		B7.setOpaque(true);
		B7.setBackground(Color.WHITE);
		B7.setForeground(Color.BLACK);
		B7.setBounds(10, 330, 150, 150);
		B7.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B7);
		
		B8 = new JLabel("X");
		B8.setHorizontalAlignment(SwingConstants.CENTER);
		B8.setOpaque(true);
		B8.setBackground(Color.WHITE);
		B8.setForeground(Color.BLACK);
		B8.setBounds(170, 330, 150, 150);
		B8.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B8);
		
		B9 = new JLabel("X");
		B9.setHorizontalAlignment(SwingConstants.CENTER);
		B9.setOpaque(true);
		B9.setBackground(Color.WHITE);
		B9.setForeground(Color.BLACK);
		B9.setBounds(330, 330, 150, 150);
		B9.setFont(new Font("Roboto", Font.BOLD, 125));
		panel.add(B9);
		
		message = new JLabel("It is " + currentMove + "'s turn.");
		message.setForeground(Color.BLACK);
		message.setBounds(520, 430, 200, 30);
		message.setFont(new Font("Roboto", Font.BOLD, 30));
		panel.add(message);

		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
}
