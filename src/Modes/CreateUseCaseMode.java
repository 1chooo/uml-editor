package src.Modes;

import java.awt.event.MouseEvent;

import src.Shapes.Shape;
import src.Shapes.UseCaseObj;

public class CreateUseCaseMode extends Mode{
	/*public CreateUseCaseMode()
	{
		
	}*/
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("x:" + e.getX() + "  y: "  + e.getY());
		Shape obj = new UseCaseObj(e.getX(),e.getY(),"Use Case");
		canvas.addShape(obj);
	}
}
