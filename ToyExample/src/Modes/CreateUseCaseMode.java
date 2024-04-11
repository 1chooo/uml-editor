package test.src.Modes;

import java.awt.event.MouseEvent;

import test.src.Shapes.Shape;
import test.src.Shapes.UseCaseObj;

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
