package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledDocument;

import controller.IPublisher;
import controller.ISubscriber;
import model.nodes.SlotType;
import view.MyBasicStroke;
import view.tree.view.slotContent.Content;

public class Slot implements IPublisher,Serializable{
	
	private List<ISubscriber>subscribers;
	private int x;
	private int y;
	private int h;
	private int w;
	private  Color color;
	private MyBasicStroke myStroke;
	private String putanjaDoSlike;
	private String text;
	private String formatText;
	private boolean selected;
	private  SlotType slotType;
	private  MyFont font;
	private  Content content;
	
	
	
	public Slot(int x, int y, int h, int w, Color color, MyBasicStroke stroke,SlotType slotType) {
		super();
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.color = color;
		this.myStroke =  stroke;
		this.slotType=slotType;
		subscribers=new ArrayList<ISubscriber>();
		putanjaDoSlike="images/green(1).jpg";
		selected=false;
		text="Default text";
		font=new MyFont();
		content=new Content();
		content.setText("Default text");
		
	}
	
	@Override
	public void addSubscriber(ISubscriber sub) {
		subscribers.add(sub);
		
	}
	@Override
	public void removeSubscriber(ISubscriber sub) {
		subscribers.remove(sub);
		
	}
	@Override
	public void notifySubscribers(Object notification) {
		for (ISubscriber sub : subscribers) {
			sub.update(notification);
			
		}
		
	}
	@Override
	public boolean equals(Object obj) {
		Slot slot=(Slot)obj;
		if(slot.x==this.x && slot.y==this.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {

		return x+" "+y+" ";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		notifySubscribers("rectangle");
	}
	public BasicStroke getStroke() {
		return (BasicStroke) myStroke.getStroke();
		
	}
	public void setStroke(BasicStroke stroke) {
		myStroke.setStroke(stroke);
		notifySubscribers("rectangle");
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		notifySubscribers(selected);
	}
	
	public void setPosition(Point p) {
		x=p.x;
		y=p.y;
		notifySubscribers("rectangle");
		
	}

	public String getPutanjaDoSlike() {
		return putanjaDoSlike;
	}

	public void setPutanjaDoSlike(String putanjaDoSlike) {
		this.putanjaDoSlike = putanjaDoSlike;
		content.setPutanjaDoSlike(putanjaDoSlike);
		
		this.notifySubscribers("putanjaDoSlikeSlota");
	}

	public SlotType getSlotType() {
		return slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}

	public MyFont getFont() {
		return font;
	}

	public void setFont(MyFont font) {
		this.font = font;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		content.setText(text);
		this.text = text;
		this.notifySubscribers("textSlota");
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}


	public String getFormatText() {
		return formatText;
	}

	public void setFormatText(String formatText) {
		content.setFormatText(formatText);
		this.formatText = formatText;
		
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
}
