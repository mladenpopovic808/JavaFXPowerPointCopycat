package controller;

import java.awt.event.ActionEvent;

import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class MoveSlotStateAction extends MyAbstractAction{

	public MoveSlotStateAction() {
		putValue(this.SMALL_ICON, loadIcon("images/move.png"));
		putValue(this.NAME,"Move slot");
		putValue(this.SHORT_DESCRIPTION,"Move slot");
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
		p.getStateManager().setMoveSlotState();
		
	}
	
	

}
