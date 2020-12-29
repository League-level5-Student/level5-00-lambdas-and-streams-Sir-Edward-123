package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LambdaButtons implements ActionListener {
	private JFrame window = new JFrame();
	private JButton addNumbers = new JButton("ADD 2 Numbers");
	private JButton randNumber = new JButton("RANDOM NUMBER");
	private JButton tellAJoke = new JButton("TELL A JOKE");
	
	public LambdaButtons() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.add(addNumbers);
		window.add(randNumber);
		window.add(tellAJoke);
		
		//1. Call the addActionListener methods for each button. Use lambdas
		//   to define to functionality of the buttons.
		addNumbers.addActionListener(this);
		randNumber.addActionListener(this);
		tellAJoke.addActionListener(this);
		
		window.setVisible(true);
		window.pack();
	}
	
	public static void main(String[] args) {
		new LambdaButtons();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addNumbers) {
			AddButton addButton = (int a, int b) -> a + b;
			JOptionPane.showMessageDialog(null, addButton.addition(
					Integer.parseInt(JOptionPane.showInputDialog("First Number:")), 
					Integer.parseInt(JOptionPane.showInputDialog("Second Number"))
			));
		} else if(e.getSource() == randNumber) {
			RandNumberButton randomNumberButton = (Random rand) -> rand.nextInt();
			JOptionPane.showMessageDialog(null, randomNumberButton.random(new Random()));
		} else if(e.getSource() == tellAJoke) {
			JokeButton jokeButton = () -> "Why did the chicken cross the road? To get to the other side!";
			JOptionPane.showMessageDialog(null, jokeButton.joke());
		}
	}
	
	interface AddButton {
		int addition(int a, int b);
	}
	
	interface RandNumberButton {
		int random(Random rand);
	}
	
	interface JokeButton {
		String joke();
	}

}
