package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import commands.CommandManager;
import controller.ActionManager;
import controller.IPublisher;
import controller.ISubscriber;
import controller.serializationActions.MyWindowListener;
import model.Projekat;
import view.tree.error.ErrorHandler;
import view.tree.error.MyError;
import view.tree.model.TreeModel;
import view.tree.view.MyTree;
import view.tree.view.PrezentacijaView;
import view.tree.view.ProjectView;
import view.tree.view.SlajdShowPanel;




public class MainFrame extends JFrame implements ISubscriber{
	
	private static MainFrame instance=null;
	private ActionManager actionManager;
	private JToolBar jToolBar;
	private Panel mainPanel;
	private Panel workSpacePanel;
	private JScrollPane treeScrollPane;
	private JMenuBar jMenuBar;
	private MyTree tree;
	private TreeModel treeModel;
	private CommandManager commandManager;
	
	private ProjectView projectView;
	private List<ProjectView>projectViews;
	private SlajdShowPanel slajdShowPanel;
	
	
	private MainFrame(IPublisher publisher) {
		publisher.addSubscriber(this);
		
	}
	@Override
	public void update(Object notification) { 
		if(notification instanceof MyError) {
			MyError error=(MyError)notification;
			JOptionPane.showMessageDialog(this, error.getMessage(),"Greska",JOptionPane.ERROR_MESSAGE);
		}
	}
	

	
	private void initialise() {
	this.addWindowListener(new MyWindowListener());
	actionManager=new ActionManager();
	jToolBar=new MyToolBar();
	mainPanel=new Panel(new BorderLayout());
    jMenuBar=new MyMenuBar();
	workSpacePanel=new Panel(new BorderLayout());
		workSpacePanel.setBackground(Color.LIGHT_GRAY);
		
	projectViews=new ArrayList<ProjectView>();	
	commandManager=new CommandManager();
	
		
	}
	private void initialiseTree() {
		tree=new MyTree();
		treeModel=new TreeModel();
		tree.setModel(treeModel);
		
		
		
		
	}
	
	private void initialiseGUI() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		int widht=d.width;
		int height=d.height;
		this.setSize(widht/2+200,height/2+200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		mainPanel.add(BorderLayout.NORTH,jToolBar);
		
		JPanel treePanel=new JPanel();
		treePanel.add(tree);
		
		treeScrollPane=new JScrollPane(tree);
		treeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		treeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treeScrollPane,workSpacePanel);
		
		splitPane.setDividerLocation(250);
		splitPane.setOneTouchExpandable(true);
		mainPanel.add(splitPane);
		
		
		this.setJMenuBar(new MyMenuBar());

	}
	
	public void reinitializeGui() {
		
		this.add(mainPanel);
		mainPanel.add(BorderLayout.NORTH,jToolBar);
		
		JPanel treePanel=new JPanel();
		treePanel.add(tree);
		
		treeScrollPane=new JScrollPane(tree);
		treeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		treeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treeScrollPane,workSpacePanel);
		
		splitPane.setDividerLocation(250);
		splitPane.setOneTouchExpandable(true);
		mainPanel.add(splitPane);
		
		
		this.setJMenuBar(new MyMenuBar());
		
	}
	public static MainFrame getInstance() {
		if(instance==null) {
			instance=new MainFrame(ErrorHandler.getInstance());
			instance.initialise();
			instance.initialiseTree();
			instance.initialiseGUI();
	}
		return instance;
	}
	
	
	///////////////////////////////////////////////////////////
	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}


	public JToolBar getjToolBar() {
		return jToolBar;
	}

	public void setjToolBar(JToolBar jToolBar) {
		this.jToolBar = jToolBar;
	}
	public Panel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(Panel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public Panel getWorkSpacePanel() {
		return workSpacePanel;
	}
	public void setWorkSpacePanel(Panel workSpacePanel) {
		this.workSpacePanel = workSpacePanel;
	}
	public JScrollPane getTreeScrollPane() {
		return treeScrollPane;
	}
	public void setTreeScrollPane(JScrollPane treeScrollPane) {
		this.treeScrollPane = treeScrollPane;
	}
	public MyTree getTree() {
		return tree;
	}
	public void setTree(MyTree tree) {
		this.tree = tree;
	}
	
	
	public ProjectView getProjectView() {
		if(this.projectView==null) {
			//projectView=new ProjectView((Projekat)tree.getSelectionPath().getLastPathComponent());
			Projekat p=(Projekat)tree.getLastSelectedPathComponent();
			for(ProjectView view:projectViews) {
				if(view.getProjekat().equals(p)) {
					projectView=view;
					break;
				}
			}
			
		}
		return projectView;
	}
	public void setProjectView(Projekat p) {
		for (ProjectView projectView : projectViews) {
			if(projectView.getProjekat().equals(p)) {
				this.projectView=projectView;
				workSpacePanel.removeAll();
				workSpacePanel.add(BorderLayout.CENTER,projectView);
				
				//SwingUtilities.updateComponentTreeUI(workSpacePanel);
				
				workSpacePanel.repaint();
				
				return;
			}
		}
	}
	public List<ProjectView> getProjectViews() {
		return projectViews;
	}
	public void setProjectViews(List<ProjectView> projectViews) {
		this.projectViews = projectViews;
	}
	public void setjMenuBar() {
		this.setJMenuBar(jMenuBar);
	}
	
	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}
	public void setSlajdShowPanel(PrezentacijaView view) {
		
		if(view==null) {
			slajdShowPanel=new SlajdShowPanel(null);
			return;
		}
	
		
	}
	public SlajdShowPanel getSlajdShowPanel() {
		return slajdShowPanel;
	}
	public CommandManager getCommandManager() {
		return commandManager;
	}
	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
	
	
	
	
}




