package controller;

import java.awt.event.ActionEvent;

import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class SelectionStateAction extends MyAbstractAction{

	public SelectionStateAction() {
		putValue(this.NAME,"Mouse state");
		putValue(this.SHORT_DESCRIPTION,"Mouse State");
		putValue(this.SMALL_ICON,loadIcon("images/mouse.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		view.getStateManager().setSelectionState();
		
		
		
	}

}
