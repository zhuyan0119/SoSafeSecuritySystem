package controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Scheduler implements Runnable,Comparable<> {
	private Sensorschedule sensorschedule;
    private Sensor sensor;
    private LocalTime[];
	
	/* 
	LocalTime[] nTime = new LocalTime[2];
     LocalTime[] eTime = new LocalTime[2];
     LocalTime[] wTime = new LocalTime[2];
     LocalTime[] sTime = new LocalTime[2];*/

     public Sheduler(Sensor s,Localtime[]l){
    	 sensor = s;
    	 
     }
	public void run(LocalTime[] schedule) {
		Thread.sleep(1000);
		if(isInSchedule()){
			
		}
		
		
	}
	
	public Boolean isInSchedule(LocalTime[] schedule){
		LocalTime now = LocalTime.now();
		if(now.compareTo(schedule[0])>0&&now.compareTo(schedule[1])<0)
			return true;
		else
			return false;
		
	}

}
