package controller.serializationActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import controller.MyAbstractAction;
import model.Projekat;
import serialization.MyFileFilter;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class SaveProjectAction extends MyAbstractAction {
	
	public SaveProjectAction() {
		putValue(this.NAME,"Save Project");
		putValue(this.SHORT_DESCRIPTION,"Save Project");
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	}
	
	///SERIJALIZACIJA
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileFilter(new MyFileFilter());
		try {
			
			Projekat projekat=(Projekat)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
								///Moze i MainFrame.getInstance().getProjectView().getProjekat() --- ovo vraca projekat od otvorenog projektViewa
			File projectFile=projekat.getFile();
			
			if (!projekat.isChanged()){ /// ako projekat nije promenjen,ne zelimo da ga za dzabe serijalizujemo
				
				return;
			}
			
			if (projekat.getFile()==null){ /// ako ga cuvamo prvi put
				
			         if(fileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			                   projectFile=fileChooser.getSelectedFile();    
			                   projekat.setFile(projectFile);
			        	 
			         }else{
			        	return; 
			         }     
			}     
		    ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				os.writeObject(projekat);
				projekat.setFile(projectFile);
				projekat.setChanged(false);
				os.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		 catch (Exception e) {
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PROJECT_AVAILABLE);
		}
	}
	
}
