package view.tree.view.slotContent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

import model.Slot;

public abstract class SlotHandler implements Serializable {
	
		private Slot slot;
		private Graphics2D g;
	
	
	 public SlotHandler(Slot slot) {
			super();
			this.slot = slot;
		}
	public abstract String readContent() ;
	 public abstract void setContent(String str);
	 public abstract void format();
	 public abstract void paint(Graphics2D g);
	 
	 
	 
	 
	 
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Graphics2D getG() {
		return g;
	}
	public void setG(Graphics2D g) {
		this.g = g;
	}
	 
	
	 
	
	
}
