package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

import logic.JsonParser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualFrame frame = new VisualFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 JsonParser p = new JsonParser();
	}

	/**
	 * Create the frame.
	 */
	public VisualFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JsonParser p = new JsonParser();
		JTextPane textPane = new JTextPane();
		textPane.setBounds(128, 245, 59, 20);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Beolvasás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p.readInputFile("res\\input.txt");
			}
		});
		btnNewButton.setBounds(304, 57, 89, 23);
		contentPane.add(btnNewButton);
	}
}
