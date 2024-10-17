package view.tree.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controller.ISubscriber;
import model.Slot;
import model.nodes.SlotType;
import view.MainFrame;
import view.tree.view.slotContent.MultimediaSlotHandler;
import view.tree.view.slotContent.SlotHandler;
import view.tree.view.slotContent.TextSlotHandler;

public class SlotView extends JPanel implements ISubscriber{
	
	private Slot slot;
	private SlotHandler slotHandler;
	

	public SlotView(Slot slot) {
		super();
		this.slot = slot;
		if(slot.getSlotType().equals(SlotType.TEXT)) {
			slotHandler=new TextSlotHandler(slot);
		}else {
			slotHandler=new MultimediaSlotHandler(slot);
		}
		slot.addSubscriber(this);
		
	}
	public Slot getSlot() {
		return slot;
	}

	@Override
	public void update(Object notification) {
		
			
		
		repaint();
		MainFrame.getInstance().getProjectView().repaint();
		
		
	}
	
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	public void paint(Graphics2D g) {
		
		slotHandler.paint(g);
		
	}
	
	public void paintComponent(Graphics g) {
		  
		
		 	
		  if(slot.getPutanjaDoSlike()!=null && !slot.getPutanjaDoSlike().equals("")) {
			  
			  Image img=new ImageIcon(slot.getPutanjaDoSlike()).getImage();
			 
				 
			    g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
		  }
		  
		
	  }
	
	public boolean elementAt(Point pos){

		if((slot.getX()<=pos.x && slot.getX()+slot.getW()>=pos.getX()) && (slot.getY()<=pos.y && slot.getY()+slot.getH()>=pos.getY()) ) {
			
		return true;
	}
		
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		SlotView slotView;
		if(obj instanceof SlotView) {
			slotView=(SlotView)obj;
			return slotView.getSlot().equals(this.getSlot());
		}
		
		return false;
	}

	public SlotHandler getSlotHandler() {
		return slotHandler;
	}

	public void setSlotHandler(SlotHandler slotHandler) {
		this.slotHandler = slotHandler;
	}

	
	
	
}













