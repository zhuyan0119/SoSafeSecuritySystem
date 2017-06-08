package controller;

import model.*;
import sensorview.SingleSensorVIew;
import view.*;

import javax.swing.*;
import javax.swing.border.Border;
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
	private AutomationController automationController;

	private ScheduleShowView scheduleShowView;


	public SensorConfigureController(SensorBank controlledSensorBank, SensorSchedule controlledSensorSchedule,BillingInfo bill)
	{
		super();
		sensorBank  = controlledSensorBank;
		sensorSchedule = controlledSensorSchedule;
		automationController = new AutomationController(controlledSensorBank);
		simulationController = new SimulationController(controlledSensorBank,bill);
		scheduleShowView = new ScheduleShowView(sensorSchedule);

        sensorSchedule.addObserver(scheduleShowView);
		
		groupLabel = new JLabel("Sensor Group ");
		startTimeLabel = new JLabel("Start Time ");
		endTimeLabel = new JLabel("End Time ");
		JComboBox cbx = groupComboBox();
		JButton scheduleButton = new JButton("Schedule ");
		JButton reSetScheduleButton = new JButton("Reset Schedule");

		sTTextField = new JTextField(10);
		eTTextField = new JTextField(10);
		
	
		
		

		JPanel schedulePanel = new JPanel();
		
		

		JPanel groupPanel = new JPanel();
		groupPanel.add(groupLabel);
		groupPanel.add(cbx);
		schedulePanel.add(groupPanel);
		
		
		JPanel setTimePanel = new JPanel();
		setTimePanel.add(startTimeLabel);
		setTimePanel.add(sTTextField);
		setTimePanel.add(endTimeLabel);
		setTimePanel.add(eTTextField);
		
		JPanel panelbutton = new JPanel();
		panelbutton.setLayout(new FlowLayout());
		panelbutton.add(scheduleButton);
		panelbutton.add(reSetScheduleButton);


		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		automationController.setAlignmentX(Component.LEFT_ALIGNMENT);
		groupPanel.setAlignmentX(LEFT_ALIGNMENT);
		setTimePanel.setAlignmentX(LEFT_ALIGNMENT);
		panelbutton.setAlignmentX(LEFT_ALIGNMENT);
		scheduleShowView.setAlignmentX(LEFT_ALIGNMENT);
		simulationController.setAlignmentX(LEFT_ALIGNMENT);
		add(automationController);
		add(groupPanel);
		add(setTimePanel);
		add(panelbutton);
		add(scheduleShowView);
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
		reSetScheduleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				sensorSchedule.clearTimeRange();
			}
		});
	}
	public JComboBox groupComboBox()
	{
		String[] group = {" ","NORTH","SOUTH","EAST","WEST"};
		groupCombo = new JComboBox(group);

		groupCombo.setForeground(Color.BLUE);
		groupCombo.setFont(new Font("Arial", Font.BOLD, 15));
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


