package controller;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.Prezentacija;
import view.MainFrame;
import view.tree.error.ErrorHandler;

public class ChangeBackgroundAction extends MyAbstractAction{
		private ChangeBackgroundDialog dialog=null;
	
	 public ChangeBackgroundAction() {
		putValue(this.NAME,"Promeni pozadinu prezentacije");
		putValue(this.SHORT_DESCRIPTION,"Promeni pozadinu na prezentaciji");
		putValue(this.SMALL_ICON,loadIcon("images/pozadina_25x25.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getTree().getLastSelectedPathComponent() instanceof Prezentacija) {
		if(dialog==null) {
			
			dialog=new ChangeBackgroundDialog();
		}
		dialog.setVisible(true);
	}else {
		ErrorHandler.getInstance().generateError(ErrorHandler.NO_PRESENTATION_AVAILABLE);
	}
	}
	
	private class ChangeBackgroundDialog extends JDialog{
		
		public ChangeBackgroundDialog() {
			
			super(MainFrame.getInstance(),"Promeni autora",false);
			 this.setLocationRelativeTo(MainFrame.getInstance());
			 this.setSize(450,200);
			 
			 JButton browseButton=new JButton("Browse");
			 JLabel label=new JLabel("Unesite putanju do slike");
			 
			 browseButton.addActionListener(new addBackgroundController(label,this));
			 
			
			 JPanel mainPanel=new JPanel(new BorderLayout());
			 
			 Box boxH=Box.createHorizontalBox();
			 boxH.add(label);
			 boxH.add(Box.createHorizontalStrut(100));
			 boxH.add(browseButton);
			 
			 Box boxV=Box.createVerticalBox();
			 boxV.add(boxH);
			 boxV.add(Box.createVerticalStrut(100));
			
			 mainPanel.add(BorderLayout.NORTH,boxH);
			 this.add(mainPanel);
			 JPanel botPanel=new JPanel();
			 //botPanel.add(confirm);
			 mainPanel.add(BorderLayout.SOUTH,botPanel);
			
			 
		}
			
	private class addBackgroundController implements ActionListener{
		
		private JDialog dialog;
		public addBackgroundController(JLabel label,JDialog dialog) {
			this.dialog=dialog;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Prezentacija p;
			
					 p=(Prezentacija)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
					 
					 JFileChooser fileChooser=new JFileChooser();
						String fileName;
						
						fileChooser.showOpenDialog(MainFrame.getInstance().getjToolBar());
						
						if(fileChooser.getSelectedFile()==null) {
							return;
						}
						
						fileName=fileChooser.getSelectedFile().toString();
						String sub=fileName.substring(fileName.lastIndexOf(".")+1);
						
						 if(!sub.equals("jpg") && !sub.equals("png")) {
								ErrorHandler.getInstance().generateError(ErrorHandler.PICTURE_NOT_VALID);
						}
						
						else {
							p.setPutanjaDoSlike(fileName);
							dialog.setVisible(false);
	
						}
 
			} 
			
		}
		
	}
	
		
		
	
}
