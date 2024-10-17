package controller;



import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class MyAbstractAction extends AbstractAction{
	
	public Icon loadIcon(String fileName) {
		
		
		Icon icon;
		
		icon=new ImageIcon(fileName);
			
		
		
		
		
		
		return icon;
		
	}

	

}
