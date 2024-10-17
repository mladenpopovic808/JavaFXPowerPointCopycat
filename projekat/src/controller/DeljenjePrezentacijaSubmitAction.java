package controller;

import java.awt.event.ActionEvent;
import commands.DeljenjePrezentacijaCommand;
import model.Prezentacija;
import view.DeljenjePrezentacijaDialog;
import view.MainFrame;

public class DeljenjePrezentacijaSubmitAction extends MyAbstractAction {

	private String imeProjekta;
	private Prezentacija prezentacija;
	private DeljenjePrezentacijaDialog dialog;
	
	public DeljenjePrezentacijaSubmitAction() {
		putValue(this.NAME, "Submit");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		dialog.setVisible(false);
		MainFrame.getInstance().getCommandManager().addCommand(new DeljenjePrezentacijaCommand(imeProjekta,prezentacija));
		

		
	}

	public String getImeProjekta() {
		return imeProjekta;
	}

	public void setImeProjekta(String imeProjekta) {
		this.imeProjekta = imeProjekta;
	}

	public Prezentacija getPrezentacija() {
		return prezentacija;
	}

	public void setPrezentacija(Prezentacija prezentacija) {
		this.prezentacija = prezentacija;
	}

	public DeljenjePrezentacijaDialog getDialog() {
		return dialog;
	}

	public void setDialog(DeljenjePrezentacijaDialog dialog) {
		this.dialog = dialog;
	}


	
	
	

}
