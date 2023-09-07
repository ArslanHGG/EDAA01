package sudoku;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class UserInterface {
	public UserInterface() {
		SwingUtilities.invokeLater(() -> createWindow("Soduko", 450, 450));
		
	}

	private void createWindow(String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout());
        JTextField [][] grid = new JTextField[9][9];
        JPanel panel = new JPanel();
        for(int r = 0; r < 9; r++) {
        	for(int c = 0; c < 9; c++) {
        		grid[r][c] = new JTextField();
        		grid[r][c].setVisible(true);
        		grid[r][c].setPreferredSize(new Dimension(50, 50));
        		panel.add(grid[r][c]);
        	}
        }
		frame.add(panel);
        frame.pack();
        frame.setVisible(true);
		
	}
	private void input() {
		
	}
}
