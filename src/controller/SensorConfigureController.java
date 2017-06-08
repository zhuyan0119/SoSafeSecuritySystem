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
		
		groupLabel = new JLabel("Sensor Group ");
		startTimeLabel = new JLabel("Start Time ");
		endTimeLabel = new JLabel("End Time ");
		JComboBox cbx = groupComboBox();
		JButton scheduleButton = new JButton("Schedule ");
		sTTextField = new JTextField(10);
		eTTextField = new JTextField(10);
		
		
		/*
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(0,0,0,0);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.WEST;
		this.add(automationController,c);
		
		c.gridx=0;
	    c.gridy=2;
	    this.add(groupLabel, c);
	    c.gridx=1;
	    c.gridy=2;
	    this.add(cbx, c);
	    */
	    
		
		
		
		
		
		
		
		
		
		
/* set the  layout of SensorConfigureView, which include,1) automationController, 2) scheduleView(scheduleController and schedule table view)
	3) simulationcontriller	*/	

		// automationController
		//automationController.setLayout(new FlowLayout(FlowLayout.LEFT));
		// scheduleView panel
		JPanel schedulePanel = new JPanel();
		
		//GridLayout schedulePaneLayout = new GridLayout(5,1);
		//schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
		
		
		
		/*
		automationController.setPreferredSize(new Dimension(10,10));
		schedulePanel.add(automationController);
		
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
		
		schedulePanel.add(setTimePanel);
		schedulePanel.add(panelbutton);
		schedulePanel.add(scheduleShowView);
		simulationController.setPreferredSize(new Dimension(10,10));
		// set sensorConfigure Layout
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(schedulePanel);
		add(simulationController);
		
		*/

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
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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


