package curves;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.txw2.Document;

/**
 * @author casteran
 */

class CurveControls extends JPanel {

	private static final long serialVersionUID = 1L;

	protected final static Integer nStepsChoices[] = { 1, 2, 3, 4, 5, 10, 20,
			40, 80, 160, 320, 640 };

	private JComboBox<Integer> cb;
	private ZoomWidget zoom;
	private DocumentWidget document;

	CurveControls(final FunctionVariations var, final CurveFrame f) {
		super();		
		JPanel precision = new JPanel();
		JLabel precisionL = new JLabel("Precision");
		
		cb = new JComboBox<>(nStepsChoices);
		zoom = new ZoomWidget();
		zoom.addObserver((Observer) var);
		document = new DocumentWidget();
		
		((Observable) var).addObserver(f); //permet à la fonction de notifier le tracer
		

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		precision.add(precisionL);
		precision.add(cb);

		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					var.tabulate(CurveControls.this.currentPrecision());
					f.infos.update();
					f.repaint();
				}
			}

		});

		add(precision);
		add(zoom.getWidget());
		
		
		add(document.getWidget());
		
	
		cb.setSelectedIndex(nStepsChoices.length / 2);
		
	}

	int currentPrecision() {
		return nStepsChoices[cb.getSelectedIndex()];
	}
}
