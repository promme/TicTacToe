package ticTacToe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	public GUI() {
		setupLayout();

	}

	ArrayList<JButton> buttons = new ArrayList<JButton>();

	public void setupLayout() {
		setTitle("Tic Tac Toe");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for (int i = 0; i < 9; i++) {
			buttons.add(new JButton("?"));

		}

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(this);
			buttons.get(i).setActionCommand("" + i);
		}
		JPanel leftSide = new JPanel(new GridLayout(0, 3));
		leftSide.add(buttons.get(0));
		leftSide.add(buttons.get(1));
		leftSide.add(buttons.get(2));

		JPanel midSide = new JPanel(new GridLayout(0, 3));
		midSide.add(buttons.get(3));
		midSide.add(buttons.get(4));
		midSide.add(buttons.get(5));

		JPanel rightSide = new JPanel(new GridLayout(0, 3));
		rightSide.add(buttons.get(6));
		rightSide.add(buttons.get(7));
		rightSide.add(buttons.get(8));

		JPanel allSides = new JPanel(new GridLayout(3, 0));
		allSides.add(leftSide);
		allSides.add(midSide);
		allSides.add(rightSide);

		setContentPane(allSides);
	}
	public void resetGame(){
		for (int i = 0; i < buttons.size();i++){
			buttons.get(i).setText("?");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "0":
			buttons.get(0).setText(turns());
			
			break;
		case "1":
			buttons.get(1).setText(turns());
			break;
		case "2":
			buttons.get(2).setText(turns());
			break;
		case "3":
			buttons.get(3).setText(turns());
			break;
		case "4":
			buttons.get(4).setText(turns());
			break;
		case "5":
			buttons.get(5).setText(turns());
			break;
		case "6":
			buttons.get(6).setText(turns());
			break;
		case "7":
			buttons.get(7).setText(turns());
			break;
		case "8":
			buttons.get(8).setText(turns());
			break;

		}
		checkWinner();
	}

	int turn = 0;

	public String turns() {
		turn++;
		
		if ((turn % 2) == 0) {
			return "x";
		} else
			return "o";
		
	}
	int[][] winCombinations = new int[][] { { 0, 1, 2 }, { 3, 4, 5 },
			{ 6, 7, 8 }, // horizontal wins
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // virticle wins
			{ 0, 4, 8 }, { 2, 4, 6 } }; // diagonal wins

	public void checkWinner(){
		 // horizontal wins
		checkWin(0, 1, 2);
		checkWin(3, 4, 5);
		checkWin(6, 7, 8);
		 // virticle wins
		checkWin(0, 3, 6);
		checkWin(1, 4, 7);
		checkWin(2, 5, 8);
		// diagonal wins
		checkWin(0, 4, 8);
		checkWin(2, 4, 6);
		
	}

	public void checkWin(int ans1, int ans2, int ans3) {
		String win =buttons.get(ans1).getText() + buttons.get(ans2).getText() + buttons.get(ans3).getText();
		if (win.equals("xxx")){
			JOptionPane.showMessageDialog(null, "X WINS");
			resetGame();
		}else if(win.equals("ooo")){
			JOptionPane.showMessageDialog(null, "O WINS");
			resetGame();
		}
	}
}