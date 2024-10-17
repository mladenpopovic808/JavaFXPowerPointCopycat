package view.tree.view.slotContent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledDocument;

public class Content implements Serializable{

	private String text; /// putanja ili slika
	private String putanjaDoSlike;
	private String formatText;
	private Map<Character, List<Boolean>>map;
	
	
	private List<List<Boolean>>fontovi;
	
	
	
	

	public Content() {
		map=new HashMap<Character, List<Boolean>>();
		fontovi=new ArrayList<List<Boolean>>();
		
	}
	
	

	

	public List<List<Boolean>> getFontovi() {
		return fontovi;
	}

	public void setFontovi(List<List<Boolean>> fontovi) {
		this.fontovi = fontovi;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPutanjaDoSlike() {
		return putanjaDoSlike;
	}

	public void setPutanjaDoSlike(String putanjaDoSlike) {
		this.putanjaDoSlike = putanjaDoSlike;
	}

	public String getFormatText() {
		return formatText;
	}

	public void setFormatText(String formatText) {
		this.formatText = formatText;
	}

	public Map<Character, List<Boolean>> getMap() {
		return map;
	}
	public void setMap(Map<Character, List<Boolean>> map) {
		this.map = map;
	}
	
	
	
	
}


