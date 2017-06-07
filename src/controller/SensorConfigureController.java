package controller;

import model.*;
import sensorview.SingleSensorVIew;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SensorConfigureController extends JPanel
{
	private SensorBank sensorBank;
	private SensorSchedule sensorSchedule;

	private JComboBox groupCombo;
	private JLabel groupLabel,startTimeLabel,endTimeLabel;
	private JTextField sTTextField, eTTextField;
	
	private SimulationController simulationController;

	public SensorConfigureController(SensorBank controlledSensorBank, SensorSchedule controlledSensorSchedule)
	{
		super();
		sensorBank  = controlledSensorBank;
		sensorSchedule = controlledSensorSchedule;

		groupLabel = new JLabel("Sensor Group ");
		startTimeLabel = new JLabel("Start Time ");
		endTimeLabel = new JLabel("End Time ");

		sTTextField = new JTextField(10);
		eTTextField = new JTextField(10);

		simulationController = new SimulationController(controlledSensorBank);



		JComboBox cbx = groupComboBox();

		JButton scheduleButton = new JButton("Schedule ");

		setLayout(new FlowLayout());
		add(groupLabel);
		add(cbx);
		add(startTimeLabel);
		add(sTTextField);
		add(endTimeLabel);
		add(eTTextField);
		add(scheduleButton);
		add(simulationController);
		


		scheduleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					SensorTime startTime = new SensorTime(sTTextField.getText());
					SensorTime endTime =new SensorTime(eTTextField.getText());
					sensorSchedule.insertTimeRange(SensorGroup.valueOf(groupLabel.getText()),startTime,endTime);
				}
				catch(TimeFormatException exception)
				{
					JOptionPane.showMessageDialog(SensorConfigureController.this,"Please enter a valid time","Error",JOptionPane.ERROR_MESSAGE);

				}
			}

		});
	}
	public JComboBox groupComboBox()
	{
		String[] group = {" ","NORTH","SOUTH","EAST","WEST"};
		groupCombo = new JComboBox(group);

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
	
}


