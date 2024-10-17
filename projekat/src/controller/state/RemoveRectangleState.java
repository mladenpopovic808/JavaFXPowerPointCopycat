package controller.state;

import java.awt.event.MouseEvent;

import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public class RemoveRectangleState implements State{

	
	public void removeRectangle() {
		
	}

	@Override
	public void misJeKliknut(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		
		
		slajdView.removeFromSlotView(e.getPoint());
		
		
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
}
