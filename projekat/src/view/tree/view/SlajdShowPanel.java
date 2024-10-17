package view.tree.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.ISubscriber;
import model.Prezentacija;
import model.Slajd;
import model.nodes.RuNode;
import view.MainFrame;

public class SlajdShowPanel extends JPanel implements ISubscriber{
		private JButton btnLeft;
		private JButton btnRight;
		private JPanel centerPanel;
		private List<SlajdView> listaSlajdViewova;
		private CardLayout card;
		private JToolBar jToolbar;
		private int i;
		private int k;//index za dodavanje
		private Prezentacija prezentacija;
		
		
	public SlajdShowPanel(Prezentacija p) {
		
		listaSlajdViewova=new ArrayList<SlajdView>();
		
		this.prezentacija=p;
		
		
		
		//p.addSubscriber(this);
		card=new CardLayout();
		btnLeft=new JButton("Previous");
		btnRight=new JButton("Next");
		k=0;
		this.setLayout(new BorderLayout());
		
		centerPanel=new JPanel(card);	
			
		this.add(BorderLayout.CENTER,centerPanel);
		//setSlajdViews();
		card.show(centerPanel, "");
		i=0;
			
		jToolbar=new JToolBar(JToolBar.HORIZONTAL);
		jToolbar.add(MainFrame.getInstance().getActionManager().getEditStateAction());
		jToolbar.setFloatable(false);
		this.add(BorderLayout.NORTH,jToolbar);
		this.add(BorderLayout.WEST,btnLeft);
		this.add(BorderLayout.EAST,btnRight);
		if(!prezentacija.getChildren().isEmpty()) {
			addAllSlajdViews2();
			
		}
		
		btnLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(i-1>=0) {
					i--;
					
					//card.show(centerPanel,Integer.toString(i));
					card.previous(centerPanel);
				}	
			}
		});
		btnRight.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						if(i+1<listaSlajdViewova.size()) {
							i++;
										
							card.next(centerPanel);
						}	
					}
				});
	}
	public void setSlajdViews() {
		for(int i=0;i<listaSlajdViewova.size();i++) {
			
			SlajdView view=listaSlajdViewova.get(i);
			//Slajd slajd=listaSlajdViewova.get(i).getSlajd();
			//SlajdView view2=new SlajdView(slajd);
			centerPanel.add(view,Integer.toString(i));
			
		}
		
	}
		@Override
		public void update(Object notification) {
			if(notification instanceof Slajd) { 
				
				Slajd slajd=(Slajd)notification;
				if(prezentacija.getChildren().contains(slajd)) {
					
			
					
			}else {///Ako nas projekat ne sadrzi prezentaciju,znaci da je obrisana
			
				
				for(int i=0;i<listaSlajdViewova.size();i++) {
					
					if(listaSlajdViewova.get(i).getModel()==slajd) {
					
						
						
					}
					
				}
			
				MainFrame.getInstance().getProjectView().repaint();
		}
		
			}
		}
	
	public void addSlajdView(Slajd s) {
		
		SlajdView view=new SlajdView(s);
		listaSlajdViewova.add(view);
		
		centerPanel.add(view,Integer.toString(k));
		repaint();
		k++;
		
	}
	public void addSlajdView2(Slajd s) {
		int brojac=0;
		SlajdView view=new SlajdView(s);
		listaSlajdViewova.add(view);
		
		centerPanel.add(view,Integer.toString(brojac));
		repaint();
		brojac++;
		
		
	}
	public void removeSlajdView(int index) {
		
		
		
		
		listaSlajdViewova.remove(index);
		centerPanel.remove(index); 
		addAllSlajdViews();
		
	}
	public void addAllSlajdViews2() { /// ako prezentacija ima slajdove,ovo pravim iskljucivo zbog deljene prezentacije
		centerPanel.removeAll();
		
		for(RuNode ru:prezentacija.getChildren()) {
			Slajd s=(Slajd)ru;
			addSlajdView2(s);
			
		}
		
	}

	public void addAllSlajdViews() {
		centerPanel.removeAll();
		k=0;
		for(int i=0;i<listaSlajdViewova.size();i++) {
			centerPanel.add(listaSlajdViewova.get(i),Integer.toString(i));
			
			k++;
		}
	}
	
	public JPanel getCenterPanel() {
		return centerPanel;
	}


	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}


	public List<SlajdView> getListaSlajdViewova() {
		return listaSlajdViewova;
	}


	


	

	

}
