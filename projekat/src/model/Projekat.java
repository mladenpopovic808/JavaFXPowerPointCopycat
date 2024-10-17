package model;


import java.io.File;
import java.io.Serializable;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import controller.ISubscriber;
import model.nodes.RuNode;
import model.nodes.RuNodeComposit;
import view.MainFrame;


public class Projekat extends RuNodeComposit implements ISubscriber{
	
	
	private transient boolean changed;
	private File file;
	
	public Projekat(String name, Workspace parent) {
		super(name, parent);
		// TODO Auto-generated constructor stub
		
	}
	public Projekat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setIme(String name) {
		this.getParent().setChanged(true);
		changed=true;
		super.setIme(name);
		
		this.notifySubscribers(new String("imeProjekta"));
	}
	
	@Override
	public void addSharedPresentation(MutableTreeNode newChild) {
		this.getParent().setChanged(true);
		changed=true;
		super.addSharedPresentation(newChild);
		Prezentacija p=(Prezentacija)newChild;
		p.getProjektiUKomeSeNalazim().add(this);
		
		
	}
	
	@Override
	public void add(MutableTreeNode newChild) {
		this.getParent().setChanged(true);
		changed=true;
		RuNode newChild1=(RuNode)newChild;
		this.getChildren().add(newChild1);
		Prezentacija p=(Prezentacija)newChild1;
		p.getProjektiUKomeSeNalazim().add(this);
		//newChild.setParent(this);
		newChild1.setParent(this);
		this.notifySubscribers(newChild);
		
	}
	
	@Override
	public void remove(MutableTreeNode aChild) {
		
		if(this.getChildren().contains(aChild)) {
			this.getChildren().remove(aChild);
			Prezentacija p=(Prezentacija)aChild;
			p.getProjektiUKomeSeNalazim().remove(this);
			this.notifySubscribers(aChild);
			changed=true;
		}
	}

	
	@Override
	public void update(Object notification) {
		changed=true;
		this.getParent().setChanged(true);
		if(notification instanceof String) {
			String str=(String)notification;
			
			if(str.equalsIgnoreCase("imePrezentacije")) {
				
				notifySubscribers(notification);
			}
		}if(notification instanceof Slajd) {
			Slajd s=(Slajd)notification;
			this.notifySubscribers(s);
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getIme();
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
	

	
	

}
