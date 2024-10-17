package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import view.MainFrame;
import view.tree.error.ErrorHandler;
import view.tree.view.PrezentacijaView;

public class SlajdShowAction extends MyAbstractAction{
	
	 public SlajdShowAction() {
		putValue(this.NAME,"Slide Show");
		putValue(this.SHORT_DESCRIPTION,"Slide Show");
		putValue(this.SMALL_ICON,loadIcon("images/slideShow_25x25.png"));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			
			int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
			PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
			
			view.getStateManager().setSlideShowState();
			view.removeAll();
		
			view.add(BorderLayout.CENTER,view.getSlajdShowPanel());
			
			MainFrame.getInstance().validate();
			MainFrame.getInstance().getProjectView().updateUI();
			view.repaint();
			view.revalidate();
			view.validate();
			
	
		} catch (Exception e) {
			
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);
		}
		
	}
	
	
}
