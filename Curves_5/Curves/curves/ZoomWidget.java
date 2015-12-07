package curves;

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

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
	private JButton applyButton;

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

		xMin = new JTextField("xMin");
		yMin = new JTextField("yMin");
		xMax = new JTextField("xMax");
		yMax = new JTextField("yMax");

		//minLabel = new JLabel("min");
		//maxLabel = new JLabel("max");
		yLabel = new JLabel("y");
		xLabel = new JLabel("x");
		
		applyButton = new JButton("Apply");

		//widget.add(minLabel);
		//widget.add(maxLabel);
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
