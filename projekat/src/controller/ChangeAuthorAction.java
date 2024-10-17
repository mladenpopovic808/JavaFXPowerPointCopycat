package controller;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import model.Prezentacija;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class ChangeAuthorAction extends MyAbstractAction {
	
	 	
	
	
	public ChangeAuthorAction() {
		putValue(this.NAME,"Izmeni autora prezentacije");
		putValue(AbstractAction.SHORT_DESCRIPTION,"Izmeni autora");
		putValue(this.SMALL_ICON, loadIcon("images/autor_25x25.png"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o;
		try {
			o=MainFrame.getInstance().getTree().getSelectionPath().getLastPathComponent();
			if(o instanceof Prezentacija) {
				Prezentacija p=(Prezentacija)o;
				String imeAutora=JOptionPane.showInputDialog("Upisite novo ime autora");
				if(imeAutora==null) {
					return;
				}
				
				if(imeAutora.length()!=0) {
					p.setAutor(imeAutora);
				}else {
					ErrorHandler.getInstance().generateError(ErrorHandler.AUTHOR_NOT_VALID);
				}
			

			}else {
				
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);
			}
		} catch (Exception e2) {
			
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);
		}
		
		}
	
}









