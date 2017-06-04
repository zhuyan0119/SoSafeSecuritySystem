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
	private JPanel[] section={north,south,east,west};
	private SensorGroup sensorGroup;
	private SensorGroup[] sg = sensorGroup.values();
	private SensorBank sensorBank;
	private static int SENSORMAXNUMBER = 3;
	protected HashMap<SensorGroup,SingleSensorVIew[]> sensorView;
	
	public SensorMapView(SensorBank observeSensorBank){
		setBorder(new TitledBorder("Building Map"));
		setLayout(new GridLayout(2,2));
		showBuildingMap();
		sensorBank = observeSensorBank;
		//observeSensorBank.addObserver(this);
		south.setLayout(null);
		//SingleIntrusionSensorView intrusionSensor= new SingleIntrusionSensorView("North1","motion","North",50,10);
		//south.add(intrusionSensor);
		//drawSensor(observeSensorBank);
		drawSensor(observeSensorBank);
		
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
		//extract sensorBank from Obersevable sensorBank
		sensorBank = (SensorBank)o;
		drawSensor(sensorBank);
		
		
	}
	
	public void drawSensor(SensorBank sensorbank){
		// define a temp Sensor[] to store sensor intallation information of N,or E or S or W, each direction has 3 location to install sensors install
		// and only one sensor, either firesensor or intrudersensor installed at on location 
		Sensor[] locationSensor = new Sensor[3];
				
		// draw all installed sensor
		for(int i=0;i<sg.length;i++){
	    	locationSensor = sensorBank.getGroup(sg[i]);
			
			for(int j=0;j<3;j++){
				if(sensorbank.checkInstalledOrNot(sg[i], j)){
					int id = locationSensor[j].getSensorID();
					int xy[] = getSensorXY(j);
					String filename[]= locationSensor[j].getIcon();
					SingleSensorVIew sv = new SingleSensorVIew(Integer.toString(id),"sensor",sg[i],xy[0],xy[1],filename);
					section[i].setLayout(null);
					section[i].add(sv);
				}
			}
			
		}
	}
		
	public int[] getSensorXY(int i){
		int[] xy = {0,0};
		if(i==0){
			xy[0]=30;
			xy[1]=30;
			return xy;
		}
			
		else if(i==1){
			xy[0]=150;
			xy[1]=50;
			return xy;
		}
		else if(i==2){
			xy[0]=90;
			xy[1]=130;
			return xy;
		}
		return xy;		
	}
		
}


