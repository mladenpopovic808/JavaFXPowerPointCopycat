package controller;

import java.awt.event.ActionEvent;


import commands.DeleteNodeCommand;
import model.Workspace;
import view.MainFrame;


public class DeleteNodeAction extends MyAbstractAction {
	
	public DeleteNodeAction() {
		putValue(this.NAME,"Obrisi cvor");
		putValue(this.SHORT_DESCRIPTION,"Obrisi cvor");
		putValue(this.SMALL_ICON,loadIcon("images/delete_25x25.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(MainFrame.getInstance().getTree().getLastSelectedPathComponent()==null || MainFrame.getInstance().getTree().getLastSelectedPathComponent() instanceof Workspace) {
			return;
		}
		Object o=MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		MainFrame.getInstance().getCommandManager().addCommand(new DeleteNodeCommand(o));
		
			
	}
}
