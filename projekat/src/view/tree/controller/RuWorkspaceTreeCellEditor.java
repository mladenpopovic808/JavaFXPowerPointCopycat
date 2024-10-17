package view.tree.controller;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import commands.NameCommand;
import model.nodes.RuNode;
import view.MainFrame;

public class RuWorkspaceTreeCellEditor extends DefaultTreeCellEditor implements ActionListener{
	
	private Object cvor=null; ///cvor koji se menja
	private JTextField edit=null; //labelu pretvaramo u tf
	
	

	public RuWorkspaceTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4,
			int arg5) {
			///Java ce sama uci u ovo ako je cellEditable
			cvor=arg1;

			edit=new JTextField(arg1.toString()); 
			edit.addActionListener(this);
			return edit;
			
			
			
	}
	
	
	@Override
	public boolean isCellEditable(EventObject event) {
		if(event instanceof MouseEvent) {
			if(((MouseEvent)event).getClickCount()==2) {
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		MainFrame.getInstance().getCommandManager().addCommand(new NameCommand((RuNode)cvor,e.getActionCommand()));
		

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
