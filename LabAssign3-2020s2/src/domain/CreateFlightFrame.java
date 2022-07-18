 package domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import system.MainSystem;

public class CreateFlightFrame extends JFrame{
	
	//components
	private JLabel lblOrigin=new JLabel("Select origin:");
	private JLabel lblDestination=new JLabel("Select destination:");
	private JLabel lblFlightCode=new JLabel("Enter flight code:");
	private JLabel lblSeats=new JLabel("Enter number of seats:");
	private JTextField tfFlightCode=new JTextField(200);
	private JTextField tfSeats=new JTextField(200);
	private JComboBox cbOrigin;
	private JComboBox cbDestination;
	private JButton btnCreate=new JButton("Create");
	private JButton btnClose=new JButton("Close");
	private JLabel lblTip=new JLabel("");
	
	public CreateFlightFrame(){
		
		//set appearance
		this.setBounds(200,100,600,600);
		this.setTitle("Create a Flight");
		String []city= {"Melbourne","Sydney","Brisbane","Adelaide","Perth","Hobart","Darwin"};
		cbOrigin=new JComboBox(city);
		cbDestination=new JComboBox(city);
		
		lblTip.setForeground(Color.red);
		lblTip.setFont(new Font("Courier", Font.LAYOUT_NO_LIMIT_CONTEXT,15));
		lblOrigin.setFont(new Font("Courier", Font.BOLD,30));
		lblDestination.setFont(new Font("Courier", Font.BOLD,30));
		lblFlightCode.setFont(new Font("Courier", Font.BOLD,30));
		lblSeats.setFont(new Font("Courier", Font.BOLD,30));
		tfFlightCode.setFont(new Font("Courier", Font.BOLD,30));
		tfSeats.setFont(new Font("Courier", Font.BOLD,30));
		cbOrigin.setFont(new Font("Courier", Font.BOLD,30));
		cbDestination.setFont(new Font("Courier", Font.BOLD,30));
		btnCreate.setFont(new Font("Courier", Font.BOLD,30));
		btnClose.setFont(new Font("Courier", Font.BOLD,30));
		
		this.add(lblOrigin);
		this.add(cbOrigin);
		this.add(lblDestination);
		this.add(cbDestination);
		this.add(lblFlightCode);
		this.add(tfFlightCode);
		this.add(lblSeats);
		this.add(tfSeats);
		this.add(btnCreate);
		this.add(btnClose);
		this.add(lblTip);
		
		this.setLayout(new GridLayout(0,2,30,30));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		btnClose.addActionListener(new ActionListener() {//back to menu
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuFrame();
				setVisible(false);
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {//judge whether the input is usable and creat a flight
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbOrigin.getSelectedIndex()==cbDestination.getSelectedIndex()) {
					lblTip.setText("Origin and destination could not be same.");
				}
				else if(tfFlightCode.getText().length()==0) {
					lblTip.setText("Flight code can not be empty");
				}
				else if(tfSeats.getText().length()==0) {
					lblTip.setText("FNumber of seats can not be empty");
				}
				else if(Integer.parseInt(tfSeats.getText())>200||Integer.parseInt(tfSeats.getText())<0) {
					lblTip.setText("Number of seats should be within 200");
				}
				else if(MainSystem.database.flightIsInDatabase(tfFlightCode.getText())) {
					lblTip.setText("This flight has already been created.");
				}
				
				else {//inputs are usable
					MainSystem.database.addFlight(new Flight(cbOrigin.getSelectedItem().toString(),cbDestination.getSelectedItem().toString(),tfFlightCode.getText(),Integer.parseInt(tfSeats.getText())));
					lblTip.setText("Flight sucessfully created.");
					tfFlightCode.setText("");
					tfSeats.setText("");
					
				}
				
				
			//following will not be used
				
			//	if(/*!isInteger(tfSeats.getText())|*/(Integer.parseInt(tfSeats.getText())>200)| (Integer.parseInt(tfSeats.getText())<=0)) {
			//		lblTip.setText("Number of seats should be an integer lower than 200.");
			//	}
				
				
			}
		});
		
	}

	/*private boolean isInteger(String seatValue)
	  {
		if(tfSeats.getText()!=""){
			    try
			    {
			      Integer.parseInt(seatValue);
			      return true;
			    }
			    catch (NumberFormatException e)
			    {
			      return false;
			    }
		  }
		return false;
	  }*/



}
