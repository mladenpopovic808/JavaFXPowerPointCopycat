package controller.state;

import java.awt.event.MouseEvent;

import model.Slot;
import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public class MoveSlotState implements State{
	
	public boolean dragging=false;
	
	@Override
	public void misJeKliknut(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		
		try {

			if(slajdView.getSelectedSlotView().elementAt(e.getPoint())) {
				
				dragging=true;
				
			}else {
				
				dragging=false;
			}
		} catch (Exception e2) {
			
		}
	}
	
	@Override
	public void misJePusten(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		if(dragging) {
			slajdView.getSelectedSlotView().getSlot().setPosition(e.getPoint());

			dragging=false;
		}
		
	}
	@Override
	public void misJePovucen(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		
		try {
			Slot s=slajdView.getSelectedSlotView().getSlot();
			if(dragging) {
			
				s.setPosition(e.getPoint());
				
			}
			
		} catch (Exception e2) {
			
		}
	
	}
	
	@Override
	public void misJePritisnut(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		if(slajdView.getSelectedSlotView().elementAt(e.getPoint())) {
			
			dragging=true;
			
			
		}else {
			
			dragging=false;
		}
		
	}
	

}
