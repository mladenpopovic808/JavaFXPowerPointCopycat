package controller;

import java.awt.event.ActionEvent;

import view.MainFrame;

public class RedoAction extends MyAbstractAction{

	public RedoAction() {
				putValue(this.NAME, "Redo");
				putValue(this.SHORT_DESCRIPTION,"Redo");
				putValue(this.SMALL_ICON,loadIcon("images/redo.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		MainFrame.getInstance().getCommandManager().doCommand();
	}

	
}
