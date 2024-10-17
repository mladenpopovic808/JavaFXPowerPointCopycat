package view.tree.view.slotContent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Slot;
import view.MainFrame;
import view.tree.view.PrezentacijaView;

public class MultimediaSlotHandler extends SlotHandler implements Serializable {

	public MultimediaSlotHandler(Slot slot) {
		super(slot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readContent() {
		return "";				///Smatram da je nepotrebna metoda,nigde citanje slike(ili teksta) ne zahteva apstrakciju,sve se radi u posebnim dijalozima u kojima nije potrebna apstrakcija
	}

	@Override
	public void setContent(String str) {
									///     -||- ,ne mogu preko npr MultimediaDialoga da zovem slotView preko koga cu da pozivam slotHandler.setContent(),nema smisla a i nije potrebno
	}

	@Override
	public void format() {
		
	}

	@Override
	public void paint(Graphics2D g) {
		
		int index=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		PrezentacijaView view=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(index);
		
		if(view.getStateManager().isEditing()) {
			
			g.setPaint(this.getSlot().getColor());
			g.setStroke(this.getSlot().getStroke());
			g.setFont(new Font("Monospaced",Font.BOLD,20));
			
			if(this.getSlot().isSelected()) {
				
				g.setPaint(Color.black);

			}
			g.drawRect(this.getSlot().getX(),this.getSlot().getY(),this.getSlot().getW(),this.getSlot().getH());
			
			
			g.drawString("MultiM", this.getSlot().getX()+this.getSlot().getW()/4, this.getSlot().getY()+this.getSlot().getH()/2);
			
			
		}else {
			Image img=new ImageIcon(this.getSlot().getPutanjaDoSlike()).getImage();
			
			 ImagePanel panel = new ImagePanel(img);
			 
			 g.drawImage(img,this.getSlot().getX(),this.getSlot().getY(),
					 		 this.getSlot().getW(),this.getSlot().getH(),
					 		 null);
			
		}	
	}
	private class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(Image img) {
		    this.img = img;
		    
		  }

		  
	}
}

