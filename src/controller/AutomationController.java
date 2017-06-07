package controller;

import model.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AutomationController extends JPanel
{
	private SensorBank sensorBank;
	private JLabel autoLabel;

	public AutomationController(SensorBank controlledSensorBank)
	{
		super();
		sensorBank = controlledSensorBank;
		autoLabel = new JLabel("Auto Control is");

		JButton controllButton = new JButton();
		if(sensorBank.getAutomation()){
			controllButton.setText("ON");
			
		}
		else
			controllButton.setText("Off");

		controllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if (controllButton.getText().equals("on")) 
				{
					sensorBank.setAutomation(true);
					controllButton.setText("off");
				}
				 else 
				 {
					sensorBank.setAutomation(false);
					controllButton.setText("on");
				}
			}

		});

		add(autoLabel);
		add(controllButton);

	}


}
