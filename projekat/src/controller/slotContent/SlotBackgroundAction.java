package controller.slotContent;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import controller.MyAbstractAction;
import model.Slot;
import view.MainFrame;
import view.SadrzajMultimedijalnogSlota;
import view.tree.error.ErrorHandler;
import view.tree.view.PrezentacijaView;

public class SlotBackgroundAction extends MyAbstractAction{
	
	
	private SadrzajMultimedijalnogSlota dialog;
	private Slot slot;
	
	
	public SlotBackgroundAction() {
		putValue(this.NAME, "Slot background");
		putValue(this.SHORT_DESCRIPTION, "Slot background");
		putValue(this.SMALL_ICON,loadIcon("images/background.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
		
		Slot s=p.getStateManager().getSelectionState().getSelectedSlot();
		if(!s.isSelected()) {
			ErrorHandler.getInstance().generateError(ErrorHandler.NO_SLOT_SELECTED);
			return;
		}
		
		JFileChooser fileChooser=new JFileChooser();
		String fileName;
		
		fileChooser.showOpenDialog(MainFrame.getInstance());
		
		if(fileChooser.getSelectedFile()==null) {
			return;
		}
		
		fileName=fileChooser.getSelectedFile().toString();
		String sub=fileName.substring(fileName.lastIndexOf(".")+1);
		
		 if(!sub.equals("jpg") && !sub.equals("png")) {
				ErrorHandler.getInstance().generateError(ErrorHandler.PICTURE_NOT_VALID);
		}
		
		else {
			dialog.setProbnaPutanja(fileName);
			dialog.getPanel().repaint();
			

		}
		
	}

	public JDialog getDialog() {
		return dialog;
	}

	public void setDialog(SadrzajMultimedijalnogSlota dialog) {
		this.dialog = dialog;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	
	
}
