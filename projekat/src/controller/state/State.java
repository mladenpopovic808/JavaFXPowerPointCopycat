package controller.state;

import java.awt.event.MouseEvent;

import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public interface State {
	
	public void misJeKliknut(MouseEvent e,PrezentacijaView prezView,SlajdView slajdView);
	public void misJePritisnut(MouseEvent e,PrezentacijaView prezView,SlajdView slajdView);
	public void misJePovucen(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView);
	public void misJePusten(MouseEvent e, PrezentacijaView prezView, SlajdView slajdView);
	

}
