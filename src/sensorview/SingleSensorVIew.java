package sensorview;

import javax.swing.*;

import model.Sensor;
import model.SensorGroup;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class SingleSensorVIew extends JLabel implements Observer, MouseListener {
	protected static final int LABEL_WIDTH = 65;
	protected static final int LABEL_HEIGHT = 65;
	
	// import sensor imagine 
	
	private ImageIcon sensorOff;
	private ImageIcon sensorOn;
	private ImageIcon sensorAlert;		
	private int sensorId;
	private SensorGroup sensorGroup;
	private Sensor sensor;
	
	
	public SingleSensorVIew(Sensor sensor, SensorGroup group, int locationX, int locationY){
		super();
		String filename[]= sensor.getIcon();
		this.sensorGroup = group;
		this.sensorId = sensor.getSensorID();
		this.sensor = sensor;
		
		// the sensor.getIcon() return the filename in order of senserOff, sensorOn and sensorAlert
		sensorOff = getResizeImageIcon(filename[0], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorOn = getResizeImageIcon(filename[1], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorAlert = getResizeImageIcon(filename[2], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		
		// set the properties of this SingleSenorView
		setImageIcon(sensor);
		this.setSize(LABEL_HEIGHT, LABEL_WIDTH);
		this.setLocation(locationX, locationY);
		
		sensor.addObserver(this);
		addMouseListener(this);
	}
	

	public void setImageIcon(Sensor sensor){
		
		int status = sensor.getstatus();
		
		if(status==1){
			this.setIcon(sensorOn);
			
		}
		if(status==-1){
			this.setIcon(sensorAlert);
			
		}
			
		if(status==0){
			this.setIcon(sensorOff );
		}
	}
	
	public int getSensorId(){
		return sensorId;
	}
		
		
	public SensorGroup getsensorGroup() {
		return sensorGroup;
	}
	
	public Sensor getSensor(){
		return sensor;
	}
		
	protected ImageIcon getResizeImageIcon(String imagePath, int width, int length) {
		ImageIcon oriImageIcon = new ImageIcon(imagePath);
		Image oriImage = oriImageIcon.getImage();
		Image resizedImage = oriImage.getScaledInstance(length, width, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		return resizedImageIcon;
	}


	@Override
	public void update(Observable o, Object arg) {
		setImageIcon(sensor);
		updateUI();
	}


	public void mouseClicked(MouseEvent e) {
		if(!sensor.getAutomation()){
			if(sensor.getstatus()==0)
				sensor.setSensorOn();
			else 
				if(sensor.getstatus()==1)
					sensor.setSensorOff();
		}	
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
