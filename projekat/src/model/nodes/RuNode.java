package model.nodes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import controller.IPublisher;
import controller.ISubscriber;

public class RuNode extends DefaultMutableTreeNode implements IPublisher,Serializable{
	
	private transient List<ISubscriber> subscribers=new ArrayList<ISubscriber>();
	private String ime;
	private RuNodeComposit parent;
	
	
	public RuNode(String ime) {
		super();
		this.ime = ime;
	}
	
	public RuNode(String name, RuNodeComposit parent) {
		super();
		this.ime = name;
		this.parent = parent;
		
		
	}
	public RuNode() {
		
	}

	
	public void removeParent() {
		parent=null;
	}
	public void readResolve() {
		
		subscribers=new ArrayList<ISubscriber>();
	}
	
	@Override
	public Enumeration<TreeNode> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String name) {
		
		this.ime = name;
	}
	
	@Override
	public RuNodeComposit getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
	
	public void setParent(RuNodeComposit parent) {
		this.parent=parent;
		this.notifySubscribers(parent);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getIme();
	}

	@Override
	public void addSubscriber(ISubscriber sub) {
		boolean seNalazi=false;
//		for(int i=0;i<subscribers.size();i++) {
//			if(subscribers.get(i).toString().equalsIgnoreCase(sub.toString())) {
//				seNalazi=true;
//				
//			}
//	
//		}
//		if(seNalazi==false) {
			
		if(subscribers==null) {
		
			readResolve();
		}
			subscribers.add(sub);
			
		
//		}
		
		
		
		
	}

	@Override
	public void removeSubscriber(ISubscriber sub) {
		if(subscribers.contains(sub)) {
			subscribers.remove(sub);
		}
		
	}
	
	@Override
	public void notifySubscribers(Object notification) {
		
		for(int i=0;i<subscribers.size();i++) {
				
			
			subscribers.get(i).update(notification);
		
	}
	
}

}