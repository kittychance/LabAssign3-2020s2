package domain;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenuFrame extends JFrame{
	//create buttons and label of the frame
	private JLabel title=new JLabel("Flight Management System",JLabel.CENTER);
	private JButton button1=new JButton("Creat a Flight");
	private JButton button2=new JButton("Book a Seat");
	private JButton button3=new JButton("Retrieve Flight");
	private JButton button4=new JButton("Quit");
	
	public MainMenuFrame() {
		//setup the frame
		this.setTitle("Main Menu");
		this.setBounds(200,100,600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5,1,25,25));	
		this.setVisible(true);
		/*this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
		
		//set and add the label and buttons
		title.setFont(new Font("Courier", Font.BOLD,40));
		title.setSize(300,50);
		button1.setFont(new Font("Courier", Font.BOLD,30));
		button2.setFont(new Font("Courier", Font.BOLD,30));
		button3.setFont(new Font("Courier", Font.BOLD,30));
		button4.setFont(new Font("Courier", Font.BOLD,30));
		this.add(title);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateFlightFrame();
				setVisible(false);
			}
		});
	
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BookFlightFrame();
				setVisible(false);
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RetrieveFlightFrame();
				setVisible(false);
			}
		});
		
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
	}
}

