package controller.serializationActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Prezentacija;
import model.Projekat;
import model.Workspace;
import model.nodes.RuNode;
import view.MainFrame;
import view.tree.view.ProjectView;

public class SerializeUtils {
	
	
	public static void loadWorkspace() {
		File file=new File(System.getProperty("user.dir")+"/"+"workspace.txt"); // lokacija gde je sacuvan projekat
		if(!file.exists()) { /// ako se prvi put pokrece program,i nije se napravio fajl putem windowListenera
			return;
		}
		
		int n = JOptionPane.showConfirmDialog(null,"Da li zelite da ucitate prethodni kontekst programa?","Upit",JOptionPane.YES_NO_OPTION);
		
		if(n==JOptionPane.YES_OPTION) {
			Workspace w=(Workspace)MainFrame.getInstance().getTree().getModel().getRoot(); ///Novi workspace na koji ces dodavati projekte
			
			try {
				boolean first=true; /// zelim prvi projekat da prikazem
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
				
				String line = "";
				while ((line = br.readLine()) != null) {
					
					ObjectInputStream os = new ObjectInputStream(new FileInputStream(line));
					Projekat p;
					
					try {
						 p=(Projekat)os.readObject();
						 p.readResolve();
						 
						 ProjectView projectView=new ProjectView(p);
						 MainFrame.getInstance().getProjectViews().add(projectView);
						 
						if(first==true) {
							
							MainFrame.getInstance().setProjectView(p); /// zelim prvi projekat da prikazem
							first=false;
						}
						 
						 for(RuNode node:p.getChildren()) {
							 Prezentacija prez=(Prezentacija)node;
							 prez.readResolve();
							 projectView.addPrezentacijaView(prez); 
							
						 }
	 
						 w.add(p);
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}		
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					os.close();
		
				}
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
	}

}
