package sensorview;

import javax.swing.*;

import model.SensorGroup;

import java.awt.Image;

public class SingleSensorVIew extends JLabel {
	protected static final int LABEL_WIDTH = 65;
	protected static final int LABEL_HEIGHT = 65;
	
	// import sensor imagine 
	
	private ImageIcon sensorOff;
	private ImageIcon sensorOn;
	private ImageIcon sensorAlert;	
	
	/*
	
	*/
	
		
	private String sensorId;
	private SensorGroup sensorGroup;
		
	public SingleSensorVIew (String sensorId, String text, SensorGroup group, int locationX, int locationY, String[] filename){
		super();
		// import Icons and set size
		sensorOff = getResizeImageIcon(filename[0], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorOn = getResizeImageIcon(filename[1], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorAlert = getResizeImageIcon(filename[2], LABEL_HEIGHT-25, LABEL_WIDTH-25);
		
		//setting of the icon
		//this.setText(text);
		this.setIcon(sensorOff);
		this.setSize(LABEL_HEIGHT, LABEL_WIDTH);
		this.setLocation(locationX, locationY);
			
		this.sensorId = sensorId;
		this.sensorGroup = group;
	}
	
	public void setImageIcon(String filename1,String filename2,String filename3){
		sensorOff = getResizeImageIcon(filename1, LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorOn = getResizeImageIcon(filename2, LABEL_HEIGHT-25, LABEL_WIDTH-25);
		sensorAlert = getResizeImageIcon(filename3, LABEL_HEIGHT-25, LABEL_WIDTH-25);
	}
	
	public String getSensorId(){
		return sensorId;
	}
		
	public void onSensorOff(){
		setIcon(sensorOff);
	}
		
	public void onSensorOn(){
		setIcon(sensorOn);
	}
	
	public void onSensorAlert(){
		setIcon(sensorAlert);
	}
		
	public SensorGroup getsensorGroup() {
		return sensorGroup;
	}
		
	protected ImageIcon getResizeImageIcon(String imagePath, int width, int length) {
		ImageIcon oriImageIcon = new ImageIcon(imagePath);
		Image oriImage = oriImageIcon.getImage();
		Image resizedImage = oriImage.getScaledInstance(length, width, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		return resizedImageIcon;
	}


}
