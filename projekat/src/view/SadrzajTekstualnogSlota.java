package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import model.Slot;

public class SadrzajTekstualnogSlota extends JDialog{
	private StringBuilder builder;
	private Slot slot;
	private JTextPane textPane;
	private JButton save;

	public SadrzajTekstualnogSlota(Slot slot) {
		super(MainFrame.getInstance(),"Prikaz tekstualnog slota",true);
		this.slot=slot;
		
		
		this.setSize(new Dimension(500,500));
		this.setLocationRelativeTo(MainFrame.getInstance());
		textPane=new JTextPane();
		
	
		this.add(textPane);
		textPane.setFont(new Font("Monospaced",Font.PLAIN,20));
		
		initButtons();
		JToolBar toolbar=new JToolBar();
		this.add(BorderLayout.NORTH,toolbar);
		toolbar.add(MainFrame.getInstance().getActionManager().getBoldAction());
		toolbar.add(MainFrame.getInstance().getActionManager().getItalicAction());
		toolbar.add(MainFrame.getInstance().getActionManager().getUnderlineAction());
		toolbar.setFloatable(false);
		
		loadText();
		
		

		this.add(BorderLayout.SOUTH,save);			
		
	}
	
	private void loadText() {
		
		textPane.setText(slot.getContent().getText());
		
		if(slot.getContent().getFontovi().isEmpty()) { ///ako prvi put ulazimo u dialog
			return;
		}
		
		
		SimpleAttributeSet atr=new SimpleAttributeSet();
		List<List<Boolean>>fontovi=slot.getContent().getFontovi();
		StyledDocument styledDocument=textPane.getStyledDocument();
		
		
		for(int i=0;i<slot.getContent().getFontovi().size();i++) {
			
			if(fontovi.get(i).get(0)==true) {
				
				StyleConstants.setBold(atr, true);;
				styledDocument.setCharacterAttributes(i, i+1, atr, false);
			
				
			}
			if(fontovi.get(i).get(1)==true) {
				StyleConstants.setItalic(atr, true);;
				styledDocument.setCharacterAttributes(i, i+1, atr, false);
				
							
			}
			if(fontovi.get(i).get(2)==true) {
				StyleConstants.setUnderline(atr, true);;
				styledDocument.setCharacterAttributes(i, i+1, atr, false);
				System.out.println("usao");
				
			}

		}
		textPane.setStyledDocument(styledDocument);
		
	}	
	
	
	private void initButtons() {
		
		MainFrame.getInstance().getActionManager().getBoldAction().setSlot(slot);
		MainFrame.getInstance().getActionManager().getBoldAction().setDialog(this);;
		MainFrame.getInstance().getActionManager().getItalicAction().setSlot(slot);
		MainFrame.getInstance().getActionManager().getItalicAction().setDialog(this);
		MainFrame.getInstance().getActionManager().getUnderlineAction().setSlot(slot);
		MainFrame.getInstance().getActionManager().getUnderlineAction().setDialog(this);
		
		 save=new JButton("Save text");
		 
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					//slot.getContent().setStyledDocument(textPane.getStyledDocument());
					slot.setText(textPane.getText());
					rememberString();
					
	}
			});

	}
			
	public void rememberString() {
				builder=new StringBuilder();
					
				
				AttributeSet set;
				Map<Character, List<Boolean>>map=new HashMap<Character, List<Boolean>>();
				this.getSlot().getContent().getFontovi().clear();
				
				for(int i=0;i<textPane.getText().length();i++) {
					List<Boolean>lista=new ArrayList<Boolean>();
					 
					char character=textPane.getText().charAt(i);
					
					set=textPane.getStyledDocument().getCharacterElement(i).getAttributes();
					
					
					if(StyleConstants.isBold(set)) {
						lista.add(true);
						
					}else {
						lista.add(false);
					}
					
					if(StyleConstants.isItalic(set)) {
						lista.add(true);
						
						
					}
					else {
						lista.add(false);
					}
					if(StyleConstants.isUnderline(set)) {
					
						lista.add(true);
					
					}else {
						lista.add(false);
					}
					
					
					slot.getContent().getFontovi().add(lista);
				}
		

	}
	
	public boolean isValid(int brojac,int i) {
		
		if(i+brojac>=slot.getText().length()|| i-brojac<0 ) {
			return false;
		}
		return true;
		
	
	}

	
	
	public String getBuilderText() {
		return builder.toString();
	}
	public void setBuilder(StringBuilder builder) {
		this.builder = builder;
	}
	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
	
	

}
