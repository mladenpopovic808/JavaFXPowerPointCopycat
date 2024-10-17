package controller;


import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import model.Slot;
import model.nodes.SlotType;
import view.MainFrame;
import view.SadrzajMultimedijalnogSlota;
import view.SadrzajTekstualnogSlota;
import view.tree.view.PrezentacijaView;

public class SadrzajSlotaAction extends MyAbstractAction{
	
	private JDialog dialog;
	
	public SadrzajSlotaAction() {
		putValue(this.NAME,"Sadrzaj slota");
		putValue(this.SHORT_DESCRIPTION,"Sadrzaj slota");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
		Slot slot=view.getStateManager().getSelectionState().getSelectedSlot();
		
		
		
		if(slot.getSlotType().equals(SlotType.TEXT)) {
			SadrzajTekstualnogSlota dialog2=new SadrzajTekstualnogSlota(slot);
			dialog=dialog2;
			
			
			
			
			
		}else if(slot.getSlotType().equals(SlotType.MULTIMEDIAL)) {
			SadrzajMultimedijalnogSlota dialog2=new SadrzajMultimedijalnogSlota(slot);
			dialog=dialog2;
			
		}
		dialog.setVisible(true);
		
		
		
		
	}
	private class InfoDialog extends JDialog{
		 
		
		
		 public InfoDialog() {
			 super(MainFrame.getInstance(),"Prikaz sadrzaja slota",true);
			 this.setLocationRelativeTo(MainFrame.getInstance());
			 
			
			 this.setSize(500, 500);
			 
			
			 

			
			
			 	
		}
		
	}
	
	
	

}










