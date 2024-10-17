package controller.serializationActions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import controller.MyAbstractAction;
import model.Prezentacija;
import model.Projekat;
import model.Workspace;
import serialization.MyFileFilter;
import view.MainFrame;
import view.tree.error.ErrorHandler;
import view.tree.view.ProjectView;

public class OpenProjectAction extends MyAbstractAction{

	public OpenProjectAction() {
		putValue(this.NAME,"Open Project");
		putValue(this.SHORT_DESCRIPTION,"Open Project");
		
	}
	
	///DESERIJALIZACIJA
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new MyFileFilter());
		
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Projekat p=null;
				try {
					p = (Projekat) os.readObject();
					
				} catch (Exception e) {
					
					ErrorHandler.getInstance().generateError(ErrorHandler.FILE_NOT_VALID);
					os.close();
					return;
				}
				p.readResolve();
				Workspace w=(Workspace)MainFrame.getInstance().getTree().getModel().getRoot();
				ProjectView projectView=new ProjectView(p);
				
				MainFrame.getInstance().getProjectViews().add(projectView);
				MainFrame.getInstance().setProjectView(p);
				w.add(p);

			  for (int i=0;i<p.getChildCount();i++){
				  Prezentacija prezentacija=(Prezentacija)p.getChildAt(i);
				  	prezentacija.readResolve();
				  	
				  	MainFrame.getInstance().getProjectView().addPrezentacijaView(prezentacija);
				   
				     ///projectView.getListaPrezViewova().add(prezView); ubacio sam u konstruktor prezViewa
				     
				     
				     try {
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				
				     
				     SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				}
			  os.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
		

}
	}
}
