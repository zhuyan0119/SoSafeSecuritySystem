package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Dimension;

import model.*;

public class ScheduleShowView extends JPanel 
{
	private SensorSchedule sensorSchedule;

	private JTable table;
	private JScrollPane scrollPane;

	private Object[][] data = new Object[4][5];


	public ScheduleShowView(SensorSchedule ss)
	{
		sensorSchedule = ss;
		String[] columnName = {"Group", "Scheduled Time"," "," "," "};
		fillData();
		table = new JTable(data, columnName);
		scrollPane = new JScrollPane(table);

		Dimension dim = new Dimension(300,200);
		table.setPreferredScrollableViewportSize(dim);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);

		add(table);
	}
	public void fillData()
	{
		for (int j = 0; j < SensorGroup.values().length; j++)
		{
			SensorGroup sg = SensorGroup.values()[j];
			ArrayList<TimeRange> timeArray= sensorSchedule.getGroup(sg);
			for(int i = 1; (i < 5) && (i - 1 < timeArray.size()); i++)
			{
				data[sg.ordinal()][i] = timeArray.get(i - 1).toString();
			}
			data[sg.ordinal()][0] = sg;
		}
		
	}

	public static void main(String args[])	
	{
		SensorSchedule ss = new SensorSchedule();
		ScheduleShowView  ssv = new ScheduleShowView(ss);
		
		
		
		JFrame f = new JFrame();
		f.getContentPane().add(ssv);
		//f.setLayout(new FlowLayout());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	


}