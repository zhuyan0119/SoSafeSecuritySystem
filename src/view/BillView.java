package view;

import javax.swing.*;
import model.*;


public class BillView extends JPanel {
	//constructor
	public BillView(BillingInfo bi){
        JScrollPane sp = new JScrollPane();
        JTextArea ta = new JTextArea();
        ta.append(bi.generateBill());
        add(sp);
        sp.add(ta);
        ta.sizeSize(sp.getPreferredSize());
		
	}

}
