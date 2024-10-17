package view.tree.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import commands.CommandManager;
import controller.ISubscriber;
import controller.state.StateManager;
import model.Prezentacija;
import model.Slajd;
import model.nodes.RuNode;
import view.MainFrame;

public class PrezentacijaView extends JPanel implements ISubscriber{
	
	private Prezentacija prezentacija;
	private JLabel labelAutor;
	private List<SlajdView> listaSlajdViewova;
	private Box slajdBoxRight;
	private Box slajdBoxLeft;
	private StateManager stateManager;
	private CommandManager commandManager;
	private JScrollPane leftScrollPane;
	private JScrollPane rightScrollPane;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JToolBar toolbar;
	private JPanel mainPanel;
	private SlajdShowPanel slajdShowPanel;
	int obrisani=0;
	
	
	public PrezentacijaView(Prezentacija selektovanaPrezentacija) {
		super();
		MainFrame.getInstance().getProjectView().getListaPrezViewova().add(this);
		this.prezentacija = selektovanaPrezentacija;
		this.prezentacija.addSubscriber(this);
		stateManager=new StateManager();
		slajdShowPanel=new SlajdShowPanel(selektovanaPrezentacija);
		commandManager=new CommandManager();
		listaSlajdViewova=new ArrayList<SlajdView>();
		initGUI();
		setListaSlajdViewova();
		
		
	}
	private void initGUI() {
		
		labelAutor=new JLabel();
		slajdBoxRight=Box.createVerticalBox();
		if((prezentacija.getAutor()!=null) && (prezentacija.getAutor()!="")) {
			labelAutor.setText(prezentacija.getAutor());
		}else {
			labelAutor.setText("");
		}
		toolbar=new JToolBar(JToolBar.HORIZONTAL);
			
			toolbar.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
			toolbar.addSeparator(new Dimension(40,0));
			toolbar.add(MainFrame.getInstance().getActionManager().getDeljenjePrezentacijeAction());
			
			
			toolbar.addSeparator(new Dimension(150,0));
			toolbar.add(MainFrame.getInstance().getActionManager().getSadrzajSlotaAction());
			MainFrame.getInstance().getActionManager().getSadrzajSlotaAction().setEnabled(false);
			toolbar.addSeparator(new Dimension(100,0));
			toolbar.add(MainFrame.getInstance().getActionManager().getSelectionStateAction());
			toolbar.add(MainFrame.getInstance().getActionManager().getMoveSlotStateAction());
			
			toolbar.add(MainFrame.getInstance().getActionManager().getAddRectangleAction());
			toolbar.add(MainFrame.getInstance().getActionManager().getSlotTypeAction());
			toolbar.add(MainFrame.getInstance().getActionManager().getDeleteRectangleAction());
			
			toolbar.add(MainFrame.getInstance().getActionManager().getRectangleFrameAction());
			toolbar.add(MainFrame.getInstance().getActionManager().getDebljinaLinijeAction());
			toolbar.add(MainFrame.getInstance().getActionManager().getRectangleColorAction());
			toolbar.setFloatable(false);
			toolbar.addSeparator(new Dimension(20,0));
		
		mainPanel=new JPanel(new BorderLayout());
		
		this.setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		topPanel.add(labelAutor);
		
		
		//this.add(BorderLayout.NORTH,topPanel);
		mainPanel.add(BorderLayout.NORTH,topPanel);
		
		rightPanel=new JPanel();
		slajdBoxRight=Box.createVerticalBox();
		rightPanel.add(slajdBoxRight);
		rightScrollPane=new JScrollPane(rightPanel);
		rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		///Left Panel
		leftPanel=new JPanel();
		slajdBoxLeft=Box.createVerticalBox();
		leftPanel.add(slajdBoxLeft);
		leftScrollPane=new JScrollPane(leftPanel);
		leftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftScrollPane,rightScrollPane);
		split.setDividerLocation(250);
		
		//this.add(BorderLayout.CENTER,split);
			mainPanel.add(BorderLayout.CENTER,split);
	
		this.add(BorderLayout.NORTH,toolbar);
		this.add(BorderLayout.CENTER,mainPanel);
		
		
	}
	public PrezentacijaView() {
		
	}

	public Prezentacija getPrezentacija() {  
		
		return prezentacija;
	}

	public void setPrezentacija(Prezentacija selektovanaPrezentacija) {
		this.prezentacija.removeSubscriber(this);
		this.prezentacija = selektovanaPrezentacija;
		this.prezentacija.addSubscriber(this);
		this.update(selektovanaPrezentacija); /// PROMENIO SI PREZENTACIJU,PA ZELIS DA SI SE PRIKAZE VIEW OD TE PREZENTACIJE
	}
	
	
	
	@Override
	public void update(Object notification) {
		
		if(notification instanceof Prezentacija) {
			
			addAllSlajdView();
			

			
		}if(notification instanceof Slajd) { 
			
			Slajd slajd=(Slajd)notification;
			if(prezentacija.getChildren().contains(slajd)) {
				
				addSlajdView(slajd);
				slajdShowPanel.addSlajdView(slajd);
				
				
				
				
				//slajdShowPanel.updateUI();
				
		}else {///Ako nas projekat ne sadrzi prezentaciju,znaci da je obrisana
			
			
			for(int i=0;i<listaSlajdViewova.size();i++) {
				
				
				
				if(listaSlajdViewova.get(i).getModel()==slajd) {
					
					
					slajdBoxRight.remove(i);
					slajdBoxLeft.remove(i);
					slajdBoxRight.validate();
					slajdBoxLeft.validate();
					
					
					//slajd.setRedniBroj(i);
					
					
					listaSlajdViewova.remove(listaSlajdViewova.get(i));
					
					slajdShowPanel.removeSlajdView(i);
				
				}
			
			}
			
			slajdShowPanel.updateUI();
			MainFrame.getInstance().getProjectView().repaint();
			updateUI();
			

				
			}
		}
		
		if(notification instanceof String) {
			
			String str=(String)notification;
			if(str.equalsIgnoreCase("promenaAutora")) {
				
				this.labelAutor.setText(prezentacija.getAutor());
				
				
			}
		}

	}
	
	public void setListaSlajdViewova() {
		
		listaSlajdViewova=new ArrayList<SlajdView>();
		for(RuNode ru:prezentacija.getChildren()) {
			Slajd p=(Slajd)ru;
			
			addSlajdView(p);

		}
	
	}
	public void addSlajdView(Slajd s) {
		 
		SlajdView view=new SlajdView(s);
		
		listaSlajdViewova.add(s.getRedniBroj(),view);
		
//		if(listaSlajdViewova.size()<s.getRedniBroj()-1 || listaSlajdViewova.size()>s.getRedniBroj()-1) {
//			listaSlajdViewova.add(listaSlajdViewova.size(),view);
//		}else {
//			listaSlajdViewova.add(s.getRedniBroj()-1,view);
//		}

		
		
		
		slajdBoxRight.add(view,s.getRedniBroj());
		
		
		
		
		SlajdView view2=new SlajdView(s);
		
		view2.setPreferredSize(new Dimension(200,200));
		view2.removeMouseListener(view2.getMouseListener());
		view2.removeMouseMotionListener((MouseMotionListener)view.getMouseListener());
		slajdBoxLeft.add(view2,s.getRedniBroj());
		
		
		
		
		MainFrame.getInstance().getProjectView().repaint();
		
	}
	public void addAllSlajdView() {
		
		slajdBoxRight.removeAll();
		
	
		//listaSlajdViewova=new ArrayList<SlajdView>();
		
		for(SlajdView view: listaSlajdViewova) {

			
			slajdBoxRight.add(view);
			//slajdBoxRight.add(Box.createVerticalStrut(20));
			
			
		}
		slajdBoxRight.revalidate();
		rightPanel.revalidate();
		
	}
	
	
	@Override
	public String toString() {
		
		return "Prezentacija view: "+prezentacija.getIme();
	}
	public JLabel getLabelAutor() {
		return labelAutor;
	}
	public void setLabelAutor(JLabel labelAutor) {
		this.labelAutor = labelAutor;
	}
	public List<SlajdView> getListaSlajdViewova() {
		return listaSlajdViewova;
	}
	public void setListaSlajdViewova(List<SlajdView> listaSlajdViewova) {
		this.listaSlajdViewova = listaSlajdViewova;
	}
	public Box getSlajdBoxRight() {
		return slajdBoxRight;
	}
	public void setSlajdBoxRight(Box slajdBoxRight) {
		this.slajdBoxRight = slajdBoxRight;
	}
	public Box getSlajdBoxLeft() {
		return slajdBoxLeft;
	}
	public void setSlajdBoxLeft(Box slajdBoxLeft) {
		this.slajdBoxLeft = slajdBoxLeft;
	}
	public StateManager getStateManager() {
		return stateManager;
	}
	public SlajdShowPanel getSlajdShowPanel() {
		return slajdShowPanel;
	}
	public void setSlajdShowPanel(SlajdShowPanel slajdShowPanel) {
		this.slajdShowPanel = slajdShowPanel;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JToolBar getToolbar() {
		return toolbar;
	}
	public CommandManager getCommandManager() {
		return commandManager;
	}
	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
	


	
	
}





