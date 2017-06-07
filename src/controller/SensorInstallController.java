package controller;

import model.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SensorInstallController extends JPanel
{
	private SensorBank sensorbank;
	//private PassWordData passworddata;
	JLabel groupLabel,positionLabel,sensorLabel;
	JComboBox cbx1,cbx2,cbx3;
	

	

	
	public SensorInstallController(SensorBank controlledSensorBank)
	{
		
		super();
		PasswordController passwordController = new PasswordController(controlledSensorBank);
		sensorbank = controlledSensorBank;
		groupLabel = new JLabel("Sensor Group ");
		positionLabel = new JLabel("Sensor Position ");
		sensorLabel = new JLabel("Sensor Type ");

		cbx1 = groupComboBox();
		cbx2 = positionComboBox();
		cbx3 = sensorComboBox();


		JButton installButton = new JButton("Install ");

		//setBorder(new TitledBorder("Installation"));
		//setLayout(null);

		setLayout(new FlowLayout());
		add(sensorLabel);
		add(cbx3);
		add(groupLabel);
		add(cbx1);
		add(positionLabel);
		add(cbx2);
		add(installButton);
		add(passwordController);
		
		installButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
			
				boolean sensorExist = sensorbank.checkInstalledOrNot(SensorGroup.valueOf(groupLabel.getText()),convertPosition(positionLabel.getText()));
				if (!sensorExist)
				{
					if (sensorLabel.getText() == "FireSensor")
					{
						Sensor sensor = new FireSensor();
						sensorbank.insertSensor(sensor,SensorGroup.valueOf(groupLabel.getText()),convertPosition(positionLabel.getText()));
					}
					if (sensorLabel.getText() =="IntruderSensor")
					{
						Sensor sensor = new IntruderSensor();
						sensorbank.insertSensor(sensor,SensorGroup.valueOf(groupLabel.getText()),convertPosition(positionLabel.getText()));

					}		
				}			
			}
		});

	}

	public JComboBox groupComboBox()
	{
		String[] group = {" ","NORTH","SOUTH","EAST","WEST"};
		JComboBox groupCombo = new JComboBox(group);

		groupCombo.setForeground(Color.BLUE);
		groupCombo.setFont(new Font("Arial", Font.BOLD, 20));
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
		JComboBox positionCombo = new JComboBox(position);

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
	public JComboBox sensorComboBox()
	{
		String[] sensorType = {" ", "FireSensor", "IntruderSensor"};
		JComboBox sensorCombo = new JComboBox(sensorType);

		sensorCombo.setForeground(Color.BLUE);
		sensorCombo.setFont(new Font("Arial", Font.BOLD, 20));
      	sensorCombo.setEditable(true);

      	sensorCombo.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent e)
      		{
      			JComboBox cb2= (JComboBox)e.getSource();
      			String type2 = (String)cb2.getSelectedItem();
      			sensorLabel.setText(type2);
      		}
      	});
      	return sensorCombo;

	}
	int convertPosition(String input)
	{
		if(input == "Position1")
		{
			return 0;
		}
		else if(input == "Position2")
		{
			return 1;
		}
		else if(input == "Position3")
		{
			return 2;
		}
		else
		{
			return -1;
		}

	}

}

