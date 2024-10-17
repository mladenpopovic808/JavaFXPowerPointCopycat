package view.tree.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.IPublisher;
import controller.ISubscriber;
import model.Prezentacija;
import model.Slajd;
import model.Slot;
import view.MainFrame;
import view.tree.view.SlajdViewPanelController.SlajdViewPanelController;

public class SlajdView extends JPanel implements ISubscriber,IPublisher{
	private Slajd slajd;
	private List<SlotView>slotViews;
	private MouseListener mouseListener;
	private SlotView selectedSlotView;
	public Slajd getModel() {
		return slajd;
		
	}

	public void setModel(Slajd slajd) {
		this.slajd = slajd;
		this.slajd.addSubscriber(this);
		
		
		
	}
	
	
	

	public SlajdView(Slajd slajd) {
		super();
		this.slajd = slajd;
		
		this.slajd.addSubscriber(this);
		
		
		slotViews=new ArrayList<SlotView>();
		mouseListener=new SlajdViewPanelController(this);
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener((MouseMotionListener)mouseListener);
		
		initGUI();
		addSlotViews();
	}

	private void initGUI() {
		this.setPreferredSize(new Dimension(550,450));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(new Dimension(300,300));
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.SOUTH,new JLabel((slajd.getIme().substring(slajd.getIme().lastIndexOf(" ")))));
		
		
		
	}

	public void paintComponent(Graphics g) {
		  Prezentacija p=(Prezentacija)slajd.getParent();
		 
		 
		  if(p.getPutanjaDoSlike()!=null && !p.getPutanjaDoSlike().equals("")) {
			  
			  Image img=new ImageIcon(p.getPutanjaDoSlike()).getImage();
			
				 
			    g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
		  }
		  
//		  if(slotViews.size()==0) { 	/// Kada se vraca slajdView posle brisanja(preko undo akcije),slajdView nema slotViewove u sebi,pa ih dodajem
//			  addSlotViews();
//		  }
		  
		  
		  for(SlotView view:slotViews) {
			 
			  view.paint((Graphics2D)g);
			  
			 
		  }
		  

	  }

	@Override
	public void update(Object notification) {
		String s="";
		if(notification instanceof String) {
			s=(String)notification;
		}
		if(s.equalsIgnoreCase("putanjaDoSlike")) {
			
			repaint();
			MainFrame.getInstance().getProjectView().repaint();
			
		}else if(s.equalsIgnoreCase("rectangle")) {
			Prezentacija prez=(Prezentacija)slajd.getParent();
			prez.setChanged(true);
			repaint();
			MainFrame.getInstance().getProjectView().repaint();
	}
		
		if(notification instanceof Slot) {
			Slot slot=(Slot)notification;
			SlotView slotView = new SlotView(slot);
			if(this.slajd.getSlots().contains(slot)) {
				
				this.addToSlotViews(slotView);
			}else {
				slotViews.remove(slotView);
			}
			repaint();
			Prezentacija prez=(Prezentacija)slajd.getParent();
			prez.setChanged(true);
		}
	
		
	}
	public void addToSlotViews(SlotView view) {
		if(!slotViews.contains(view)) {
			
			slotViews.add(view);
		}
		MainFrame.getInstance().getProjectView().updateUI();
	}
	
	public void removeFromSlotView(Point p) {
		for(int i=0;i<slotViews.size();i++) {
			
			if(slotViews.get(i).elementAt(p)) {
				
				if(slotViews.get(i).getSlot().isSelected()) {
					MainFrame.getInstance().getActionManager().getSadrzajSlotaAction().setEnabled(false);
				}
				slajd.removeFromSlots(slotViews.get(i).getSlot());
				
			}
			
			
		}
		MainFrame.getInstance().getProjectView().repaint();
		MainFrame.getInstance().getProjectView().updateUI();
		
	}
	
	public void addSlotViews() {
		if(slajd.getSlots().isEmpty()) {
			return;
		}
		for(int i=0;i<slajd.getSlots().size();i++) {
			
			SlotView slotView=new SlotView(slajd.getSlots().get(i));
			this.slotViews.add(slotView);
		}
	}
	
	
	public Slot selectSlot(Point p) {
		
		for(int i=0;i<slotViews.size();i++) {
			
			if(slotViews.get(i).elementAt(p)) {
				slotViews.get(i).getSlot().setSelected(true);
				
				this.selectedSlotView=slotViews.get(i);
				
				return slotViews.get(i).getSlot();
				///returnujem zato sto samo jedan slot moze biti selektovan
					
			}
		}
		//MainFrame.getInstance().getProjectView().updateUI();
		
		return null;
		
	}
	
	
	public Slajd getSlajd() {
		return slajd;
	}

	public void setSlajd(Slajd slajd) {
		this.slajd.removeSubscriber(this);
		this.slajd = slajd;
		slajd.addSubscriber(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SlajdView"+"("+this.getSlajd().toString()+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SlajdView) {
		SlajdView view=(SlajdView)obj;
		
		if(this.slajd.equals(view.getSlajd())) {
			
			
			return true;
		}
	}
			return false;
		
	}

	public List<SlotView> getSlotViews() {
		return slotViews;
	}

	public void setSlotViews(List<SlotView> slotViews) {
		this.slotViews = slotViews;
	}

	public MouseListener getMouseListener() {
		return mouseListener;
	}

	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}

	public SlotView getSelectedSlotView() {
		return selectedSlotView;
	}

	public void setSelectedSlotView(SlotView selectedSlotView) {
		this.selectedSlotView = selectedSlotView;
	}

	@Override
	public void addSubscriber(ISubscriber sub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubscriber(ISubscriber sub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifySubscribers(Object notification) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
