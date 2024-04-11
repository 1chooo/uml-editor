package src.Views;

import java.awt.BorderLayout;
import javax.swing.*;

import src.Components.Canvas;
import src.Components.MenuBar;
import src.Components.SidePanel;

public class UMLEditor extends JFrame {

	// private variables
	private SidePanel toolbar;
	private MenuBar menubar;
	private Canvas canvas;
	private int width = 1280;
	private int height = 720;

	// constructor
	public UMLEditor() {
		super("UML Editor");
		initComponents();
	}

	// private methods
    private void initComponents() {
        toolbar = new SidePanel();
		toolbar.setOpaque(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(toolbar, BorderLayout.WEST);

		menubar = new MenuBar();
		this.setJMenuBar(menubar);

		canvas = Canvas.getInstance();
		this.getContentPane().add(canvas, BorderLayout.EAST);

		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
}
