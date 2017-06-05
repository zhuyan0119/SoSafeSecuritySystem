package controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import model.*;

public class Scheduler implements Runnable {
	private SensorSchedule sensorschedule;
    private ArrayList<TimeRange> schedule ;
    private LocalDateTime now;
    private SensorBank sensorBank;
    private Boolean automation;
	
	/* 
	LocalTime[] nTime = new LocalTime[2];
     LocalTime[] eTime = new LocalTime[2];
     LocalTime[] wTime = new LocalTime[2];
     LocalTime[] sTime = new LocalTime[2];*/

     public Scheduler(SensorGroup sg,SensorSchedule sensorSchedule,SensorBank sensorbank){
    	 schedule= sensorSchedule.getGroup(sg);
    	 automation = sensorBank.getAutomation(sg);
     }
	public void run(LocalTime[] schedule) {
		while(ture){
			if( automation){
				if(isInSchedule()){
					//turn on sensors in section
				}
				else
					// turn off sensors in section
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
			if(now.compareTo(start)>0&&now.compareTo(end)<0)
				return true;
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
