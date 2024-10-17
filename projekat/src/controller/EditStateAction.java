package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class EditStateAction extends MyAbstractAction{
	
	public EditStateAction() {
		this.putValue(this.SHORT_DESCRIPTION,"Back to edit page");
		this.putValue(this.NAME,"Back");
		this.putValue(this.SMALL_ICON,loadIcon("images/left_25x25.png"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		view.getStateManager().setEditState();
		view.removeAll();
		view.add(BorderLayout.NORTH,view.getToolbar());
		view.add(BorderLayout.CENTER,view.getMainPanel());
		MainFrame.getInstance().getProjectView().updateUI();
		view.addAllSlajdView();
		
	
		
		Box box=Box.createVerticalBox();
		for(int i=0;i<view.getListaSlajdViewova().size();i++) {
		
		
			
			box.add(view.getListaSlajdViewova().get(i));
			view.getSlajdBoxRight().add(view.getListaSlajdViewova().get(i));
			
			
			view.getSlajdBoxRight().validate();
			view.getSlajdBoxRight().repaint();
			view.validate();
			view.repaint();
			MainFrame.getInstance().getProjectView().repaint();
			MainFrame.getInstance().getProjectView().validate();
			view.getListaSlajdViewova().get(i).repaint();
			view.getSlajdBoxRight().revalidate();
		
		}
		
		MainFrame.getInstance().repaint();
		MainFrame.getInstance().revalidate();
	}
	

}
