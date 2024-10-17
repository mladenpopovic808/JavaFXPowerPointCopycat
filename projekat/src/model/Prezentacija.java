package model;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.MutableTreeNode;

import model.nodes.RuNodeComposit;

public class Prezentacija extends RuNodeComposit{
	
	
	private String autor; 
	private String putanjaDoSlike; 
	private int redniBroj;
	private transient List<Projekat>projektiUKomeSeNalazim=new ArrayList<Projekat>();
	private File file;
	private transient boolean changed;
	
	
	public Prezentacija(String name, Projekat parent) {
		super(name, parent);
		
		
		this.putanjaDoSlike="images/blue.png";
	}
	@Override
	public void readResolve() {
		
		super.readResolve();
		projektiUKomeSeNalazim=new ArrayList<Projekat>();
		
	}
	
	public Prezentacija(String name) {
		setIme(name);
		
		
		
		this.putanjaDoSlike="images/blue.png";
	}
	
	
	
	public Prezentacija() {
		this.putanjaDoSlike="images/blue.png";
	}
	
	
	
	@Override
	public void setIme(String name) {
		setChanged(true);
		if(this.getIme()==null) { 
			String redniBroj1=name.substring(name.lastIndexOf(" "));  ///String 1
			redniBroj1=redniBroj1.trim();
			
			this.redniBroj=Integer.valueOf(redniBroj1)-1;
			
		}
		super.setIme(name);
		
		
		
		
		this.notifySubscribers("imePrezentacije");
	}

	@Override
	public void remove(MutableTreeNode aChild) {
		Slajd s=(Slajd)aChild;
		
		s.setRedniBroj(this.getChildren().indexOf(s));
		setChanged(true);
		super.remove(aChild);
	}
	
	public String getAutor() {
		return autor;
	}
	

	public void setAutor(String autor) {
		setChanged(true);
		this.autor = autor;
		this.notifySubscribers("promenaAutora");
	}

	public String getPutanjaDoSlike() {
		return putanjaDoSlike;
	}

	public void setPutanjaDoSlike(String putanjaDoSlike) {
		setChanged(true);
		this.putanjaDoSlike = putanjaDoSlike;
		this.notifySubscribers("putanjaDoSlike"); 
	}
	public int getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	public List<Projekat> getProjektiUKomeSeNalazim() {
		return projektiUKomeSeNalazim;
	}
	public void setProjektiUKomeSeNalazim(List<Projekat> projektiUKomeSeNalazim) {
		this.projektiUKomeSeNalazim = projektiUKomeSeNalazim;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public void setChanged(boolean changed) {
		this.changed = changed;
		
		
		for (Projekat p : projektiUKomeSeNalazim) {
			p.setChanged(changed);
			
		}
	}
	@Override
	public boolean isChanged() {
		return changed;
	}
	
	
	
	
	
	

	
	
	

}
