package view;

import javax.swing.*;
import java.awt.GridLayout;
import controller.*;
import controller.SensorInstallController;
import model.SensorBank;
import sensorview.*;


public class ConfigureView extends JPanel 
{
	private SensorBank sensorBank;
	private SensorConfigureView sensorConfigureView;
	//private SensorInstallController installation;
	
	// constructor
	public ConfigureView(SensorBank sensorBank)
	{
		sensorConfigureView = new SensorConfigureView(sensorBank);
		//installation = new SensorInstallController(sensorBank);
		add(sensorConfigureView);
		//add(installation);
		setLayout(new GridLayout(1,2));

	}

}



