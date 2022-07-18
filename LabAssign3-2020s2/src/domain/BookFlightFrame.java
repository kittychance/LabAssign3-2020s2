package domain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.MainSystem;

public class BookFlightFrame extends JFrame{
	//create components
	private JLabel lblName=new JLabel("Name:");
	private JLabel lblNationality=new JLabel("Nationality:");
	private JLabel lblDiet=new JLabel("Dietary requirements:");
	private JLabel lblChild=new JLabel("Has young child/baby:");
	private JLabel lblFlightCode=new JLabel("Flight code:");
	private JLabel lblSeat=new JLabel("Seat:");
	private JLabel lblNull=new JLabel("");
	private JButton btnBook=new JButton("Book");
	private JButton btnClose=new JButton("Close");
	private JTextField tfName=new JTextField(200);
	private JTextField tfNationality=new JTextField(200);
	private JTextField tfDiet=new JTextField(200);
	private JTextField tfFlightCode=new JTextField(200);
	private JTextField tfSeat=new JTextField(200);
	private JComboBox cbChild;
	private JLabel lblTip=new JLabel("");
	//String []whether= {"Yes","No"};
	private JRadioButton rbYes=new JRadioButton("Yes");
	private JRadioButton rbNo=new JRadioButton("No");
	private ButtonGroup bg=new ButtonGroup();
	
	public BookFlightFrame() {//set appearance
		this.setTitle("Main Menu");
		this.setBounds(200,100,600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(0,2,30,30));	
		this.setVisible(true);
		lblTip.setForeground(Color.red);
		
		//cbChild=new JComboBox<Object>(whether);
		
		this.add(lblName);
		this.add(tfName);
		this.add(lblNationality);
		this.add(tfNationality);
		this.add(lblDiet);
		this.add(tfDiet);
		this.add(lblChild);
		this.add(lblNull);
		this.add(rbYes);
		this.add(rbNo);
		this.add(lblFlightCode);
		this.add(tfFlightCode);
		this.add(lblSeat);
		this.add(tfSeat);
		this.add(btnBook);
		this.add(btnClose);
		this.add(lblTip);
		
		bg.add(rbYes);
		bg.add(rbNo);
		
		btnClose.addActionListener(new ActionListener() {//back to menu
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuFrame();
				setVisible(false);
			}
		});
		
		btnBook.addActionListener(new ActionListener() {//judge whether the input can be used and book a seat
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfName.getText().length()==0) {
					lblTip.setText("Please enter the name.");
				}
				else if(tfNationality.getText().length()==0) {
					lblTip.setText("Please enter the nationality.");
				}
				else if(tfFlightCode.getText().length()==0) {
					lblTip.setText("Please enter the flight code.");
				}
				else if(tfSeat.getText().length()==0) {
					lblTip.setText("Please enter the seat number.");
				}
				else if(!(rbYes.isSelected()||rbNo.isSelected())){
					lblTip.setText("Please indicate whether has young child/baby.");
				}
				else if(!MainSystem.database.flightIsInDatabase(tfFlightCode.getText())) {
					lblTip.setText("This flight does not exist.");
				}
				else if(MainSystem.database.getFlight(tfFlightCode.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText()))!=null) {
					lblTip.setText("This seat has already been booked.");
				}
				
				else {//inputs are usable, create a passenger and book a seat
					MainSystem.database.getFlight(tfFlightCode.getText()).setPassengerForSeat(Integer.parseInt(tfSeat.getText()), new Passenger(tfName.getText(),tfNationality.getText()));
					if(lblDiet.getText().length()!=0) {
						MainSystem.database.getFlight(tfFlightCode.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).setDietaryNeeds(tfDiet.getText());
					}
					if(rbYes.isSelected()) {
						MainSystem.database.getFlight(tfFlightCode.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).setHasYoungChild(true);
					}
					else if(rbNo.isSelected()) {
						MainSystem.database.getFlight(tfFlightCode.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).setHasYoungChild(false);
					}
					lblTip.setText("Successfully booked.");
					tfName.setText("");
					tfNationality.setText("");
					tfDiet.setText("");
					tfFlightCode.setText("");
					tfSeat.setText("");
					rbYes.setSelected(false);
					rbNo.setSelected(false);
					
				}
			}
		});
		
	}
	
}
