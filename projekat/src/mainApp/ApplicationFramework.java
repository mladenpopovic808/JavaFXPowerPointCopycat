package mainApp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.serializationActions.SerializeUtils;
import model.Prezentacija;
import model.Projekat;
import model.Workspace;
import model.nodes.RuNode;
import view.MainFrame;
import view.tree.view.ProjectView;


public class ApplicationFramework {
	
	
	public static void main(String[] args) {
		MainFrame frame=MainFrame.getInstance();
		
		frame.setVisible(true);
		SerializeUtils.loadWorkspace();
		
		
		}
	
	
		
}	
	
