package controller.state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import model.Slot;
import model.nodes.SlotType;
import view.MainFrame;
import view.MyBasicStroke;
import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public class AddRectangleState implements State{

	private BasicStroke myStroke;
	private Color color;
	private int debljina;
	private boolean isprekidana;
	//private BasicStroke stroke;
	private SlotType slotType;
	
	public AddRectangleState() {
		debljina=5;
		color=Color.orange;
		
		myStroke=new BasicStroke(debljina,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER);
		
		isprekidana=false;
		slotType=SlotType.TEXT;
	}
	public void misJeKliknut(MouseEvent e,PrezentacijaView prezView,SlajdView slajdView) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		
		Point position =e.getPoint();
		if(view.getStateManager().getState() instanceof AddRectangleState) {
			
	
			Slot slot2=new Slot(position.x,position.y,100,150,prezView.getStateManager().getAddRectangleState().getColor(),new MyBasicStroke(myStroke),slotType);
			if(!slajdView.getSlajd().getSlots().contains(slot2)) {
				
				slajdView.getSlajd().addToSlots(slot2);
			}
		
		
	}
	
	}
	public BasicStroke getStroke() {
		return myStroke;
	}
	public void setStroke(BasicStroke stroke) {
		this.myStroke=stroke;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void addRectangle() {
		
	}
	public int getDebljina() {
		return debljina;
	}
	public void setDebljina(int debljina) {
		this.debljina=debljina;
		if(isprekidana) {
			myStroke=new BasicStroke(debljina, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		
			
		}else {
			
			myStroke=new BasicStroke(debljina,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER);
		}
	
	}
	public boolean isIsprekidana() {
		return isprekidana;
	}
	public void setIsprekidana(boolean isprekidana) {
		this.isprekidana = isprekidana;
	}


	@Override
	public void misJePovucen(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void misJePritisnut(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void misJePusten(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		// TODO Auto-generated method stub
		
	}
	public SlotType getSlotType() {
		return slotType;
	}
	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}
	
	
	
	
}
