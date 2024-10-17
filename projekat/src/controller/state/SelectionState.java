package controller.state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;

import model.Slot;
import model.nodes.SlotType;
import view.MainFrame;
import view.MyBasicStroke;
import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public class SelectionState implements State{
	private Slot selectedSlot; /// pamtim selektovani slot,da bih mogao da ga unselectujem u momentu kada selectujem drugi slot
							   ///jer u jednom trenutku samo jedan slot moze biti selektovan
	
	
	public SelectionState() {
		//selectedSlot=new Slot(0, 0, 0, 0, Color.black, new BasicStroke());
		selectedSlot=new Slot(0, 0, 0, 0, Color.black, new MyBasicStroke(new BasicStroke()),SlotType.TEXT);
		
	}
	
	@Override
	public void misJeKliknut(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView) {
		
		Slot s=slajdView.selectSlot(e.getPoint());
		
		if(s!=null && !s.equals(selectedSlot)) {
		
			selectedSlot.setSelected(false);
			
			selectedSlot=s;
			
			MainFrame.getInstance().getActionManager().getSadrzajSlotaAction().setEnabled(true);		
			
			slajdView.updateUI();
	
		}
	
		
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

	public Slot getSelectedSlot() {
		return selectedSlot;
	}
	

}
