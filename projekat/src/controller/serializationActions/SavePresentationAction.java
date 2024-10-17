package controller.serializationActions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import controller.MyAbstractAction;
import model.Prezentacija;
import serialization.PresentationFileFilter;
import view.MainFrame;
import view.tree.error.ErrorHandler;
import view.tree.view.PrezentacijaView;

public class SavePresentationAction extends MyAbstractAction{
	
	public SavePresentationAction() {
		putValue(this.NAME, "Save presentation");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileFilter(new PresentationFileFilter());
		try {
			Prezentacija prezentacija=(Prezentacija)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
//			int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
//			PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
//			Prezentacija prezentacija=p.getPrezentacija();										///OVO CEMO DA KORISTIMO UKOLIKO UZIMAMO PREZENTACIJU IZ PROJECTVIEWA TJ IZ TABA
			
			File projectFile=prezentacija.getFile();
			
			if (!prezentacija.isChanged()){ 
				
				return;
			}
			
			if (prezentacija.getFile()==null){ /// ako ga cuvamo prvi put
				
			         if(fileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			                   projectFile=fileChooser.getSelectedFile();    
			                   prezentacija.setFile(projectFile);
			        	 
			         }else{
			        	return; 
			         }     
			}        
			
		    ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(projectFile));
				os.writeObject(prezentacija);
				prezentacija.setFile(projectFile);
				prezentacija.setChanged(false);
				os.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		 catch (Exception e) {
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);;
		}
	}
}
