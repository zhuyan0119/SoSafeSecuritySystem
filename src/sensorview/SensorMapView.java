package sensorview;

import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import model.*;


public class SensorMapView extends JPanel implements Observer {
	// use 3 panels to represent the layout of building 
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JPanel east = new JPanel();
	private JPanel west = new JPanel();
	private SensorGroup sensorGroup;
	private SensorBank sensorBank;
	
	
	public SensorMapView(SensorBank observeSensorBank){
		setBorder(new TitledBorder("Building Map"));
		setLayout(new GridLayout(2,2));
		showBuildingMap();
		sensorBank = observeSensorBank;
		//observeSensorBank.addObserver(this);
		south.setLayout(null);
		SingleIntrusionSensorView intrusionSensor= new SingleIntrusionSensorView("North1","motion","North",50,10);
		south.add(intrusionSensor);
		
	}
	
	//build the buildingMap which includes fours areas of east, south,north and west
	public void showBuildingMap(){
		
		north.setBorder(new TitledBorder("North"));
		south.setBorder(new TitledBorder("South"));
		east.setBorder(new TitledBorder("East"));
		west.setBorder(new TitledBorder("West"));
		add(north);
		add(south);
		add(east);
		add(west);	
	}
	
	public void update(Observable o, Object arg) {
		sensorBank = (SensorBank)o;
		List<Sensor> installedSensor = new ArrayList<Sensor>();
		installedSensor = sensorBank.getGroup(sensorGroup);
		installedSensor.add(new FireSensor("1"));
		for(int i=0;i<installedSensor.size();i++){
			SingleIntrusionSensorView intrusionSensor= new SingleIntrusionSensorView("North1","motion","North",10,10);
			add(intrusionSensor);
		}
	}

}
