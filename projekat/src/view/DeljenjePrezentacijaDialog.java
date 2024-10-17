package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Prezentacija;
import view.tree.view.ProjectView;

public class DeljenjePrezentacijaDialog extends JDialog{
	
	private String imeProjekta;
	
	
	public DeljenjePrezentacijaDialog(Prezentacija prezentacija) {
		super(MainFrame.getInstance(),"Izaberite jedan projekat!",true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		
		
		Box box=Box.createVerticalBox();
		
		this.setSize(new Dimension(400,400));
		MainFrame.getInstance().getActionManager().getDeljenjePrezentacijeSubmitAction().setPrezentacija(prezentacija);
		for(ProjectView view:MainFrame.getInstance().getProjectViews()) {
			if(view.getProjekat().getChildren().contains(prezentacija)) {
				continue;
			}
			
			JButton btn=new JButton(view.getProjekat().getIme());
			btn.addActionListener(new Listener());
			box.add(btn);
			
			
		}
		
		this.add(BorderLayout.NORTH,new JLabel("Izaberite jedan projekat!"));
		
		JButton save=new JButton("Submit");
		JPanel panel=new JPanel();
		panel.add(box);
		this.add(BorderLayout.CENTER,panel);
		MainFrame.getInstance().getActionManager().getDeljenjePrezentacijeSubmitAction().setDialog(this);
		save.addActionListener(MainFrame.getInstance().getActionManager().getDeljenjePrezentacijeSubmitAction());
		this.add(BorderLayout.SOUTH,save);
		
	
		
	}
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			imeProjekta=arg0.getActionCommand();
			MainFrame.getInstance().getActionManager().getDeljenjePrezentacijeSubmitAction().setImeProjekta(imeProjekta);
					
		}
			
	}
	

}
