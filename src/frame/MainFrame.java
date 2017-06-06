package frame;
import model.*;

import java.time.LocalDateTime;

import javax.swing.*;

import controller.*;
public class MainFrame extends JFrame {
	// contains data model
	private SensorBank sensorBank;
	
	// contains controller
	//Instrallation installation;
	PasswordController passwordController;
	
	//contains frame and TabbedPanel
	//JFrame frame ;
	PanelTab panelTab;
	
	//constructor to initiate frame and panelTab
	public MainFrame(SensorBank sensorBank){
		super ("So Safe System");
		panelTab = new PanelTab(sensorBank);
		
		add(panelTab);
		setSize(900,500);
		
	}

	public static void main(String[] args) {
		//LocalDateTime now=new LocalDateTime();
		
		SensorBank sensorbank = new SensorBank();
		SensorSchedule schedule = new SensorSchedule();
		Scheduler north = new Scheduler(SensorGroup.NORTH,schedule,sensorbank);
		MainFrame frame = new MainFrame(sensorbank);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
