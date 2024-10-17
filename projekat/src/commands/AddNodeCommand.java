package commands;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import controller.ISubscriber;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.nodes.RuNode;
import model.nodes.RuNodeComposit;
import view.MainFrame;
import view.tree.view.ProjectView;

public class AddNodeCommand extends AbstractCommand{

	private RuNode node;
	private RuNodeComposit parent;
	private int index;
	
	
	
	
	public AddNodeCommand(RuNode node, RuNode parent, int index) {
		this.node = node;
		this.parent = (RuNodeComposit)parent;
		this.index = index;
	}

	@Override
	public void doCommand() {
		
		
		parent.add((MutableTreeNode)node);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		MainFrame.getInstance().getTree().expandPath(MainFrame.getInstance().getTree().getLeadSelectionPath());

		
		
		if(node instanceof Projekat) {
			
			MainFrame.getInstance().getProjectViews().add(new ProjectView((Projekat)node));
			
				
			
		}else if(node instanceof Prezentacija) {
			
			node.addSubscriber((ISubscriber)parent);
			int i=MainFrame.getInstance().getProjectView().getTabbedPane().getComponentCount()-1;
		    MainFrame.getInstance().getProjectView().getTabbedPane().setSelectedIndex(i);
			
		}else if(node instanceof Slajd) {
			parent.addSubscriber((ISubscriber)node);
			int index1=MainFrame.getInstance().getProjectView().getProjekat().getIndex(parent);
			MainFrame.getInstance().getProjectView().getTabbedPane().setSelectedIndex(index1);
		}
		MainFrame.getInstance().getTree().expandPath(MainFrame.getInstance().getTree().getLeadSelectionPath());
			
	}

	
	
	@Override
	public void undoCommand() {
		///Treba obrisati sa ekrana
	
		parent.remove(node);
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
	}

	
	
	
	public RuNode getNode() {
		return node;
	}


	public void setNode(RuNode node) {
		this.node = node;
	}

	public RuNode getParent() {
		return parent;
	}

	public void setParent(RuNodeComposit parent) {
		this.parent = parent;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	

}
