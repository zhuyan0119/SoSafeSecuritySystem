package controller;

import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import model.*;

public class Scheduler implements Runnable {
	private SensorSchedule sensorSchedule;
    private SensorBank sensorBank;
    private SensorGroup sg;
 

     public Scheduler(SensorGroup sg,SensorSchedule sensorSchedule,SensorBank sensorBank){
    	 this.sensorBank = sensorBank;
         this.sensorSchedule = sensorSchedule;
    	 this.sg = sg;
     }
     
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(LocalDateTime.now());
			if(sensorBank.getAutomation()){
               Sensor[]  sensorArray = sensorBank.getGroup(sg);
                System.out.println("automation is:" + sensorBank.getAutomation());
                if(isInSchedule()){
                    System.out.println("in schedule");
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
        ArrayList<TimeRange> schedule = sensorSchedule.getGroup(sg);
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
        LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int min = now.getMinute();
		return new SensorTime(hour,min);
	}

}
