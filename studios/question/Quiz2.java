package question;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Quiz2 {

	QuizList quizList = new QuizList();

	private JFrame frmMakeQuizList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz2 window = new Quiz2();
					window.frmMakeQuizList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quiz2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMakeQuizList = new JFrame();
		frmMakeQuizList.setTitle("Make Quiz List");
		frmMakeQuizList.setBounds(100, 100, 450, 225);
		frmMakeQuizList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMakeQuizList.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(197, 22, 236, 163);
		frmMakeQuizList.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Add New Question");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizList.createQuestion();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setBounds(6, 17, 179, 29);
		frmMakeQuizList.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Remove Question");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setBounds(6, 46, 179, 29);
		frmMakeQuizList.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Run Quiz");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setForeground(new Color(0, 102, 0));
		btnNewButton_4.setBounds(6, 138, 179, 29);
		frmMakeQuizList.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("EXIT");
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(6, 164, 179, 29);
		frmMakeQuizList.getContentPane().add(btnNewButton_5);
	}
}
