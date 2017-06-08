package model;
import java.util.*;

public class BillingInfo extends Observable implements Observer 
{
    private CustomerInfo customerInfo = new CustomerInfo("CustomerInfo.txt");
    private UsageInfo usageInfo = new UsageInfo();
    
    public void incrementNumIntruderAlarmCalls() {
        usageInfo.incrementNumIntruderAlarmCalls();
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
    }

    public void incrementNumFireAlarmCalls() {
        usageInfo.incrementNumFireAlarmCalls();
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("Customer Information:\n");
        bill.append(customerInfo.toString());
        bill.append("\n");
        bill.append(usageInfo.generateBill());
        bill.append("\n");

        return bill.toString();
    }

    public void update(Observable observable, Object input) {
        SensorBank sensorBank = (SensorBank) observable;
        usageInfo.update(sensorBank);
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
    }
}
