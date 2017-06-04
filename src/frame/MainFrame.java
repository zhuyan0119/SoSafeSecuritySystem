package frame;
import model.*;

import javax.swing.*;

import controller.*;
public class MainFrame extends JFrame {
	// contains data model
	private SensorBank sensorBank;
	
	// contains controller
	Instrallation installation;
	PasswordController passwordController;
	
	//contains frame and TabbedPanel
	//JFrame frame ;
	PanelTab panelTab;
	
	//constructor to initiate frame and panelTab
	public MainFrame(){
		super ("So Safe System");
		panelTab = new PanelTab();
		
		add(panelTab);
		setSize(900,500);
		
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
