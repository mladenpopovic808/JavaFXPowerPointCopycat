package controller;

import java.awt.event.ActionEvent;

import model.Prezentacija;
import view.DeljenjePrezentacijaDialog;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class DeljenjePrezentacijeAction extends MyAbstractAction {

	
	
	public DeljenjePrezentacijeAction() {
		putValue(this.NAME, "Podeli prezentaciju");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Prezentacija prez=(Prezentacija)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
			
			DeljenjePrezentacijaDialog dialog=new DeljenjePrezentacijaDialog(prez);
			dialog.setVisible(true);
			
			
		} catch (Exception e) {
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);
		}
		
	}


	

}
