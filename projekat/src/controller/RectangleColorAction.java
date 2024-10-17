package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class RectangleColorAction extends MyAbstractAction {
	public RectangleColorAction() {
		putValue(this.NAME,"Rectangle color");
		putValue(this.SHORT_DESCRIPTION,"Set rectangle color");
		putValue(this.SMALL_ICON,loadIcon("images/color.jpg"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		final PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		
		final JDialog dialog=new JDialog();
		dialog.setLocationRelativeTo(MainFrame.getInstance());
		dialog.setSize(new Dimension(300,300));
		dialog.setTitle("Izaberite boju pravougaonika!");
		JButton btnRed=new JButton("Red");
		JButton btnYellow=new JButton("Yellow");
		JButton btnPink=new JButton("Pink");
		JButton btnOrange=new JButton("Orange");
		GridLayout grid=new GridLayout(2,2,10,10);
		JPanel panel=new JPanel(grid);
		panel.add(btnRed);
		panel.add(btnYellow);
		panel.add(btnPink);
		panel.add(btnOrange);
		dialog.add(panel);
		dialog.setVisible(true);
		
		final JLabel label=new JLabel();
		
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(e.getActionCommand());

				if(label.getText().equalsIgnoreCase("Red")) {
					view.getStateManager().getAddRectangleState().setColor(Color.red);
				}else if(label.getText().equalsIgnoreCase("Yellow")) {
					view.getStateManager().getAddRectangleState().setColor(Color.yellow);
				}else if(label.getText().equalsIgnoreCase("Orange")) {
					view.getStateManager().getAddRectangleState().setColor(Color.orange);
				}else if (label.getText().equalsIgnoreCase("Pink")) {
					view.getStateManager().getAddRectangleState().setColor(Color.pink);
				}
				
				dialog.setVisible(false);
			}
		};
		
		btnOrange.addActionListener(listener);
		btnYellow.addActionListener(listener);
		btnPink.addActionListener(listener);
		btnRed.addActionListener(listener);
	
		
	}
	

}
