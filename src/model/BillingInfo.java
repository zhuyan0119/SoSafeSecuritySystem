package model;
import java.util.*;

public class BillingInfo 
{
    private CustomerInfo customerInfo = new CustomerInfo("CustomerInfo.txt");
    private UsageInfo usageInfo = new UsageInfo();
    
    public void addUsageInfoToObservable(Observable ob) {
        ob.addObserver(usageInfo);
    }

    public void incrementNumIntruderAlarmCalls() {
        usageInfo.incrementNumIntruderAlarmCalls();
    }

    public void incrementNumFireAlarmCalls() {
        usageInfo.incrementNumFireAlarmCalls();
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("Customer Information:\n");
        bill.append(customerInfo.toString());
        bill.append(usageInfo.generateBill());
        return bill.toString();
    }

    public static void main(String[] args) {
        BillingInfo bi = new BillingInfo();
        System.out.println(bi.generateBill());
    }
}
