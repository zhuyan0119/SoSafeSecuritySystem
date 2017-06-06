package model;
import java.io.*;

class CustomerInfo {
    private int serviceContractId;
    private String name;
    private String address;
    private String[] contactNumbers;
    private String emailAddress;
    private String startDate;
    private String endDate;

    public CustomerInfo(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);

            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            
            serviceContractId = Integer.parseInt(br.readLine().split(":")[1]);
            name = br.readLine().split(":")[1];
            address = br.readLine().split(":")[1];
            contactNumbers = new String[2];
            contactNumbers[0] = br.readLine().split(":")[1];
            contactNumbers[1] = br.readLine().split(":")[1];
            emailAddress = br.readLine().split(":")[1];
            startDate = br.readLine().split(":")[1];
            endDate = br.readLine().split(":")[1];
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("- Service Contract ID: " + new Integer(serviceContractId).toString() + "\n");
        result.append("- Customer Name: " + name + "\n");
        result.append("- Property Address: " + address + "\n");
        result.append("- Contact Number 1: " + contactNumbers[0] + "\n");
        result.append("- Contact Number 2: " + contactNumbers[1] + "\n");
        result.append("- Customer Email: " + emailAddress + "\n");
        result.append("- Coverage Start Date: " + startDate + "\n");
        result.append("- Coverage End Date: " + endDate + "\n");
        return result.toString();
    }
}
