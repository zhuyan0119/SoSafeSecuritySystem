package model;
import java.util.*;

class UsageInfo implements Observer
{
    private static final Integer INTRUSION_INSTALL_COST = 200;
    private static final Integer INTRUSION_SENSOR_COST = 50;
    private static final Integer INTRUSION_ALARM_COST = 20;
    private static final Integer FIRE_INSTALL_COST = 300;
    private static final Integer FIRE_SENSOR_COST = 100;
    private static final Integer FIRE_ALARM_COST = 50;


    private Integer numIntruderSensors = 0;
    private Integer numFireSensors = 0;
    private Integer numIntruderAlarmCalls = 0;
    private Integer numFireAlarmCalls = 0;

    public void update(Observable observable, Object input) {
        //TODO
    }
    
    public void incrementNumIntruderAlarmCalls() {
        numIntruderAlarmCalls += 1;
    }

    public void incrementNumFireAlarmCalls() {
        numFireAlarmCalls += 1;
    }
    
   

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        if (numIntruderSensors > 0) {
            bill.append("Intrusion Detection:\n");
            bill.append("- Initial Installion Service Charge: " + INTRUSION_INSTALL_COST.toString() + "\n");
            bill.append("- Sensor Installion Charge: " + new Integer(numIntruderSensors * INTRUSION_SENSOR_COST).toString() + " (" + numIntruderSensors.toString() + " sensors at " + INTRUSION_SENSOR_COST.toString() + " per sensor)" + "\n");
            bill.append("- Alarm Cost: " + new Integer(numIntruderAlarmCalls * INTRUSION_ALARM_COST).toString() + " (" + numIntruderAlarmCalls.toString() + " calls at " + INTRUSION_ALARM_COST.toString() + " per call)" + "\n");
        }
        if (numFireSensors > 0) {
            Integer fireInstallCost = FIRE_INSTALL_COST;
            if (numIntruderSensors > 0) {
                fireInstallCost = new Integer(new Double(FIRE_INSTALL_COST * 0.8).intValue());
            }
            bill.append("Fire Detection:\n");
            bill.append("- Initial Installion Service Charge: " + fireInstallCost.toString() + "\n");
            bill.append("- Sensor Installion Charge: " + new Integer(numFireSensors * FIRE_SENSOR_COST).toString() + " (" + numFireSensors.toString() + " sensors at " + FIRE_SENSOR_COST.toString() + " per sensor)" + "\n");
            bill.append("- Alarm Cost: " + new Integer(numFireAlarmCalls * FIRE_ALARM_COST).toString() + " (" + numFireAlarmCalls.toString() + " calls at " + FIRE_ALARM_COST.toString() + " per call)" + "\n");
        }
        return bill.toString();
    }
}
