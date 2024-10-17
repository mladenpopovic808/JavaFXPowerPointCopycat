package commands;

import javax.swing.SwingUtilities;

import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.Workspace;
import model.nodes.RuNode;
import view.MainFrame;

public class NameCommand extends AbstractCommand{
	
	private String lastName;
	private RuNode node;
	private String newName;
	
		public NameCommand(RuNode node,String newName) {
			this.node=node;
			this.newName=newName;
		}
	
	
	@Override
	public void doCommand() {
		lastName=node.getIme();
		if(node instanceof Projekat) {
			node.setIme(newName);
			
		}
		else if(node instanceof Prezentacija) {
			node.setIme(newName);
		
		}
		else if(node instanceof Slajd) {
			node.setIme(newName);
			
		}else if (node instanceof Workspace){
			node.setIme(newName);
			
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
	}

	@Override
	public void undoCommand() {
		node.setIme(lastName);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
	}
	

}
