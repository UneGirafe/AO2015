package curves;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Observable;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ZoomWidget extends Observable {

	private JPanel widget;
	private JTextField xMin;
	private JTextField xMax;
	private JTextField yMin;
	private JTextField yMax;
	private JLabel minLabel;
	private JLabel maxLabel;
	private JLabel xLabel;
	private JLabel yLabel;

	public enum Position { LEFT ("1"), CENTER("2") , RIGHT("3") ;
		private String pos;
		
		private Position(String x){
			this.pos = x;
		}
		
		public String toString(){
			return pos;
		}
	}
	
	public ZoomWidget() {
		widget = new JPanel();
		widget.setLayout(new GridLayout(3,3));
		
		
		xMin = new JTextField();
		yMin = new JTextField();
		xMax = new JTextField();
		yMax = new JTextField();

		minLabel = new JLabel("min");
		maxLabel = new JLabel("max");
		yLabel = new JLabel("y");
		xLabel = new JLabel("x");
		
		widget.add(minLabel,Position.CENTER);
		widget.add(maxLabel,Position.RIGHT);
		widget.add(xLabel,Position.LEFT);
		widget.add(xMin, Position.CENTER);
		widget.add(xMax, Position.RIGHT);
		
	}
	

	
	public JPanel getWidget() {
		return widget;
	}
}
