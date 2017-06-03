package view;

import javax.swing.*;

import sensorview.*;

public class InstallationView extends JPanel {

	private SingleIntrusionSensorView intrusionSensor= new SingleIntrusionSensorView("North1","motion","North",30,50);
	private SingleFireSensorView fireSensor = new SingleFireSensorView("North1","fire","North",50,70);
   // constructor
	public InstallationView(){
		add(intrusionSensor);
		add(fireSensor);
	}
}
