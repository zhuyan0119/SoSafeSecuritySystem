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
	// constructor
	public ConfigureView(SensorBank sensorBank,SensorSchedule sensorSchedule,BillingInfo bill)
	{
		
		SensorConfigureView sensorConfigureView = new SensorConfigureView(sensorBank);
		SensorConfigureController configureController = new SensorConfigureController(sensorBank, sensorSchedule,bill);
		LoginController loginController = new LoginController(sensorBank.getPassWordData(), configureController);
		//scheduleShowView = new ScheduleShowView(sensorSchedule);

		JPanel configure = new JPanel();
		configure.add(loginController);
		configure.add(configureController);
		setLayout(new GridLayout(1,2));
		add(sensorConfigureView);
		add(configure);
		//add(scheduleShowView);
		
	}
	


}



