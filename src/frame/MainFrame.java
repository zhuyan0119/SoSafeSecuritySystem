package frame;
import model.*;

import java.time.LocalDateTime;

import javax.swing.*;

import controller.*;
public class MainFrame extends JFrame {
	// contains data model
	private SensorBank sensorBank;
	private SensorSchedule sensorSchedule;
	
	// contains controller
	//Instrallation installation;
	PasswordController passwordController;
	
	//contains frame and TabbedPanel
	//JFrame frame ;
	PanelTab panelTab;
	
	//constructor to initiate frame and panelTab
	public MainFrame(SensorBank sensorBank, SensorSchedule sensorSchedule, BillingInfo billingInfo){
		super ("So Safe System");
		this.sensorBank = sensorBank;
		this.sensorSchedule=sensorSchedule;
		panelTab = new PanelTab(sensorBank, sensorSchedule, billingInfo);
		
		add(panelTab);
		setSize(1000,600);
		
	}
	
	public void go(){
		Scheduler north = new Scheduler(SensorGroup.NORTH,sensorSchedule,sensorBank);
		new Thread(north).start();
		Scheduler east = new Scheduler(SensorGroup.EAST,sensorSchedule,sensorBank);
		new Thread(east).start();
		Scheduler west = new Scheduler(SensorGroup.WEST,sensorSchedule,sensorBank);
		new Thread(west).start();
		Scheduler south = new Scheduler(SensorGroup.SOUTH,sensorSchedule,sensorBank);
		new Thread(south).start();
	}

	public static void main(String[] args) {
		SensorBank sensorbank = new SensorBank();
		SensorSchedule schedule = new SensorSchedule();
        BillingInfo billingInfo = new BillingInfo();
        sensorbank.addObserver(billingInfo);

		MainFrame frame = new MainFrame(sensorbank,schedule, billingInfo);
		frame.go();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
