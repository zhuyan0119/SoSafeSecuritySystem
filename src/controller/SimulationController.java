package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.FireSensor;
import model.IntruderSensor;
import model.Sensor;
import model.SensorBank;
import model.SensorGroup;

public class SimulationController extends JPanel {
	private SensorBank sensorbank;
	private JComboBox groupCombo, positionCombo;
	private JButton fireButton, intruderButton;
	private JLabel groupLabel, positionLabel;
	
	public SimulationController(SensorBank sensorbank){
		super();
		this.sensorbank = sensorbank;
		groupLabel = new JLabel("Sensor Group ");
		positionLabel = new JLabel("Sensor Position ");
		JComboBox cbx1 = groupComboBox();
		JComboBox cbx2 = positionComboBox();
		
		fireButton = new JButton("fire");
		intruderButton = new JButton("intruder");
		setLayout(new FlowLayout());
		add(groupLabel);
		add(cbx1);
		add(positionLabel);
		add(cbx2);
		add(fireButton);
		add(intruderButton);
		
		// fireBtton is to turn on the fire sensor in the chosen section, and chosen location ( only if installed and status is on). 
		
		fireButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				
				SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				Sensor[] sensorArray = sensorbank.getGroup(sg);
				for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof FireSensor){
							sensorArray[i].setOnSensorAlert();
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
							sensorArray[i].setOnSensorAlert();
						}
					}
				}
						
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

}
