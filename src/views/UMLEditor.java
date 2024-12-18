package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import components.Canvas;
import components.MenuBar;
import components.SidePanel;
import utils.CONFIG;

public class UMLEditor extends JFrame {

	private SidePanel toolbar;
	private MenuBar menubar;
	private Canvas canvas;
	private int windowWidth = 1280;
	private int windowHeight = 720;

	public UMLEditor() {
		super(CONFIG.APP_NAME);
		initComponents();
	}

    private void initComponents() {
        toolbar = new SidePanel();
		toolbar.setOpaque(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(toolbar, BorderLayout.WEST);

		menubar = new MenuBar();
		this.setJMenuBar(menubar);

		canvas = Canvas.getInstance();
		this.getContentPane().add(canvas, BorderLayout.EAST);

		setSize(windowWidth, windowHeight);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
    }
}
