package view.tree.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import controller.IPublisher;
import controller.ISubscriber;
import model.Workspace;

public class TreeModel extends DefaultTreeModel implements IPublisher{
	
	private List<ISubscriber> subscribers=new ArrayList<ISubscriber>();
	private Workspace workspace;

	public TreeModel() {
		super(new Workspace("Workspace"));
		
	}
	
	@Override
	public void addSubscriber(ISubscriber sub) {
		if(!subscribers.contains(sub)) {
			subscribers.add(sub);
		}
		
	}

	@Override
	public void removeSubscriber(ISubscriber sub) {
		if(subscribers.contains(sub)) {
			subscribers.remove(sub);
		}
		
	}

	@Override
	public void notifySubscribers(Object notification) {
		for (ISubscriber sub : subscribers) {
			sub.update(notification);
		}
	}
	
	public TreeModel(TreeNode arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	public TreeModel(TreeNode arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}
	public Workspace getWorkspace() {
		return workspace;
	}
	
	
	

}
