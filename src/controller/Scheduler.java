package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import model.*;

public class Scheduler implements Runnable {
	private SensorSchedule sensorschedule;
    private ArrayList<TimeRange> schedule ;
    private Sensor[] sensorArray;
    private LocalDateTime now ;
    private SensorBank sensorBank;
    private Boolean automation;
    private SensorGroup sg;
    private Thread scheduler;
 

     public Scheduler(SensorGroup sg,SensorSchedule sensorSchedule,SensorBank sensorbank){
    	 this.sensorBank = sensorbank;
    	 this.sg =sg;
    	 schedule= sensorSchedule.getGroup(sg);
    	 automation=sensorBank.getAutomation();
    	 sensorArray=sensorBank.getGroup(sg);
    	 //this.scheduler = new Thread(this);
    	 //this.scheduler.start();

     }
     
	public void run() {
		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			now = LocalDateTime.now();
			//System.out.println(LocalDateTime.now());
			if(automation){
				if(isInSchedule()){
					// turn on all sensors installed in this section
					for(int i=0;i<sensorArray.length;i++){
						if (sensorBank.checkInstalledOrNot(sg,i)){
							if(sensorArray[i].getstatus()==0)
							sensorArray[i].setSensorOn();
						}
					}
				}
				else{
					System.out.println("not in schedule");
					// is not inSchedule turn off all installed sensor in this section
					for(int j=0;j<sensorArray.length;j++){
						if (sensorBank.checkInstalledOrNot(sg,j)){
							if(sensorArray[j].getstatus()==1)
							sensorArray[j].setSensorOff();
						}
					}
				}
			}
		}
	}
	
	
	public Boolean isInSchedule(){
		SensorTime now = getNow();
		SensorTime start, end;
		TimeRange temp;
		for(int i=0;i<schedule.size();i++){
			temp=schedule.get(i);
			start = temp.startTime;
			end = temp.endTime;
			if(now.compareTo(start)>=0&&now.compareTo(end)<0){
				return true;
			}
			else
				continue;
		}
		return false;
	}
	
	public SensorTime getNow(){
		int hour = now.getHour();
		int min = now.getMinute();
		return new SensorTime(hour,min);
	}

}
