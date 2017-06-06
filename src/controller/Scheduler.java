package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.*;

public class Scheduler implements Runnable {
	private SensorSchedule sensorschedule;
    private ArrayList<TimeRange> schedule ;
    private Sensor[] sensorArray;
    private LocalDateTime now = LocalDateTime.now();
    private SensorBank sensorBank;
    private Boolean automation;
    private SensorGroup sg;
    private Thread scheduler;
 

     public Scheduler(SensorGroup sg,SensorSchedule sensorSchedule,SensorBank sensorbank){
    	 this.sensorBank = sensorbank;
    	 schedule= sensorSchedule.getGroup(sg);
    	 automation=sensorBank.getAutomation();
    	 sensorArray=sensorBank.getGroup(sg);
    	 this.scheduler = new Thread(this);
    	 this.scheduler.start();
     }
     
	public void run() {
		while(true){
			System.out.println("in loop");
			if(automation){
				if(isInSchedule()){
					// turn on all sensors installed in this section
					System.out.println("in schedule");
					for(int i=0;i<sensorArray.length;i++){
						if (sensorBank.checkInstalledOrNot(sg,i))
							sensorArray[i].setSensorOn();
					}
				}
				else{
					// is not inSchedule turn off all installed sensor in this section
					for(int j=0;j<sensorArray.length;j++){
						System.out.println(j);
						if (sensorBank.checkInstalledOrNot(sg,j))
							sensorArray[j].setSensorOff();
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
			if(now.compareTo(start)>=0&&now.compareTo(end)<=0){
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
