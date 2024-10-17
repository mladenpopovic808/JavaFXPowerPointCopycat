package view.tree.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DropMode;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.Workspace;
import view.MainFrame;
import view.tree.controller.RuTreeCellRenderer;
import view.tree.controller.RuTreeSelectionListener;
import view.tree.controller.RuWorkspaceTreeCellEditor;


public class MyTree extends JTree{
	
	public MyTree() {
		super();
		addTreeSelectionListener(new RuTreeSelectionListener());
		setCellRenderer(new RuTreeCellRenderer());
		setCellEditor(new RuWorkspaceTreeCellEditor(this, new DefaultTreeCellRenderer()));
		setDragEnabled(true);
		
		setDropMode(DropMode.ON_OR_INSERT);
		this.setEditable(true);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Workspace w=(Workspace)MainFrame.getInstance().getTree().getModel().getRoot();
				int i=w.getChildren().size();
				if(i!=0) {
				if(e.getClickCount()==1) {
					try {
						if(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPath().getLastPathComponent() instanceof Projekat) {
							
							Object o=MainFrame.getInstance().getTree().getLastSelectedPathComponent();
							///Otvorice selektovan projekat na desnom panelu
								Projekat p=(Projekat)o;

								MainFrame.getInstance().getWorkSpacePanel().add(BorderLayout.CENTER,MainFrame.getInstance().getProjectView());
								MainFrame.getInstance().setProjectView(p);
								
								
							}
						else if(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPath().getLastPathComponent() instanceof Prezentacija) {
								///otvorice selektovanu prezentaciju na desnom panelu
								
								
								Prezentacija p=(Prezentacija)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
	
								MainFrame.getInstance().setProjectView((Projekat)p.getParent());
								
								int index=MainFrame.getInstance().getProjectView().getProjekat().getIndex(p);
								MainFrame.getInstance().getProjectView().getTabbedPane().setSelectedIndex(index);
							
							}else if(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPath().getLastPathComponent() instanceof Slajd) {
								///Otvorice prezentaciju na kojoj se slajd nalazi na desnom panelu
								
								Slajd s=(Slajd)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
								Prezentacija p=(Prezentacija)s.getParent();
								MainFrame.getInstance().setProjectView((Projekat)p.getParent());
								
								int index=MainFrame.getInstance().getProjectView().getProjekat().getIndex(p);
								MainFrame.getInstance().getProjectView().getTabbedPane().setSelectedIndex(index);

							}
					} catch (Exception e2) {
						// TODO: handle exception
					}

			}
		
	}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	
	
	
	

}
