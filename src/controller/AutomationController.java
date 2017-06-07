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
		autoLabel = new JLabel("Auto Control");

		final JButton controllButton = new JButton("off");

		controllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if (controllButton.getText().equals("on")) 
				{
					sensorBank.setAutomation(false);
					//controllButton.setText("off");
					controllButton.setText("off");

				}
				 else 
				 {
					sensorBank.setAutomation(true);
					controllButton.setText("on");
				}
			}

		});

		add(autoLabel);
		add(controllButton);

	}

	/*public static void main(String args[])	
	{
		SensorBank sb = new SensorBank();
		AutomationController ac = new AutomationController(sb);
		
		
		JFrame f = new JFrame();
		f.getContentPane().add(ac);
		f.setLayout(new FlowLayout());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	*/
	

}
