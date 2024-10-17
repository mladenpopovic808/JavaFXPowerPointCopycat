package view.tree.view.SlajdViewPanelController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import view.MainFrame;
import view.tree.view.PrezentacijaView;
import view.tree.view.SlajdView;

public class SlajdViewPanelController implements MouseListener,MouseMotionListener{

	private PrezentacijaView prezentacijaView;
	private SlajdView slajdView;
	
	public SlajdViewPanelController(SlajdView slajdView) {
		super();
		this.slajdView=slajdView;
		
		int i=MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
		if(i!=-1) {
			PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(i);
			this.prezentacijaView=p;
		}else {
			PrezentacijaView p=MainFrame.getInstance().getProjectView().getListaPrezViewova().get(MainFrame.getInstance().getProjectView().getListaPrezViewova().size()-1);
			this.prezentacijaView=p;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		prezentacijaView.getStateManager().getState().misJeKliknut(e, prezentacijaView, slajdView);
		

	}	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		prezentacijaView.getStateManager().getState().misJePusten(e, prezentacijaView, slajdView);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		prezentacijaView.getStateManager().getState().misJePovucen(e, prezentacijaView, slajdView);
		
		
		slajdView.updateUI();
		e.consume();
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

}
