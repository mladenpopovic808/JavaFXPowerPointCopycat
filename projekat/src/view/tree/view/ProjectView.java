package view.tree.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import controller.ISubscriber;
import model.Prezentacija;
import model.Projekat;
import model.nodes.RuNode;
import view.MainFrame;

public class ProjectView extends JPanel implements ISubscriber{
	
	private Projekat projekat;
	private JLabel imeProjekta;
	private JTabbedPane tabbedPane;
	private List<PrezentacijaView> listaPrezViewova;
	
	
	
	public ProjectView(Projekat selektovaniProjekat) {
		super();
		
		this.projekat = selektovaniProjekat;
		selektovaniProjekat.addSubscriber(this);
		tabbedPane=new JTabbedPane();
		
		this.setLayout(new BorderLayout());
		listaPrezViewova=new ArrayList<PrezentacijaView>();
		
		initGui();
	}
	
	public ProjectView() {
		tabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
		
	}
	private void initGui() {
	
		
		imeProjekta=new JLabel(projekat.getIme());
		JPanel top=new JPanel();
		top.add(imeProjekta);
		
		add(BorderLayout.NORTH,top);
		add(BorderLayout.CENTER,tabbedPane);
		
	}
	

	
	@Override
	public void update(Object notification) {
			
		if(notification instanceof Projekat) {
			
			
			addAllPrezentacijaViewsToTabbedPane();
			
			
		}if(notification instanceof Prezentacija) { ///Ako je prezentacija,znaci da ili dodajemo ili brisemo prezentaciju.
			
			Prezentacija prez=(Prezentacija)notification;
			if(projekat.getChildren().contains(prez)) {///ako je dodata prezentacija,dodajemo je i u prezentacijaView
				
				addPrezentacijaView(prez);
				
				
		}else {///Ako nas projekat ne sadrzi prezentaciju,znaci da je obrisana
				prez.setRedniBroj(tabbedPane.indexOfTab(prez.getIme()));///pamti se index na kom je poslednje bila prezentacija
				tabbedPane.removeTabAt(tabbedPane.indexOfTab(prez.getIme()));
			
					for(int i=0;i<listaPrezViewova.size()-1;i++) {
						if(listaPrezViewova.get(i).getPrezentacija()==prez) {
							listaPrezViewova.remove(listaPrezViewova.get(i));
							
						}
					}
				
			}
		}
		
		if(notification instanceof String) {
			
			String str=(String)notification;
			if(str.equalsIgnoreCase("imeProjekta")) {
				
				this.imeProjekta.setText(projekat.getIme());
				
			}
			if(str.equalsIgnoreCase("imePrezentacije")) {
				
				Prezentacija p=(Prezentacija)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				int index=projekat.getIndex(p);
				
				
				tabbedPane.setTitleAt(index,p.getIme());
				
			}
		}
		}
		
		
	public void setListaPrezViewova() {
	
		listaPrezViewova=new ArrayList<PrezentacijaView>();
		for(RuNode ru:projekat.getChildren()) {
			
		
			Prezentacija p=(Prezentacija)ru;
			PrezentacijaView view=new PrezentacijaView(p);
			
			listaPrezViewova.add(view);
						
		}
		
	}
	
	public void addPrezentacijaView(Prezentacija p) {
		
		PrezentacijaView view=new PrezentacijaView(p);
		listaPrezViewova.add(view);
		//view.setSlajdShowPanel(new SlajdShowPanel(p));
		//tabbedPane.addTab(p.getIme(),view);
		
		if(p.getRedniBroj()>tabbedPane.getTabCount()) {
			tabbedPane.insertTab(p.getIme(), null,view, null, tabbedPane.getTabCount()); /// mozda treba -1
		}else {
			tabbedPane.insertTab(p.getIme(), null,view, null, p.getRedniBroj());
		}
		
		
		
	
		
	}
	
	public void addAllPrezentacijaViewsToTabbedPane() {
		
		tabbedPane.removeAll();
		
		for(PrezentacijaView view: listaPrezViewova) {
			
			tabbedPane.addTab(view.getPrezentacija().getIme(), view);
			
		}
		
		
	}
	public PrezentacijaView getSelectedPrezentacijaView(Prezentacija p) {
		
		for(PrezentacijaView prezView:listaPrezViewova) {
			if(p.equals(prezView.getPrezentacija())) {
				return prezView;
			}
		}
		
		return null;
		
	}
	
	
	public Projekat getModel() {
		return projekat;
	}

	public void setProjekat(Projekat selektovaniProjekat) {
		
		this.projekat = selektovaniProjekat;
		this.projekat.addSubscriber(this);
		this.update(this.projekat);
	}

	public Projekat getSelektovaniProjekat() {
		return projekat;
	}

	public List<PrezentacijaView> getListaPrezViewova() {
		return listaPrezViewova;
	}
	
	public Projekat getProjekat() {
		return projekat;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Project view: "+this.getProjekat().getIme();
	}
	
	
	

}






