package model;

import java.io.Serializable;

public class MyFont implements Serializable {

	
	private boolean bold=false;
	private boolean italic=false;
	private boolean underline=false;
	
	
	public boolean isBold() {
		return bold;
	}
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	public boolean isItalic() {
		return italic;
	}
	public void setItalic(boolean italic) {
		this.italic = italic;
	}
	public boolean isUnderline() {
		return underline;
	}
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}
	
	
	
	
	
	

}
