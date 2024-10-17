package controller.slotContent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MyAbstractAction;
import model.nodes.SlotType;
import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class SlotTypeAction extends MyAbstractAction{

	public SlotTypeAction() {
		putValue(this.NAME,"Slot Type");
		putValue(this.SHORT_DESCRIPTION,"Slot Type");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		final PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		
		final JDialog dialog=new JDialog();
		dialog.setLocationRelativeTo(MainFrame.getInstance());
		dialog.setSize(new Dimension(300,300));
		dialog.setTitle("Izaberite tip slota!");
		
		JButton btnText=new JButton("Text");
		JButton btnMultimedial=new JButton("Multimedial");
		GridLayout grid=new GridLayout(2,2,10,10);
		JPanel panel=new JPanel(grid);
		
		panel.add(btnText);
		panel.add(btnMultimedial);
		dialog.add(panel);
		dialog.setVisible(true);
		
		final JLabel label=new JLabel();
		
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(e.getActionCommand());

				if(label.getText().equalsIgnoreCase("Text")) {
					view.getStateManager().getAddRectangleState().setSlotType(SlotType.TEXT);
				}else if(label.getText().equalsIgnoreCase("Multimedial")) {
					view.getStateManager().getAddRectangleState().setSlotType(SlotType.MULTIMEDIAL);
				
			}
				dialog.setVisible(false);
				
		};
		};
		
		
		btnText.addActionListener(listener);
		btnMultimedial.addActionListener(listener);
	
		
	
		
	}

}
