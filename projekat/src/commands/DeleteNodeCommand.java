package commands;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import model.Prezentacija;
import model.Projekat;

import model.nodes.RuNode;
import model.nodes.RuNodeComposit;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class DeleteNodeCommand extends AbstractCommand {

		 private int index;
		 private RuNodeComposit parent;
		 private RuNode node;
		 
		 
	
	
		 private Object o;
		 private List<Projekat>projekti;
		 private List<Projekat>projectiCopy=new ArrayList<Projekat>();
		 
		
		public DeleteNodeCommand(Object o) {
				
				this.o = o;
			}
	
	@Override
	public void doCommand() {
	
		try {
			
				RuNode ru=(RuNode)o;
				RuNodeComposit par=(RuNodeComposit)ru.getParent();
				index=par.getChildren().indexOf(ru);
				
				this.node=ru;
				
				this.parent=(RuNodeComposit) par;
				
				
				
				if(ru instanceof Prezentacija) { /// zbog deljenih prezentacija
					
					Prezentacija p=(Prezentacija)ru;
					
					if(p.getProjektiUKomeSeNalazim().size()>1) {///ako je dokument podeljen
						
					if(projectiCopy.isEmpty()) {///ako ne ulazimo ovde prvi put
						
						projekti=p.getProjektiUKomeSeNalazim();///jer kada obrisemo prezentaciju,obrisacemo i listu
					}
				
					
					if(projectiCopy.isEmpty()) {
						while(!projekti.isEmpty()) {
							
							
							projectiCopy.add(projekti.get(0));
							projekti.get(0).remove(p);
						}
					}else {
						while(!projekti.isEmpty()) {
						
							projekti.get(0).remove(p);
					}
					
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					return;
					
				}
			}
		}
				
				if(o instanceof Projekat) {
				
					MainFrame.getInstance().getWorkSpacePanel().remove(MainFrame.getInstance().getProjectView());
					
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkSpacePanel());
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					
				}
				
				par.remove(ru);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
			} catch (Exception e) {
				e.printStackTrace();
				ErrorHandler.getInstance().generateError(ErrorHandler.NO_ITEM_SELECTED);
			
		}
		
	}
	
		
	
	
	@Override
	public void undoCommand() {
		
		if(node instanceof Prezentacija) {
			
			if(projectiCopy.size()>1) {
				
			
			for(int i=0;i<projectiCopy.size();i++) {
				Projekat projekat=(Projekat)projectiCopy.get(i);
				projekat.addSharedPresentation(node);
				
				
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			return;
		}
		}
		
		parent.add((MutableTreeNode)node,index);
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
		
		
		
	}

}
