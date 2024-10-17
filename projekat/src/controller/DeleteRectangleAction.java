package controller;

import java.awt.event.ActionEvent;

import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class DeleteRectangleAction extends MyAbstractAction{

	
	public DeleteRectangleAction() {
		putValue(this.NAME, "Delete rectangle");
		putValue(this.SHORT_DESCRIPTION,"Delete rectangle");
		putValue(this.SMALL_ICON,loadIcon("images/deleteRectangle.jpg"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
		p.getStateManager().setRemoveRectangleState();
		
	}

}
