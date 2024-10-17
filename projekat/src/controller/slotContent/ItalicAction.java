package controller.slotContent;

import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


import controller.MyAbstractAction;
import model.Slot;
import view.SadrzajTekstualnogSlota;

public class ItalicAction extends MyAbstractAction{

	private Slot slot;
	private SadrzajTekstualnogSlota dialog;
	
	public ItalicAction() {
		putValue(this.NAME, "Italic");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextPane pane=dialog.getTextPane();
		
		SimpleAttributeSet attr = new SimpleAttributeSet();

        StyleConstants.setItalic(attr, true);
        if(pane.getCharacterAttributes().containsAttributes(attr)){
            StyleConstants.setItalic(attr, false);
           pane.setCharacterAttributes(attr, false);
        }else{
           pane.setCharacterAttributes(attr, false);
        }
		
		
	}


	public Slot getSlot() {
		return slot;
	}


	public void setSlot(Slot slot) {
		this.slot = slot;
	}


	public SadrzajTekstualnogSlota getDialog() {
		return dialog;
	}


	public void setDialog(SadrzajTekstualnogSlota dialog) {
		this.dialog = dialog;
	}


	
	
	

}
