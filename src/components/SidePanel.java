package components;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import modes.CreateLineMode;
import modes.CreateShapeMode;
import modes.Mode;
import modes.SelectMode;
import utils.MODES;

public class SidePanel extends JToolBar {

	private JButton curBtn = null;
	private Canvas canvas;

	public SidePanel() {
		canvas = Canvas.getInstance();
		GridLayout gridLayout = new GridLayout(6, 1);
		setLayout(gridLayout);
		initializeButtons();
	}

	private void initializeButtons() {
		JButton selectBtn = createButton(
				MODES.getModeButtonName(MODES.SELECT),
				MODES.getModeImagePath(MODES.SELECT),
				new SelectMode(MODES.SELECT));
		this.add(selectBtn);

		JButton associationBtn = createButton(
				MODES.getModeButtonName(MODES.ASSOCIATION_LINE),
				MODES.getModeImagePath(MODES.ASSOCIATION_LINE),
				new CreateLineMode(MODES.ASSOCIATION_LINE));
		this.add(associationBtn);

		JButton generalizationBtn = createButton(
				MODES.getModeButtonName(MODES.GENERALIZATION_LINE),
				MODES.getModeImagePath(MODES.GENERALIZATION_LINE),
				new CreateLineMode(MODES.GENERALIZATION_LINE));
		this.add(generalizationBtn);

		JButton compositionBtn = createButton(
				MODES.getModeButtonName(MODES.COMPOSITION_LINE),
				MODES.getModeImagePath(MODES.COMPOSITION_LINE),
				new CreateLineMode(MODES.COMPOSITION_LINE));
		this.add(compositionBtn);

		JButton classBtn = createButton(
				MODES.getModeButtonName(MODES.CLASS),
				MODES.getModeImagePath(MODES.CLASS),
				new CreateShapeMode(MODES.CLASS));
		this.add(classBtn);

		JButton useCaseBtn = createButton(
				MODES.getModeButtonName(MODES.USE_CASE),
				MODES.getModeImagePath(MODES.USE_CASE),
				new CreateShapeMode(MODES.USE_CASE));
		this.add(useCaseBtn);
	}

	private JButton createButton(String name, String imgPath, Mode mode) {
		JButton btn = new JButton();
		btn.setFocusPainted(false);

		btn.setLayout(new BorderLayout());
		JLabel txt = new JLabel(name, SwingConstants.CENTER);
		JLabel img = new JLabel(new ImageIcon(imgPath));
		btn.add(img, BorderLayout.WEST);
		btn.add(txt, BorderLayout.CENTER);

		btn.setBackground(new java.awt.Color(255, 255, 255));

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curBtn != null)
					curBtn.setBackground(new java.awt.Color(255, 255, 255));

				curBtn = (JButton) e.getSource();
				curBtn.setBackground(new java.awt.Color(120, 120, 120));

				canvas.setCurrrentMode(mode);
				canvas.selectedObject = null;
			}
		});

		return btn;
	}
}
