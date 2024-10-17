package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;


import model.Slot;



public class SadrzajMultimedijalnogSlota extends JDialog{
	
	private Slot slot;
	private JToolBar toolbar;
	private Box box;
	private JMenuBar jMenuBar;
	private JMenu itemFile=new JMenu("Izmeni");
	private ImagePanel panel;
	private JButton save;
	private String probnaPutanja; /// kada se klikne save,ova putanja se setuje slotu
	
	
	
	public SadrzajMultimedijalnogSlota(final Slot slot) {
		super(MainFrame.getInstance(),"Prikaz multimedijalnog slota",true);
		 panel = new ImagePanel();
		this.slot=slot;
		toolbar=new JToolBar();
		toolbar.setFloatable(false);
		jMenuBar=new JMenuBar();
		probnaPutanja=slot.getPutanjaDoSlike();
		
		this.setSize(new Dimension(500,500));
		this.setLocationRelativeTo(MainFrame.getInstance());
		toolbar.add(MainFrame.getInstance().getActionManager().getSlotBackgroundAction());
		
		this.setJMenuBar(jMenuBar);
		save=new JButton("Save");
		
		itemFile.add(MainFrame.getInstance().getActionManager().getSlotBackgroundAction());
		jMenuBar.add(itemFile);
		panel.setSize(new Dimension(250,250));
		JPanel panel2=new JPanel();
		panel2.setBackground(Color.black);
		panel2.setSize(new Dimension(250,250));
		Box box=Box.createVerticalBox();
		MainFrame.getInstance().getActionManager().getSlotBackgroundAction().setDialog(this);
		 
		 box.add(panel);
		 this.add(panel);
		
		 save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				slot.setPutanjaDoSlike(probnaPutanja);
				
			}
		});
		 
		 this.add(BorderLayout.SOUTH,save);
		
	}

	public class ImagePanel extends JPanel {

		  private Image img;
		  

		  public void paintComponent(Graphics g) {
			  
			  img =new ImageIcon(probnaPutanja).getImage();
			 
		    
		    g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
		   
		  }
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public JToolBar getToolbar() {
		return toolbar;
	}

	public void setToolbar(JToolBar toolbar) {
		this.toolbar = toolbar;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}


	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}


	public void setjMenuBar(JMenuBar jMenuBar) {
		this.jMenuBar = jMenuBar;
	}


	public JMenu getItemFile() {
		return itemFile;
	}


	public void setItemFile(JMenu itemFile) {
		this.itemFile = itemFile;
	}


	public ImagePanel getPanel() {
		return panel;
	}


	public void setPanel(ImagePanel panel) {
		this.panel = panel;
	}

	public String getProbnaPutanja() {
		return probnaPutanja;
	}

	public void setProbnaPutanja(String probnaPutanja) {
		this.probnaPutanja = probnaPutanja;
	}
	
	
	


			
			 
			
			 
	
}
