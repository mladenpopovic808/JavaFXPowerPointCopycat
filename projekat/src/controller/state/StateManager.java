package controller.state;

public class StateManager {

	private State state; /// predstavlja aktivan state
	private SlideShowState slideShowState;
	private EditState editState;
	private AddRectangleState addRectangleState;
	private RemoveRectangleState removeRectangleState;
	private SelectionState selectionState;
	private MoveSlotState moveSlotState;
	private boolean editing;

	
	public StateManager() {
		super();
		
		slideShowState=new SlideShowState();
		editState=new EditState();
	
		addRectangleState=new AddRectangleState();
		removeRectangleState=new RemoveRectangleState();
		selectionState=new SelectionState();
		moveSlotState=new MoveSlotState();
		
		editing=true;
		this.state=editState;
	}
	public void setSlideShowState() {
		this.state=slideShowState;
		editing=false;
	}
	public void setEditState() {
		this.state=editState;
		editing=true;
	}
	
	public void setAddRectangleState() {
		this.state=addRectangleState;
		editing=true;
	}
	public void setRemoveRectangleState() {
		this.state=removeRectangleState;
		editing=true;
	}
	public void setSelectionState() {
		this.state=selectionState;
		editing=true;
	}
	public void setMoveSlotState() {
		this.state=moveSlotState;
		editing=true;
	}
	public State getState() {
		return state;
	}
	public SlideShowState getSlideShowState() {
		return slideShowState;
	}
	public EditState getEditState() {
		return editState;
	}
	
	public AddRectangleState getAddRectangleState() {
		return addRectangleState;
	}
	public RemoveRectangleState getRemoveRectangleState() {
		return removeRectangleState;
	}
	public SelectionState getSelectionState() {
		return selectionState;
	}
	public boolean isEditing() {
		return editing;
	}
	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	
   
	
	
	
}
