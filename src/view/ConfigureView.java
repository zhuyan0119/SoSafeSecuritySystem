package view;

import javax.swing.*;
import java.awt.GridLayout;
import controller.*;
import controller.SensorInstallController;
import model.SensorBank;
import model.SensorSchedule;
import sensorview.*;


public class ConfigureView extends JPanel 
{
	//private SensorBank sensorBank;
	//private SensorSchedule sensorSchedule;
	private SensorConfigureView sensorConfigureView;
	private SensorConfigureController configureController;
	
	// constructor
	public ConfigureView(SensorBank sensorBank,SensorSchedule sensorSchedule)
	{
		
		sensorConfigureView = new SensorConfigureView(sensorBank);
		configureController = new SensorConfigureController(sensorBank,sensorSchedule);
		add(sensorConfigureView);
		add(configureController);
		setLayout(new GridLayout(1,2));
		

	}

}



