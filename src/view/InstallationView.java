package view;

import java.awt.GridLayout;

import javax.swing.*;

import controller.Instrallation;
import model.SensorBank;
import sensorview.*;

public class InstallationView extends JPanel {

	//private SingleIntrusionSensorView intrusionSensor= new SingleIntrusionSensorView("North1","motion","North",30,50);
	//private SingleFireSensorView fireSensor = new SingleFireSensorView("North1","fire","North",50,70);
	private SensorBank sensorBank;
	private SensorMapView sensorMapView;
	private Instrallation installation = new Instrallation();
   // constructor
	public InstallationView(SensorBank sensorBank){
		//add(intrusionSensor);
		//add(fireSensor);
		sensorMapView = new SensorMapView(sensorBank);
		setLayout(new GridLayout(1,2));
		add(sensorMapView);
		add(installation);
		
	}
}
