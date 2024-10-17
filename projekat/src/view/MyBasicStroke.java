package view;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.Serializable;

public class MyBasicStroke implements Stroke,Serializable{
	
	private Stroke stroke;

	
	
	
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		if (stroke instanceof BasicStroke) {
			BasicStroke s = (BasicStroke) stroke;
			out.writeFloat(s.getLineWidth());
			out.writeInt(s.getEndCap());
			out.writeInt(s.getLineJoin());
			out.writeFloat(s.getMiterLimit());
			out.writeObject(s.getDashArray());
			out.writeFloat(s.getDashPhase());
		}
     }
	
    private void readObject(java.io.ObjectInputStream in) 
     		throws IOException, ClassNotFoundException{
    	stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(),
    				in.readFloat(), (float[])in.readObject(), in.readFloat());
     }
		
	
	
	public Shape createStrokedShape(Shape p) {
		return stroke.createStrokedShape(p);
	}
	
	
	
	
	
	public MyBasicStroke(BasicStroke stroke) {
		super();
		this.stroke = stroke;
	}

	

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	

	
	
	
	

}
