package controller.factory;

import model.Prezentacija;
import model.Projekat;
import model.Workspace;
import model.nodes.RuNode;
import model.nodes.RuNodeComposit;

public abstract class AbstractNodeFactory {
	
	
	public RuNode getNodeForTree(RuNode selectedNode) {
		
		RuNode node=createNode();
		node.setParent((RuNodeComposit)selectedNode);
		node.setIme(generateName(selectedNode));
		
		return node;
		
		
		
		
	}
	public abstract RuNode createNode();
		
	public String generateName(RuNode selectedNode) {
		
		RuNode node=(RuNodeComposit)selectedNode;
		if(selectedNode instanceof Workspace) {
			return "Projekat "+Integer.toString(node.getChildCount()+1);
			
		}
		if(selectedNode instanceof Projekat) {
			return "Prezentacija "+Integer.toString(node.getChildCount()+1);	
					
		}
		if(selectedNode instanceof Prezentacija) {
			return "Slajd "+Integer.toString(node.getChildCount()+1);
			
		}
		return "NoName";
		
	}
}
