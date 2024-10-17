package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import controller.ISubscriber;
import model.nodes.RuNode;
import model.nodes.RuNodeComposit;
import view.tree.error.ErrorHandler;

public class Slajd extends RuNode implements ISubscriber{
	
	
	private int redniBroj;
	private String putanjaDoSlike;
	private List<Slot>slots;
	
	public Slajd(String name, Prezentacija parent) {
		super(name, parent);
		slots=new ArrayList<Slot>();
	}


	public Slajd(String name,int redniBroj) {
		
		super(name);
		
		this.redniBroj = redniBroj;
		slots=new ArrayList<Slot>();
	}
	public Slajd(String name) {
		
		super(name);
		
		String redniBroj=name.substring(name.lastIndexOf(" "));  ///String 1
		this.redniBroj=Integer.valueOf(redniBroj);
		slots=new ArrayList<Slot>();
				
	}
	public Slajd() {
		slots=new ArrayList<Slot>();
	}
	
	@Override
	public String toString() {
		
		return this.getIme();
	}
	
	@Override
	public void update(Object notification) {
		
			if(notification instanceof String) {
				String str=(String)notification;
				if(str.equalsIgnoreCase("putanjaDoSlike")) {
					
					notifySubscribers("putanjaDoSlike");
					
				}else if(str.equalsIgnoreCase("rectangle")) {
					notifySubscribers("rectangle");
				}
			}
			
		}
	
	@Override
	public void setIme(String name) {
		Prezentacija prez=(Prezentacija)this.getParent();
		prez.setChanged(true);
		
			if(this.getIme()==null) {//ako se prvi put setuje,ne zelim da mu pri svakom setovanju imena menjam redni broj
			
			String [] split=name.split(" ");
			this.redniBroj=Integer.parseInt(split[1])-1;
			
		}
			
		super.setIme(name);
		
		
	}
	
	
	public String getPutanjaDoSlike() {
		return putanjaDoSlike;
	}

	public void removeFromSlots(Slot slot) {
		slots.remove(slot);
		notifySubscribers(slot);
	}
	public void addToSlots(Slot slot) {
		slots.add(slot);
		
		slot.addSubscriber(this);
		notifySubscribers(slot);
		
	}
	public void setBackground(Image image) {
		 
		
		
	}
	public void setBackground(String fileName) {
		
	}
	
	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	
	@Override
	public void setParent(RuNodeComposit parent) {
		if(parent instanceof Prezentacija) {
			super.setParent(parent);
		}else {
		ErrorHandler.getInstance().generateError(ErrorHandler.SLAJD_CAN_BE_ADDED_ONLY_IN_PRESENTATION);
		}
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Slajd) {
			Slajd s=(Slajd)obj;
			
			if(s.toString().equalsIgnoreCase(this.toString())) {
				
				return true;
			}
			}
		
		return false;
		}

	public List<Slot> getSlots() {
		return slots;
	}


	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
		
		
	

	
	
	
	
}
