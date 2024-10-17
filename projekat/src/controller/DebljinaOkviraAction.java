package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import view.MainFrame;
import view.tree.error.ErrorHandler;
import view.tree.view.PrezentacijaView;

public class DebljinaOkviraAction extends MyAbstractAction {

	public DebljinaOkviraAction() {
		putValue(this.SMALL_ICON,loadIcon("images/debljina.png"));
		putValue(this.SHORT_DESCRIPTION,"Debljina okvira");
		putValue(this.NAME,"Debljina okvira");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		String unos=JOptionPane.showInputDialog("Upisite debljinu okvira 0-50");
		int debljina;
		
		if(unos==null) {
			return;
		}
		
		try {
			debljina=Integer.parseInt(unos);
			
			if(debljina>0 && debljina<=50) {
				view.getStateManager().getAddRectangleState().setDebljina(debljina);
			}else {
				ErrorHandler.getInstance().generateError(ErrorHandler.THICKNESS_NOT_VALID);
			}
			
			
		} catch (Exception e) {
			ErrorHandler.getInstance().generateError(ErrorHandler.THICKNESS_NOT_VALID);
		}
		
	}

}
