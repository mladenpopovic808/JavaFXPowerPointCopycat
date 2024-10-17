package controller.serializationActions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import controller.MyAbstractAction;
import model.Prezentacija;
import model.Projekat;

import serialization.PresentationFileFilter;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class OpenPresentationAction extends MyAbstractAction{

	public OpenPresentationAction() {
		putValue(this.NAME, "Open presentation");
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			JFileChooser jfc = new JFileChooser();
			jfc.setFileFilter(new PresentationFileFilter());
			Projekat projekat=null;
			
			Object o=MainFrame.getInstance().getTree().getLastSelectedPathComponent();
			if(o!=null && o instanceof Projekat) {
				projekat=(Projekat)o;
				
			}else {
				ErrorHandler.getInstance().generateError(ErrorHandler.NO_PROJECT_AVAILABLE);
				return;
			}
			
			
			if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
				
				try {
					ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
					  
					Prezentacija prez=null;
					try {
						prez = (Prezentacija) os.readObject();
						
					} catch (Exception e) {
						ErrorHandler.getInstance().generateError(ErrorHandler.FILE_NOT_VALID);
						return;
					}
					prez.readResolve();
					
	
					projekat.add((MutableTreeNode)prez);
					
		    
					     SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					     
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				
		

	}
		}
		
	}
	
	


