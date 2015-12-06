package curves;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream.GetField;
import java.util.Observable;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ZoomWidget extends Observable {

	private JPanel widget;
	private JPanel xLine;
	private JPanel yLine;
	private JTextField xMin;
	private JTextField xMax;
	private JTextField yMin;
	private JTextField yMax;
	private JLabel xMinLabel;
	private JLabel xMaxLabel;
	private JLabel yMinLabel;
	private JLabel yMaxLabel;
	private JSlider xSlider;
	
	public CaretListener cl;

	public ZoomWidget() {
		widget = new JPanel();
		xLine = new JPanel();
		yLine = new JPanel();

		widget.setLayout(new BoxLayout(widget, BoxLayout.Y_AXIS));

		xMin = new JTextField(3);
		yMin = new JTextField(3);
		xMax = new JTextField(3);
		yMax = new JTextField(3);
		xMinLabel = new JLabel("X min");
		xMaxLabel = new JLabel("X max");
		yMinLabel = new JLabel("y min");
		yMaxLabel = new JLabel("y max");
		xSlider = new JSlider();
		//JSlider xRange = new JRangeSlider();
		
		xLine.add(xMinLabel);
		xLine.add(xMin);
		xLine.add(xMaxLabel);
		xLine.add(xMax);
		yLine.add(yMinLabel);
		yLine.add(yMin);
		yLine.add(yMaxLabel);
		yLine.add(yMax);
		
		widget.add(xLine);
		widget.add(yLine);
		//widget.add(widget, xRange.getComponents());
		
		
		xMin.getDocument().addDocumentListener(new DocumentListener() {
		    private String updateData() {
		        // mise à jour de l'attribut data
		    	System.out.println("zo");
		        return xMin.getText();
		    }

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		 
		 
		});
		
	xMin.addCaretListener(cl);

	
	
	}
			
		

	public JPanel getWidget() {
		return widget;
	}
}