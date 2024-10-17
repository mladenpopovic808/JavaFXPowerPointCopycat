package controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import view.MainFrame;



public class InfoAction extends MyAbstractAction {
		InfoDialog dialog; ///Da se ne bi pravili novi dijalozi pritiskom na dugme "MyInfo",pravim slican sablon kao singleton.

	 public InfoAction() {
		putValue(AbstractAction.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		
		putValue(AbstractAction.SMALL_ICON, loadIcon("images/info_25x25.png"));
		
		putValue(AbstractAction.NAME,"MyInfo");
		
		putValue(AbstractAction.SHORT_DESCRIPTION,"Student Info");
		
	}
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(dialog==null) {
			dialog=new InfoDialog();
		}
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
		
	}
	
	private class InfoDialog extends JDialog{
		 
		 public InfoDialog() {
			 super(MainFrame.getInstance(),"Informacije o studentu",false);
			 this.setLocationRelativeTo(MainFrame.getInstance());
			 JLabel label1=new JLabel("Mladen Popovic");
			 JLabel label2=new JLabel("Racunarske nauke");
			 JLabel label3=new JLabel("mpopovic9720rn");
			 this.setSize(500, 500);
			 
			 Box box=Box.createVerticalBox();
			 box.add(label1);
			 box.add(Box.createVerticalStrut(15));
			 box.add(label2);
			 box.add(Box.createVerticalStrut(15));
			 box.add(label3);
			 this.add(box);
			 
			 ImagePanel panel = new ImagePanel(new ImageIcon("images/student_300x300.jpg").getImage());
			 box.add(panel);
			
			 	
		}
		
	}
	
	private class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(Image img) {
		    this.img = img;
		    
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/(2),
		    				 (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
		  }
	}

}
