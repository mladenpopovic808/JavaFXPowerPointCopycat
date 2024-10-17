package controller;

import java.awt.event.ActionEvent;
import view.MainFrame;

public class UndoAction extends MyAbstractAction {
	
	 public UndoAction() {
			putValue(this.NAME, "Undo");
			putValue(this.SHORT_DESCRIPTION,"Undo");
			putValue(this.SMALL_ICON,loadIcon("images/undo.png"));
			
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MainFrame.getInstance().getCommandManager().undoCommand();
	}

}
