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


	//private LoginController loginController;
	//private SensorConfigureView sensorConfigureView;
	//private SensorConfigureController configureController;

	
	
	// constructor
	public ConfigureView(SensorBank sensorBank,SensorSchedule sensorSchedule)
	{
		
		SensorConfigureView sensorConfigureView = new SensorConfigureView(sensorBank);
		SensorConfigureController configureController = new SensorConfigureController(sensorBank,sensorSchedule);
		LoginController loginController = new LoginController(sensorBank.getPassWordData(),configureController);
		add(sensorConfigureView);
		add(loginController);
		setLayout(new GridLayout(1,2));
		

	}
	


}



