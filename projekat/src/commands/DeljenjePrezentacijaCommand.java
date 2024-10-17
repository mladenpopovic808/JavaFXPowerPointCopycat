package commands;

import javax.swing.SwingUtilities;

import model.Prezentacija;
import model.Projekat;
import view.MainFrame;
import view.tree.view.ProjectView;

public class DeljenjePrezentacijaCommand extends AbstractCommand {

	private String imeProjekta;
	private Prezentacija prezentacija;
	
	
	private Projekat projekat;
	
	
	
	
	public DeljenjePrezentacijaCommand(String imeProjekta, Prezentacija prezentacija) {
		super();
		this.imeProjekta = imeProjekta;
		this.prezentacija = prezentacija;
		
	}

	@Override
	public void doCommand() {
		
			
		for(ProjectView view:MainFrame.getInstance().getProjectViews()) {
		
		if(view.getProjekat().getIme().equalsIgnoreCase(imeProjekta)) {
			projekat=view.getProjekat();
			view.getProjekat().addSharedPresentation(prezentacija);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			
			
			return;
		}
		
	}
		
		
		
	}

	@Override
	public void undoCommand() {
		
		projekat.remove(prezentacija);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
	}

}
