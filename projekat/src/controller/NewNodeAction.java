package controller;

import java.awt.event.ActionEvent;
import commands.AbstractCommand;
import commands.AddNodeCommand;
import controller.factory.AbstractNodeFactory;
import controller.factory.FactoryManager;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.Workspace;
import model.nodes.RuNode;
import model.nodes.RuNodeComposit;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class NewNodeAction extends MyAbstractAction{

	
	public NewNodeAction() {
		putValue(this.SHORT_DESCRIPTION,"Novi cvor");
		putValue(this.NAME,"Novi cvor");
		putValue(this.SMALL_ICON,loadIcon("images/plus_sign.png"));
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		RuNode selectedNode=(RuNode)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		AbstractNodeFactory factory=getNodeFactory(selectedNode);
		
		if(selectedNode instanceof Slajd) {
			ErrorHandler.getInstance().generateError(ErrorHandler.SLAJD_CANT_HAVE_CHILDREN);
			return;
		}
		
		selectedNode=(RuNodeComposit)selectedNode;
		
		if(factory==null) {
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_ITEM_SELECTED);
			return;
		}
		
		RuNode newNode=factory.getNodeForTree(selectedNode);
		

		AbstractCommand command=new AddNodeCommand(newNode,selectedNode,newNode.getParent().getChildren().indexOf(newNode));
		MainFrame.getInstance().getCommandManager().addCommand(command);
		
	}
	public AbstractNodeFactory getNodeFactory(RuNode selectedNode) {
		
		if(selectedNode instanceof Workspace) {
			return FactoryManager.projectFactory;
		}else if(selectedNode instanceof Projekat) {
			return FactoryManager.prezentacijaFactory;
		}else if(selectedNode instanceof Prezentacija) {
			return FactoryManager.slajdFactory;
		}
		return null;
	}
	
	

}
