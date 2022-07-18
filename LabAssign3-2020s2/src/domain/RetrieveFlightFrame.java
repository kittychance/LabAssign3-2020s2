package domain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import system.MainSystem;

public class RetrieveFlightFrame extends JFrame{//create components
	private JLabel lblFlight=new JLabel("Retrieve a flight:");
	private JLabel lblSeat=new JLabel("Retrieve a seat:");
	private JLabel lblTip=new JLabel("");
	private JTextField tfFlight=new JTextField(200);
	private JTextField tfSeat=new JTextField(200);
	private JButton btnFlight=new JButton("Retrieve");
	private JButton btnSeat=new JButton("Retrieve");
	private JButton btnClose=new JButton("Close");
	private JLabel lblOrigin=new JLabel("Origin:");
	private JLabel lblDestination=new JLabel("Destionation:");
	private JLabel lblTotalSeats=new JLabel("Total seats:");
	private JLabel lblBookedSeats=new JLabel("Booked seats:");
	private JLabel lblName=new JLabel("Name:");
	private JLabel lblNationality=new JLabel("Nationality:");
	private JLabel lblDiet=new JLabel("Dietary Requirements:");
	private JLabel lblChild=new JLabel("Has young child/baby:");
	private JLabel lblOriginInfo=new JLabel("");
	private JLabel lblDestinationInfo=new JLabel("");
	private JLabel lblTotalSeatsInfo=new JLabel("");
	private JLabel lblBookedSeatsInfo=new JLabel("");
	private JLabel lblNameInfo=new JLabel("");
	private JLabel lblNationalityInfo=new JLabel("");
	private JLabel lblDietInfo=new JLabel("");
	private JLabel lblChildInfo=new JLabel("");
	private JLabel lblNull1=new JLabel("");
	private JLabel lblNull2=new JLabel("");

	public RetrieveFlightFrame() {//set appearance
		
		this.setTitle("Main Menu");
		this.setBounds(200,100,600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(0,2,10,10));	
		this.setVisible(true);
		
		this.add(lblFlight);
		this.add(tfFlight);
		this.add(lblNull1);
		this.add(btnFlight);
		
		this.add(lblOrigin);
		this.add(lblOriginInfo);
		this.add(lblDestination);
		this.add(lblDestinationInfo);
		
		this.add(lblTotalSeats);
		this.add(lblTotalSeatsInfo);
		this.add(lblBookedSeats);
		this.add(lblBookedSeatsInfo);
		
		this.add(lblSeat);
		this.add(tfSeat);
		this.add(lblNull2);
		this.add(btnSeat);
		
		this.add(lblName);
		this.add(lblNameInfo);
		this.add(lblNationality);
		this.add(lblNationalityInfo);
		
		this.add(lblDiet);
		this.add(lblDietInfo);
		this.add(lblChild);
		this.add(lblChildInfo);
		
		this.add(lblTip);
		this.add(btnClose);
		
		lblTip.setForeground(Color.red);
		
		lblOrigin.setVisible(false);
		lblDestination.setVisible(false);
		lblTotalSeats.setVisible(false);
		lblBookedSeats.setVisible(false);
		lblOriginInfo.setVisible(false);
		lblDestinationInfo.setVisible(false);
		lblTotalSeatsInfo.setVisible(false);
		lblBookedSeatsInfo.setVisible(false);
		lblSeat.setVisible(false);
		tfSeat.setVisible(false);
		btnSeat.setVisible(false);
		lblName.setVisible(false);
		lblNameInfo.setVisible(false);
		lblNationality.setVisible(false);
		lblNationalityInfo.setVisible(false);
		lblDiet.setVisible(false);
		lblDietInfo.setVisible(false);
		lblChild.setVisible(false);
		lblChildInfo.setVisible(false);
		
		btnClose.addActionListener(new ActionListener() {//back to menu
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuFrame();
				setVisible(false);
			}
		});
		
		btnFlight.addActionListener(new ActionListener() {//retrieve a flight
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfFlight.getText().length()==0) {//insure has text
					lblTip.setText("Please enter a flight code.");
				}
				else if(!MainSystem.database.flightIsInDatabase(tfFlight.getText())) {//confirm flight exist
					lblTip.setText("This flight does not exist.");
					lblOrigin.setVisible(false);
					lblDestination.setVisible(false);
					lblTotalSeats.setVisible(false);
					lblBookedSeats.setVisible(false);
					lblOriginInfo.setVisible(false);
					lblDestinationInfo.setVisible(false);
					lblTotalSeatsInfo.setVisible(false);
					lblBookedSeatsInfo.setVisible(false);
					lblSeat.setVisible(false);
					tfSeat.setVisible(false);
					btnSeat.setVisible(false);
					lblName.setVisible(false);
					lblNameInfo.setVisible(false);
					lblNationality.setVisible(false);
					lblNationalityInfo.setVisible(false);
					lblDiet.setVisible(false);
					lblDietInfo.setVisible(false);
					lblChild.setVisible(false);
					lblChildInfo.setVisible(false);
				}
				else {//retrieve a flight
					lblOrigin.setVisible(true);
					lblDestination.setVisible(true);
					lblTotalSeats.setVisible(true);
					lblBookedSeats.setVisible(true);
					lblOriginInfo.setVisible(true);
					lblDestinationInfo.setVisible(true);
					lblTotalSeatsInfo.setVisible(true);
					lblBookedSeatsInfo.setVisible(true);
					lblSeat.setVisible(true);
					tfSeat.setVisible(true);
					btnSeat.setVisible(true);
					lblName.setVisible(false);
					lblNameInfo.setVisible(false);
					lblNationality.setVisible(false);
					lblNationalityInfo.setVisible(false);
					lblDiet.setVisible(false);
					lblDietInfo.setVisible(false);
					lblChild.setVisible(false);
					lblChildInfo.setVisible(false);
					
					lblOriginInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getOrigin());
					lblDestinationInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getDestination());
					lblTotalSeatsInfo.setText(Integer.toString(MainSystem.database.getFlight(tfFlight.getText()).getTotalSeats()));
					lblBookedSeatsInfo.setText(Integer.toString(MainSystem.database.getFlight(tfFlight.getText()).getTotalBooked()));
					lblTip.setText("");
					tfSeat.setText("");
				}
				
			}
		});
		
		btnSeat.addActionListener(new ActionListener() {//retrieve a seat
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfSeat.getText().length()==0) {//confirm has text
					lblTip.setText("Please enter a seat.");
				}
				else if(Integer.parseInt(tfSeat.getText())>MainSystem.database.getFlight(tfFlight.getText()).getTotalSeats()||tfSeat.getText()=="0") {
					lblTip.setText("This seat does not exist.");
				}//confirm seat exist
				else if(MainSystem.database.getFlight(tfFlight.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText()))==null) {
					lblTip.setText("No passenger booked this seat.");
					lblName.setVisible(false);
					lblNameInfo.setVisible(false);
					lblNationality.setVisible(false);
					lblNationalityInfo.setVisible(false);
					lblDiet.setVisible(false);
					lblDietInfo.setVisible(false);
					lblChild.setVisible(false);
					lblChildInfo.setVisible(false);
				}//confirm seat has been booked
				else {
					//retrieve a passenger of the seat
					lblName.setVisible(true);
					lblNameInfo.setVisible(true);
					lblNationality.setVisible(true);
					lblNationalityInfo.setVisible(true);
					lblDiet.setVisible(true);
					lblDietInfo.setVisible(true);
					lblChild.setVisible(true);
					lblChildInfo.setVisible(true);
					
					lblNameInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).getName());
					lblNationalityInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).getNationality());
					lblDietInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).getDietaryNeeds());
					lblChildInfo.setText(MainSystem.database.getFlight(tfFlight.getText()).getPassengerForSeat(Integer.parseInt(tfSeat.getText())).getHasYoungChildtoString());
					lblTip.setText("");
					
				}
			}
		});
	}



}
