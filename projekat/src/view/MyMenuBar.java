package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class MyMenuBar extends JMenuBar {
	
	private JMenu itemFile;
	private JMenu itemHelp;
	
	public MyMenuBar() {
		initalise();
		this.add(itemFile);
		this.add(itemHelp);
		
		itemFile.add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		itemFile.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		
		itemFile.add(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
		itemFile.addSeparator();
		itemFile.add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());
		itemFile.addSeparator();
		itemFile.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
		
		
	}
	
	private void initalise() {
		itemFile=new JMenu("File");
		itemHelp=new JMenu("Help");
		
	}
	
	
    ////////////////////////////////////////////
	public JMenu getItemFile() {
		return itemFile;
	}

	public void setItemFile(JMenu itemFile) {
		this.itemFile = itemFile;
	}

	public JMenu getItemHelp() {
		return itemHelp;
	}

	public void setItemHelp(JMenu itemHelp) {
		this.itemHelp = itemHelp;
	}

	
	

}
