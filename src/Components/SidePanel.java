package src.Components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import src.Modes.CreateClassMode;
import src.Modes.CreateLineMode;
import src.Modes.CreateUseCaseMode;
import src.Modes.Mode;
import src.Modes.SelectMode;

public class SidePanel extends JToolBar {

	private JButton curBtn = null;
	private Canvas canvas;
	private Mode mode;

	public SidePanel() {
		canvas = Canvas.getInstance();
		GridLayout gridLayout = new GridLayout(6, 1);
		setLayout(gridLayout);
		initializeButtons();
	}

	private void initializeButtons() {
		mode = new SelectMode();
		JButton selectBtn = createButton("Select", "imgs/select.png", mode);
		this.add(selectBtn);

		mode = new CreateLineMode("AssociationLine");
		JButton associationBtn = createButton("<html>Association<br>Line</html>", "imgs/association-line.png", mode);
		this.add(associationBtn);

		mode = new CreateLineMode("GeneralizationLine");
		JButton generalizationBtn = createButton("<html>Generalization<br>Line</html>", "imgs/generation-line.png",
				mode);
		this.add(generalizationBtn);

		mode = new CreateLineMode("CompositionLine");
		JButton compositionBtn = createButton("<html>Composition<br>Line</html>", "imgs/composition-line.png", mode);
		this.add(compositionBtn);

		mode = new CreateClassMode();
		JButton classBtn = createButton("Class", "imgs/class.png", mode);
		this.add(classBtn);

		mode = new CreateUseCaseMode();
		JButton useCaseBtn = createButton("Use Case", "imgs/use-case.png", mode);
		this.add(useCaseBtn);
	}

	private JButton createButton(String name, String imgPath, Mode m) {
		JButton Btn = new JButton();
		Btn.setFocusPainted(false);

		Btn.setLayout(new BorderLayout());
		JLabel txt = new JLabel(name, SwingConstants.CENTER);
		JLabel img = new JLabel(new ImageIcon(imgPath));
		Btn.add(img, BorderLayout.WEST);
		Btn.add(txt, BorderLayout.CENTER);

		Btn.setBackground(new java.awt.Color(255, 255, 255));

		Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curBtn != null)
					curBtn.setBackground(new java.awt.Color(255, 255, 255));

				curBtn = (JButton) e.getSource();
				curBtn.setBackground(new java.awt.Color(120, 120, 120));

				canvas.setCurMode(m);
				canvas.selectedObj = null;
			}
		});

		return Btn;
	}
}
