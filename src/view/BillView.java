package view;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import model.*;


public class BillView extends JPanel implements Observer {
    private JTextArea ta;
	//constructor
	public BillView(BillingInfo bi){
        setLayout(new BorderLayout());
        ta = new JTextArea();
        ta.setEditable(false);
        ta.append(bi.generateBill());
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
		
	}

    public void update(Observable observable, Object input) {
        BillingInfo billingInfo = (BillingInfo) observable;
        ta.setText("");
        ta.append(billingInfo.generateBill());
        updateUI();
    }
}
