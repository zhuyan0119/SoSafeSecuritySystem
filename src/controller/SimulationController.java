package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.BillingInfo;
import model.FireSensor;
import model.IntruderSensor;
import model.Sensor;
import model.SensorBank;
import model.SensorGroup;

public class SimulationController extends JPanel {
	private SensorBank sensorbank;
	private JComboBox groupCombo, positionCombo;
	private JButton fireButton, intruderButton, turnOffIntruder,turnOffFire;
	private JLabel groupLabel, positionLabel;
	private Timer fireTimer,intruderTimer;
	private BillingInfo bill;
	private ImageIcon fireService;	
	private ImageIcon intruderService;
    private JTextArea alarmLogTextArea;;

	public SimulationController(SensorBank sensorbank,BillingInfo bill){
		super();
		this.sensorbank = sensorbank;
		this.bill = bill;
		groupLabel = new JLabel("Sensor Group ");
		positionLabel = new JLabel("Sensor Position ");
		JComboBox cbx1 = groupComboBox();
		JComboBox cbx2 = positionComboBox();
		
		fireButton = new JButton("fire");
		intruderButton = new JButton("intruder");
		
		
		JPanel panel1 = new JPanel();
		panel1.add(groupLabel);
		panel1.add(cbx1);
		panel1.add(positionLabel);
		panel1.add(cbx2);
		
		JPanel panel2 = new JPanel ();
		panel2.setLayout(new FlowLayout());
		panel2.add(fireButton);
		panel2.add(intruderButton);
		
        alarmLogTextArea = new JTextArea();
        alarmLogTextArea.setEditable(false);
        JScrollPane alarmLogScrollPane = new JScrollPane(alarmLogTextArea);
		JPanel panel3 = new JPanel ();
		panel3.setLayout(new BorderLayout());
        panel3.add(alarmLogScrollPane);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//layout.setVgap(3);
		//this.setLayout(layout);
		
		add(panel1);
		add(panel2);
        add(panel3);
		
		/*
		add(groupLabel);
		add(cbx1);
		add(positionLabel);
		add(cbx2);
		add(fireButton);
		add(intruderButton);
		*/
		fireService = new ImageIcon("fire service.jpg");

				

		
		// fireBtton is to turn on the fire sensor in the chosen section, and chosen location ( only if installed and status is on). 
		
		fireButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				
				SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				Sensor[] sensorArray = sensorbank.getGroup(sg);
				for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof FireSensor){
							if(sensorArray[i].getstatus()==1){
								sensorArray[i].setOnSensorAlert();
								fireTimer.setRepeats(false);
								fireTimer.start();
							}
								
					}
				}
						
			}
		}
	});


		
		// intruderBtton is to turn on the fire sensor in the chosen section, and chosen location ( only if installed and status is on).
		intruderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				Sensor[] sensorArray = sensorbank.getGroup(sg);
				for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof IntruderSensor){
							if(sensorArray[i].getstatus()==1)
							sensorArray[i].setOnSensorAlert();
							intruderTimer.setRepeats(false); 
							intruderTimer.start();    
						}
					}
				}
						
			}
		});
		
		// initiate timer
		fireTimer = new Timer(1000*10, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	 //JOptionPane.setMessage("fire alarm, call phone 1234567");
		        
                alarmLogTextArea.append("calling\n");
		        //JOptionPane.showMessageDialog(fireButton,"call 123-4567-8910","service",JOptionPane.INFORMATION_MESSAGE);
		        bill.incrementNumFireAlarmCalls();
		      }
		    });
		
		intruderTimer = new Timer(1000*10, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  JOptionPane.showMessageDialog(intruderButton,"call 321-4567-8910","service",JOptionPane.INFORMATION_MESSAGE);
		        bill.incrementNumIntruderAlarmCalls();
		      }
		    });

	}
	
	public JComboBox groupComboBox()
	{
		String[] group = {" ","NORTH","SOUTH","EAST","WEST"};
		groupCombo = new JComboBox(group);

		groupCombo.setForeground(Color.BLUE);
		groupCombo.setFont(new Font("Arial", Font.BOLD, 10));
      	groupCombo.setEditable(true);

      	groupCombo.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent e)
      		{
      			JComboBox cb= (JComboBox)e.getSource();
      			String type = (String)cb.getSelectedItem();
      			groupLabel.setText(type);
	
      		}
      	});
      	return groupCombo;
	}
	public JComboBox positionComboBox()
	{
		String[] position = {" ","Position1","Position2","Position3"};
		positionCombo = new JComboBox(position);

		positionCombo.setForeground(Color.BLUE);
		positionCombo.setFont(new Font("Arial", Font.BOLD, 20));
      	positionCombo.setEditable(true);

      	positionCombo.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent e)
      		{
      			JComboBox cb1= (JComboBox)e.getSource();
      			String type1 = (String)cb1.getSelectedItem();
      			positionLabel.setText(type1);
      		}
      	});
      	return positionCombo;

	}
	
	public void fireAlertTimer(){
		
	}
	
	public void intruderAlertTimer(){
		
	}
	
	
 }



