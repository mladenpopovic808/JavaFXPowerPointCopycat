package controller;

import java.awt.event.ActionEvent;
import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class AddRectangleAction extends MyAbstractAction {

	
	public AddRectangleAction() {
		putValue(this.NAME, "Add rectangle");
		putValue(this.SHORT_DESCRIPTION, "Add rectangle");
		putValue(this.SMALL_ICON,loadIcon("images/Rectangle.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
		p.getStateManager().setAddRectangleState();
		
	}

}
