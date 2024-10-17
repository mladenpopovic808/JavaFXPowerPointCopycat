package view;


import java.awt.Dimension;

import javax.swing.JToolBar;

public class MyToolBar extends JToolBar{
	
	public MyToolBar() {
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		this.add(MainFrame.getInstance().getActionManager().getNewNodeAction());
		this.add(MainFrame.getInstance().getActionManager().getMyInfoAction());
		this.add(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
		this.add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());
		this.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
		this.add(MainFrame.getInstance().getActionManager().getUndoAction());
		this.add(MainFrame.getInstance().getActionManager().getRedoAction());
		this.add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		this.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		this.addSeparator(new Dimension(20,0));
		this.add(MainFrame.getInstance().getActionManager().getSavePresentationAction());
		this.add(MainFrame.getInstance().getActionManager().getOpenPresentationAction());
		this.addSeparator(new Dimension(20,0));
		
		
		MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		
	}

}
