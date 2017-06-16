package model;
import java.util.*;

// BilingInfo observe UsageInfor.java, and observed by BillView
public class BillingInfo extends Observable implements Observer 
{
    private CustomerInfo customerInfo = new CustomerInfo("CustomerInfo.txt");
    private UsageInfo usageInfo = new UsageInfo();
    
    // intruderAlarmCall increases
    public void incrementNumIntruderAlarmCalls() {
        usageInfo.incrementNumIntruderAlarmCalls();
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
    }

    // fireAlarmCall increases
    public void incrementNumFireAlarmCalls() {
        usageInfo.incrementNumFireAlarmCalls();
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
    }

    // generate and return bill in as String.
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
