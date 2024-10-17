package view.tree.view.slotContent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Slot;
import model.nodes.SlotType;
import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class TextSlotHandler extends SlotHandler implements Serializable{

	public TextSlotHandler(Slot slot) {
		super(slot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readContent() {
		
		
		return this.getSlot().getText(); 
		
	}
	

	@Override
	public void setContent(String str) {
		
		this.getSlot().setText(str); 
		
		
	}

	@Override
	public void format() {
		
		
	}

	@Override
	public void paint(Graphics2D g) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		 int xBrojac=0;
		
		
		if(!view.getStateManager().isEditing()) {
			AttributedString astr=new AttributedString(this.getSlot().getText());
			Map<Character, List<Boolean>>mapa=this.getSlot().getContent().getMap();
			List<List<Boolean>>lista=this.getSlot().getContent().getFontovi();
			
			
			
			for (int i=0;i<this.getSlot().getContent().getFontovi().size();i++) {
				
			
				astr.addAttribute(TextAttribute.SIZE,20,i,i+1);
				
				if(lista.get(i).get(0)==true) {
					astr.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD,i,i+1);
					
				}
				if(lista.get(i).get(1)==true) {
					astr.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE,i,i+1);
					
				}
				if(lista.get(i).get(2)==true) {
					astr.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON,i,i+1);
					
				}
			
			}
			
			g.drawString(astr.getIterator(),this.getSlot().getX(), this.getSlot().getY());
			
		
		}else {
			
					
			g.setPaint(this.getSlot().getColor());
			g.setStroke(this.getSlot().getStroke());
			g.setFont(new Font("Monospaced",Font.PLAIN,20));
			
			
			
			if(this.getSlot().isSelected()) {
				
				g.setPaint(Color.black);

			}
			
			g.drawRect(this.getSlot().getX(),this.getSlot().getY(),this.getSlot().getW(),this.getSlot().getH());
			
			g.drawString("Text", this.getSlot().getX()+this.getSlot().getW()/4, this.getSlot().getY()+this.getSlot().getH()/2);
		
		}
			
	}

}
