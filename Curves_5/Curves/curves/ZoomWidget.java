package curves;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ZoomWidget extends Observable {

	private JPanel widget;
	
	private JTextField xMin;
	private JTextField xMax;
	
	private JLabel xLabel;
		
	private double newXmin;
	private double newXmax;
	

	public ZoomWidget(final FunctionVariations var, final CurveFrame f) {
		widget = new JPanel();
		widget.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(5,5,5,5);

		xMin = new JTextField("-5", 5);
		xMax = new JTextField("5", 5);

		xLabel = new JLabel("X");
		
		JButton applyButton = new JButton("Apply");
		
		applyButton.addActionListener(new ActionListener() {
 
	        public void actionPerformed(ActionEvent e)
	        {	
				try {
				    newXmin = Double.parseDouble(xMin.getText());
				    newXmax = Double.parseDouble(xMax.getText());
					
				} catch (NumberFormatException exception) {
					System.out.println("Please enter a double value");
				    exception.printStackTrace();
				    // handle the error
				}
				
	            System.out.println("Applying Zoom: X[" + xMin.getText() + ";" + xMax.getText()
					+ "] Y[" + var.getYmin() + ";" + var.getYmax() + "]");
				
				var.setXmin(newXmin);
				var.setXmax(newXmax);
				
				var.tabulate(var.getStepNumber());
				f.infos.update();
				f.repaint();
				
				
	        }
	    });
		
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		widget.add(xLabel);
		
		c.gridx = 1;
		widget.add(xMin);
		
		c.gridx = 2;
		widget.add(xMax);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		widget.add(applyButton);		
	}


	public JPanel getWidget() {
		return widget;
	}
}
