package sensorview;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import model.*;

public class SensorConfigureView extends JPanel implements Observer {

	// use 4 panels to represent the layout of building 
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
	
	protected HashMap<SensorGroup,SingleSensorVIew[]> sensorView = new HashMap<SensorGroup,SingleSensorVIew[]>();
	
	public SensorConfigureView(SensorBank observeSensorBank)
	{
		sensorBank = observeSensorBank;
		setBorder(new TitledBorder("Building Map"));
		setLayout(new GridLayout(2,2));
		showBuildingMap();
		
		// addObserver to each installed sensor and the SensorBank
		for (int j = 0; j < SensorGroup.values().length; j++)
		{
			SensorGroup sg = SensorGroup.values()[j];
			Sensor[] sensorArray= sensorBank.getGroup(sg);
			for(int i = 0; i < sensorArray.length; i++)
			{

				if (sensorBank.checkInstalledOrNot(sg,i))
				{
					sensorArray[i].addObserver(this);
				} 
			}
		}
		observeSensorBank.addObserver(this);
		
		
	}
	public void showBuildingMap()
	{
		
		north.setBorder(new TitledBorder("North"));
		south.setBorder(new TitledBorder("South"));
		east.setBorder(new TitledBorder("East"));
		west.setBorder(new TitledBorder("West"));
		add(north);
		add(south);
		add(east);
		add(west);
	}

	public void update(Observable o, Object arg)
	{
		if (o instanceof SensorBank )
		{
			for (int j = 0; j < SensorGroup.values().length; j++)
			{
				SensorGroup sg = SensorGroup.values()[j];
				Sensor[] sensorArray= sensorBank.getGroup(sg);
				for(int i = 0; i < sensorArray.length; i++)
				{

					if (sensorBank.checkInstalledOrNot(sg,i))
					{
						sensorArray[i].deleteObserver(this);
						sensorArray[i].addObserver(this);
					} 
				}
			}
		}
		drawSensor(sensorBank);
		updateUI();
	}
	public void drawSensor(SensorBank sensorbank)
	{
	
		/* define a temp Sensor[] to store sensor intallation information of N,or E or S or W, each direction has 3 location to install sensors 
		 and only one sensor, either firesensor or intrudersensor installed at on location */
		Sensor[] locationSensor = new Sensor[3];
				
		// draw all installed sensor
		for(int i=0;i<sg.length;i++)
		{
	    	locationSensor = sensorBank.getGroup(sg[i]);
			SingleSensorVIew[] sensorViewArray= new SingleSensorVIew[3];
			for(int j=0;j<SENSORMAXNUMBER;j++)
			{
				if(sensorbank.checkInstalledOrNot(sg[i], j))
				{
					int xy[] = getSensorXY(j);
					//String filename[]= locationSensor[j].getIcon();
					SingleSensorVIew sv = new SingleSensorVIew(locationSensor[j],sg[i],xy[0],xy[1]);
					
					sensorViewArray[j]= sv;
					section[i].setLayout(null);
					section[i].add(sv);
					
				}
			}
			sensorView.put(sg[i], sensorViewArray);
			
		}
	}
	
	public void addMouseListener(MouseListener listener) {
		SingleSensorVIew[] sensorViewArray=sensorView.get(SensorGroup.NORTH);
		for(int i=0;i<sensorViewArray.length;i++){
			sensorViewArray[i].addMouseListener(listener);
		}
	}
	
	
	public int[] getSensorXY(int i)
	{
		int[] xy = {0,0};
		if(i==0)
		{
			xy[0]=40;
			xy[1]=40;
			return xy;
		}
			
		else if(i==1)
		{
			xy[0]=160;
			xy[1]=40;
			return xy;
		}
		else if(i==2)
		{
			xy[0]=100;
			xy[1]=150;
			return xy;
		}
		return xy;		
	}
	
	
}