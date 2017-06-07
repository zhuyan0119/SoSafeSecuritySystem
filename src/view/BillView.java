package view;

import javax.swing.*;
import model.*;


public class BillView extends JPanel {
	//constructor
	public BillView(BillingInfo bi){
        JTextArea ta = new JTextArea();
        ta.append(bi.generateBill());
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
		
	}

}
