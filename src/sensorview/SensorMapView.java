package sensorview;

import java.awt.Graphics;
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
	
	//section array was used in drawSensor()
	private JPanel[] section={north,south,east,west};
	
	// SensorGroup is the Enum class
	private SensorGroup sensorGroup;
	private SensorGroup[] sg = sensorGroup.values();
	private SensorBank sensorBank;
	private static int SENSORMAXNUMBER = 3;
	
	protected HashMap<SensorGroup,SingleSensorVIew[]> sensorView;
	
	public SensorMapView(SensorBank observeSensorBank){
		sensorBank = observeSensorBank;
		sensorView = new HashMap<SensorGroup,SingleSensorVIew[]>();
		setBorder(new TitledBorder("Building Map"));
		setLayout(new GridLayout(2,2));
		showBuildingMap();
		observeSensorBank.addObserver(this);

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
		updateUI();
	}
	
	
	public void drawSensor(SensorBank sensorbank){
		/* define a temp Sensor[] to store sensor intallation information of N,or E or S or W, each direction has 3 location to install sensors install
		 and only one sensor, either firesensor or intrudersensor installed at one location */
		System.out.println("in sensorMapView Draw function");
		Sensor[] locationSensor = new Sensor[3];
				
		// draw all installed sensor
		for(int i=0;i<sg.length;i++){
	    	locationSensor = sensorBank.getGroup(sg[i]);
			SingleSensorVIew[] sensorViewArray= new SingleSensorVIew[3];
			for(int j=0;j<SENSORMAXNUMBER;j++){
				if(sensorbank.checkInstalledOrNot(sg[i], j)){
					int xy[] = getSensorXY(j);
					SingleSensorVIew sv = new SingleSensorVIew(locationSensor[j],sg[i],xy[0],xy[1]);
					sensorViewArray[j]= sv;
					section[i].setLayout(null);
					section[i].add(sv);
				}
				//sensorView.put(sg[i],sensorViewArray);
			}	
		}
	}
		
	public int[] getSensorXY(int i){
		int[] xy = {0,0};
		// location 1
		if(i==0){
			xy[0]=30;
			xy[1]=30;
			return xy;
		}
		//location 2	
		else if(i==1){
			xy[0]=150;
			xy[1]=50;
			return xy;
		}
		//location 3
		else if(i==2){
			xy[0]=90;
			xy[1]=130;
			return xy;
		}
		return xy;		
	}
		
}


