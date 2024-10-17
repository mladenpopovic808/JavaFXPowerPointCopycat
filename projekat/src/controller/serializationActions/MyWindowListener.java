package controller.serializationActions;

import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import model.Projekat;
import model.Workspace;
import model.nodes.RuNode;
import serialization.PresentationFileFilter;
import view.MainFrame;

public class MyWindowListener implements java.awt.event.WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileFilter(new PresentationFileFilter());
	
		BufferedWriter br;
		Workspace w=(Workspace)MainFrame.getInstance().getTree().getModel().getRoot();
		File file=new File(System.getProperty("user.dir")+"/"+"workspace.txt"); /// Cuva se u folderu gde je sacuvan projekat
		
		if(!w.isChanged()) {
			return;
		}
			
			try {
				br=new BufferedWriter(new FileWriter(file,false));
				for(RuNode node:w.getChildren()) {
					Projekat projekat=(Projekat)node;
					
					if(projekat.getFile()==null) {
						saveProject(projekat,w.getIndex(projekat));
						
					}
					
						br.write(projekat.getFile().getAbsolutePath()+"\n");
				}

				br.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public void saveProject(Projekat projekat,int index){
		ObjectOutputStream os;
		try {
			File projectFile=new File("fileProject"+index);
			
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(projekat);
			projekat.setFile(projectFile);
			projekat.setChanged(false);
			os.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
			
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
