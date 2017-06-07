package view;

import javax.swing.*;
import java.awt.GridLayout;
import controller.*;
import controller.SensorInstallController;
import model.BillingInfo;
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
	//private ScheduleShowView scheduleShowView;

	
	
	// constructor
	public ConfigureView(SensorBank sensorBank,SensorSchedule sensorSchedule,BillingInfo bill)
	{
		
		SensorConfigureView sensorConfigureView = new SensorConfigureView(sensorBank);
		SensorConfigureController configureController = new SensorConfigureController(sensorBank,sensorSchedule,bill);
		LoginController loginController = new LoginController(sensorBank.getPassWordData(),configureController);
		//scheduleShowView = new ScheduleShowView(sensorSchedule);

		add(sensorConfigureView);
		add(loginController);
		setLayout(new GridLayout(1,2));
		add(configureController);
		//add(scheduleShowView);
		
	}
	


}



