package curves;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream.GetField;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ZoomWidget extends Observable {

	private JPanel widget;
	private JPanel xLine;
	private JPanel yLine;
	
	private JTextField xMin;
	private JTextField xMax;
	private JTextField yMin;
	private JTextField yMax;
	
	private JLabel xLabel;
	private JLabel yLabel;
	
	private JButton applyButton;
	

	public ZoomWidget() {
		widget = new JPanel();
		widget.setLayout(new GridLayout(3,3));

		xMin = new JTextField("xMin");
		yMin = new JTextField("yMin");
		xMax = new JTextField("xMax");
		yMax = new JTextField("yMax");

		yLabel = new JLabel("y");
		xLabel = new JLabel("x");
		
		applyButton = new JButton("Apply");

		widget.add(xLabel);
		widget.add(xMin);
		widget.add(xMax);
		widget.add(yLabel);
		widget.add(yMin);
		widget.add(yMax);
		widget.add(applyButton);		
	}


	public JPanel getWidget() {
		return widget;
	}
}
