package curves;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author casteran
 */

class CurveControls extends JPanel {

	private static final long serialVersionUID = 1L;

	protected final static Integer nStepsChoices[] = { 1, 2, 3, 4, 5, 10, 20,
			40, 80, 160, 320, 640 };

	private JComboBox<Integer> cb;
	private ZoomWidget zoom;

	CurveControls(final FunctionVariations var, final CurveFrame f) {
		super();		
		JPanel precision = new JPanel();
		JLabel precisionL = new JLabel("Precision");
		cb = new JComboBox<>(nStepsChoices);
		zoom = new ZoomWidget();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		precision.add(precisionL);
		precision.add(cb);
		add(precision);
		add(zoom.getWidget());

		
		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					var.tabulate(CurveControls.this.currentPrecision());
					f.infos.update();
					f.repaint();
				}
			}

		});
		cb.setSelectedIndex(nStepsChoices.length / 2);
		
	}

	int currentPrecision() {
		return nStepsChoices[cb.getSelectedIndex()];
	}
}
