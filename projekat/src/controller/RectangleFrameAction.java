package controller;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class RectangleFrameAction extends MyAbstractAction{

	
	public RectangleFrameAction() {
		putValue(this.NAME,"Rectangle stroke");
		putValue(this.SHORT_DESCRIPTION,"Set rectangle stroke");
		putValue(this.SMALL_ICON,loadIcon("images/frame.jpg"));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		final JDialog dialog=new JDialog();
		JPanel panel=new JPanel(new GridLayout(2,2,10,10));
		dialog.setTitle("Izaberite vrstu okvira");
		//BasicStroke.
		JButton btn1=new JButton("Isprekidana");
		JButton btn2=new JButton("Puna");
		
		panel.add(btn1);
		panel.add(btn2);
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		final PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=e.getActionCommand();
				if(s.equalsIgnoreCase("Isprekidana")) {
					view.getStateManager().getAddRectangleState().setIsprekidana(true);
					view.getStateManager().getAddRectangleState().setStroke(new BasicStroke(view.getStateManager().getAddRectangleState().getDebljina(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
				}
				if(s.equalsIgnoreCase("Puna")) {
					view.getStateManager().getAddRectangleState().setIsprekidana(false);
					view.getStateManager().getAddRectangleState().setStroke(new BasicStroke(view.getStateManager().getAddRectangleState().getDebljina(),BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));			
				}
				
				dialog.setVisible(false);
				
			}
		};
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		
		dialog.add(panel);
		dialog.setSize(new Dimension(300,300));
		dialog.setLocationRelativeTo(MainFrame.getInstance());
		dialog.setVisible(true);
		
	}

}
