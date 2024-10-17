package model.nodes;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class RuNodeComposit extends RuNode{
	
	private List<RuNode> children=new ArrayList<RuNode>();
	private boolean changed;
	
	
	public RuNodeComposit(String name) {
		super(name);
		
	}
	public RuNodeComposit(String name, RuNodeComposit parent) {
		super(name, parent);
		
	}
	
	
	
	
	public boolean isChanged() {
		return changed;
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public void addSharedPresentation(MutableTreeNode newChild) { ///Ne zelim da joj setujem parenta
		RuNode newChild1=(RuNode)newChild;
		this.getChildren().add(newChild1);
		//newChild.setParent(this);
		//newChild1.setParent(this);
		this.notifySubscribers(newChild);
		
	}
	
	public void add(RuNode newChild) {
		
		children.add(newChild);
		newChild.setParent(this);
		
	}
	
	@Override
	public void add(MutableTreeNode newChild) {
		RuNode newChild1=(RuNode)newChild;
		this.getChildren().add(newChild1);
		//newChild.setParent(this);
		newChild1.setParent(this);
		this.notifySubscribers(newChild);

		
	}
	public RuNodeComposit() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(MutableTreeNode newChild,int index) {
		RuNode newChild1=(RuNode)newChild;
		this.getChildren().add(index, newChild1);
		//newChild.setParent(this);
		newChild1.setParent(this);
		this.notifySubscribers(newChild);
		
	}
	@Override
	public void remove(int childIndex) {
		
		super.remove(childIndex);
	}
	@Override
	public void setParent(MutableTreeNode arg0) {
		
		super.setParent(arg0);
	}
	
	
	@Override
	public void remove(MutableTreeNode aChild) {
		
		if(this.children.contains(aChild)) {
			this.children.remove(aChild);
			this.notifySubscribers(aChild);
		}
	}
	
	@Override
	public Enumeration<TreeNode> children() {
		// TODO Auto-generated method stub
		return super.children();
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return this.getChildren().get(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return this.getChildren().size();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return this.getChildren().indexOf(node);
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<RuNode> getChildren() {
		return children;
	}


	public void setChildren(List<RuNode> children) {
		this.children = children;
	}

	
	
	
	

}
