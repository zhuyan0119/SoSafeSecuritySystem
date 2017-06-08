package controller;

import java.io.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.BillingInfo;
import model.FireSensor;
import model.IntruderSensor;
import model.Sensor;
import model.SensorBank;
import model.SensorGroup;

public class SimulationController extends JPanel {
	private SensorBank sensorbank;
	private JComboBox groupCombo, positionCombo;
	private JButton fireButton, intruderButton, turnOffIntruderButton,turnOffFireButton;
	private JLabel groupLabel, positionLabel;
	private Timer fireTimer,intruderTimer;
	private BillingInfo bill;
	private ImageIcon fireService;	
	private ImageIcon intruderService;
    private JTextArea alarmLogTextArea;
    private boolean responseCodeEntered;
    private String responseCode;
    private boolean fireAlarmMute,intruderAlarmMute;


	public SimulationController(SensorBank sensorbank,BillingInfo bill){
		super();
		this.sensorbank = sensorbank;
		this.bill = bill;
        responseCodeEntered = false;
        setResponseCode();
        fireAlarmMute = false;
        intruderAlarmMute = false;
		groupLabel = new JLabel("Sensor Group ");
		positionLabel = new JLabel("Sensor Position ");
		JComboBox cbx1 = groupComboBox();
		JComboBox cbx2 = positionComboBox();
		
		fireButton = new JButton("fire");
		intruderButton = new JButton("intruder");
		
		
		JPanel panel1 = new JPanel();
		panel1.add(groupLabel);
		panel1.add(cbx1);
		//panel1.add(positionLabel);
		//panel1.add(cbx2);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(fireButton);
		panel2.add(intruderButton);
		
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        JButton responseCodeButton = new JButton("Enter Response Code");
        JTextField responseCodeTextField = new JTextField();
        
        responseCodeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String enteredCode = responseCodeTextField.getText();
                if (enteredCode.equals(responseCode)) {
                    responseCodeEntered = true;
                    SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
                    Sensor[] sensorArray = sensorbank.getGroup(sg);
                    for(int i=0;i<sensorArray.length;i++){
                        if(sensorbank.checkInstalledOrNot(sg,i)){
                            if(sensorArray[i].getstatus() == -1)
                            sensorArray[i].setOffSensorAlert();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(intruderButton, "Response code incorrect","service",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panel3.add(responseCodeButton);
        panel3.add(responseCodeTextField);

        alarmLogTextArea = new JTextArea();
        alarmLogTextArea.setEditable(false);
        JScrollPane alarmLogScrollPane = new JScrollPane(alarmLogTextArea);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
        panel4.add(alarmLogScrollPane);
        
        turnOffFireButton= new JButton("OFF Fire Alarm");
        turnOffIntruderButton = new JButton("OFF indruder Alarm");
        
        turnOffFireButton.addActionListener(new ActionListener()
        		{
                   public void actionPerformed(ActionEvent event){
                	   fireAlarmMute =true;
                	   SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
       				   Sensor[] sensorArray = sensorbank.getGroup(sg);
       				   for(int i=0;i<sensorArray.length;i++){
       					if(sensorbank.checkInstalledOrNot(sg,i)){
       						if(sensorArray[i]instanceof FireSensor){
       							if(sensorArray[i].getstatus()==-1){
       								sensorArray[i].setOffSensorAlert();
       							}
       						}
                         }
       			      }
                   }
        		}
        	);
        
        /*add OffintruderButton
         * 
         * 
         * 
         * 
      
         */
        turnOffIntruderButton.addActionListener(new ActionListener()
		{
           public void actionPerformed(ActionEvent event){
        	   intruderAlarmMute =true;
        	   SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				   Sensor[] sensorArray = sensorbank.getGroup(sg);
				   for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof IntruderSensor){
							if(sensorArray[i].getstatus()==-1){
								sensorArray[i].setOffSensorAlert();
							}
						}
                 }
			      }
           }
		}
	);
        
        
        
        JPanel panel5 = new JPanel();
        
        
        
       
        panel5.setLayout(new FlowLayout());
        panel5.add(turnOffFireButton);
        panel5.add(turnOffIntruderButton);
        
		
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));	
		add(panel1);
		add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
		
		fireService = new ImageIcon("fire service.jpg");

				

		
		// fireBtton turn on the fire sensor in the chosen section, and chosen location ( only if installed and status is on). 
		
		fireButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				fireAlarmMute=false;
				SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				Sensor[] sensorArray = sensorbank.getGroup(sg);
				for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof FireSensor){
							if(sensorArray[i].getstatus()==1){
								sensorArray[i].setOnSensorAlert();
								fireTimer.setRepeats(true);
								fireTimer.start();
                                break;
							}
								
					}
				}
						
			}
		}
	});


		
		// intruderBtton is to turn on the fire sensor in the chosen section, and chosen location ( only if installed and status is on).
		intruderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				intruderAlarmMute = false;
				SensorGroup sg = SensorGroup.valueOf(groupLabel.getText());
				Sensor[] sensorArray = sensorbank.getGroup(sg);
				for(int i=0;i<sensorArray.length;i++){
					if(sensorbank.checkInstalledOrNot(sg,i)){
						if(sensorArray[i]instanceof IntruderSensor){
							if(sensorArray[i].getstatus()==1)
							sensorArray[i].setOnSensorAlert();
							intruderTimer.setRepeats(true); 
							intruderTimer.start();    
                            break;
						}
					}
				}
						
			}
		});
		
		// initiate timer
		fireTimer = new Timer(1000*2, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		        if (!responseCodeEntered&&!fireAlarmMute) { 
                    alarmLogTextArea.append("fire calling\n");
                    bill.incrementNumFireAlarmCalls();
                } else {
                	if(responseCodeEntered){
                    responseCodeEntered = false;
                    fireTimer.stop();
                	}
                	if(fireAlarmMute){
                		fireTimer.stop();
                	}
                }
		      }
		    });
		
		intruderTimer = new Timer(1000*2, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		        if (!responseCodeEntered&&!intruderAlarmMute) { 
                    alarmLogTextArea.append("intruder calling\n");
                    bill.incrementNumIntruderAlarmCalls();
                } else {
                	if(responseCodeEntered){
                    responseCodeEntered = false;
                    intruderTimer.stop();
                	}
                	if(intruderAlarmMute){
                		intruderTimer.stop();
                	}
                }
		      }
		    });

	}
	
	public JComboBox groupComboBox()
	{
		String[] group = {" ","NORTH","SOUTH","EAST","WEST"};
		groupCombo = new JComboBox(group);

		groupCombo.setForeground(Color.BLUE);
		groupCombo.setFont(new Font("Arial", Font.BOLD, 10));
      	groupCombo.setEditable(true);

      	groupCombo.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent e)
      		{
      			JComboBox cb= (JComboBox)e.getSource();
      			String type = (String)cb.getSelectedItem();
      			groupLabel.setText(type);
	
      		}
      	});
      	return groupCombo;
	}
	public JComboBox positionComboBox()
	{
		String[] position = {" ","Position1","Position2","Position3"};
		positionCombo = new JComboBox(position);

		positionCombo.setForeground(Color.BLUE);
		positionCombo.setFont(new Font("Arial", Font.BOLD, 20));
      	positionCombo.setEditable(true);

      	positionCombo.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent e)
      		{
      			JComboBox cb1= (JComboBox)e.getSource();
      			String type1 = (String)cb1.getSelectedItem();
      			positionLabel.setText(type1);
      		}
      	});
      	return positionCombo;

	}
	
	public void fireAlertTimer(){
		
	}
	
	public void intruderAlertTimer(){
		
	}
    
    private void setResponseCode() {
        try {
            FileInputStream fis = new FileInputStream("ResponseCode.txt");
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            responseCode = br.readLine().trim();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
 }



