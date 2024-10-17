package view.tree.controller;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.Workspace;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer{

	public RuTreeCellRenderer() {
		
		
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		 super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus); ///Crta cvor
	
		 if(value instanceof Workspace) {
			 Icon icon=new ImageIcon("images/folder_25x25.png");
			 
			 setIcon(icon);

			 
		 }else if(value instanceof Projekat) {
			 
			 Icon icon=new ImageIcon("images/project_25x25.png");
			 setIcon(icon);
			 
		 }else if(value instanceof Prezentacija) {
			 Prezentacija p=(Prezentacija)value;
			 if(p.getProjektiUKomeSeNalazim().size()>1) {
				 Icon icon=new ImageIcon("images/share.jpg");
				 setIcon(icon);
				 
			 }else {
				 Icon icon=new ImageIcon("images/prezentacija_25x25.jpg");
				 setIcon(icon);
			 }
			
			 
			 
		 }else if(value instanceof Slajd) {
			 Icon icon=new ImageIcon("images/slajd_25x25.png");
			 setIcon(icon);
			 
		 }
		 
		 
		 return this;
	}
	
	
	

}
