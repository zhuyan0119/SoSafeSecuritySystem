package frame;
import java.util.HashMap;

import javax.swing.*;

import view.*;

public class PanelTab extends JTabbedPane {
	// PanelTab contains three views for Instrallation, Configureation and Bill
	
	private InstallationView installationView ;
	private ConfigureView configureView;
	private BillView billView;
	
	// PanelTab constructor to initialize three views with  data membranes of sensormap, schedule and bill 
	
	public PanelTab() {
		installationView = new InstallationView();
		configureView = new ConfigureView();
		billView = new BillView();
		
		addTab("Installation", installationView);
		addTab("Configure", configureView);
		addTab("Bill", billView);
		
		//Thread waterShowing = new Thread(waterUseView);
		//waterShowing.start();
	}
	
	/*
	public SprinklerSetView getSpkSetView() {
		return sprinklerView.getSettingView();
	}
	
	public SprinklerMapView getSpkMapView() {
		return sprinklerView.getMapView();
	}
	
	public WeeklyPlanViewer getWeeklyPlanView() {
		return weeklyPlanView;
	}
	*/
}
