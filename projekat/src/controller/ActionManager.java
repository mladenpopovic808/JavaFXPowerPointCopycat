package controller;

import controller.serializationActions.OpenPresentationAction;
import controller.serializationActions.OpenProjectAction;
import controller.serializationActions.SavePresentationAction;
import controller.serializationActions.SaveProjectAction;
import controller.slotContent.BoldAction;
import controller.slotContent.ItalicAction;
import controller.slotContent.SlotBackgroundAction;
import controller.slotContent.SlotTypeAction;
import controller.slotContent.UnderlineAction;

public class ActionManager {
	
	private InfoAction infoAction;
	
	private ChangeAuthorAction changeAuthorAction;
	private ChangeBackgroundAction changeBackgroundAction;
	private DeleteNodeAction deleteNodeAction;

	private SlajdShowAction slideShowAction;
	private EditStateAction editStateAction;
	private AddRectangleAction addRectangleAction;
	private DeleteRectangleAction deleteRectangleAction;
	private RectangleFrameAction rectangleFrameAction;
	private RectangleColorAction rectangleColorAction;
	private SelectionStateAction selectionStateAction;
	private DebljinaOkviraAction debljinaLinijeAction;
	private NewNodeAction newNodeAction;
	private MoveSlotStateAction moveSlotStateAction;
	private UndoAction undoAction;
	private RedoAction redoAction;
	private SlotBackgroundAction slotBackgroundAction;
	private DeljenjePrezentacijeAction deljenjePrezentacijeAction;
	private SlotTypeAction slotTypeAction;
	private SadrzajSlotaAction sadrzajSlotaAction;
	private DeljenjePrezentacijaSubmitAction deljenjePrezentacijeSubmitAction;
	private SaveProjectAction saveProjectAction;
	private OpenProjectAction openProjectAction;
	private OpenPresentationAction openPresentationAction;
	private SavePresentationAction savePresentationAction;
	private BoldAction boldAction;
	private ItalicAction italicAction;
	private UnderlineAction underlineAction;
	
	public ActionManager() {
		
		initialiseActions();
		
	}
	
	private void initialiseActions() {
		openPresentationAction=new OpenPresentationAction();
		savePresentationAction=new SavePresentationAction();
		boldAction=new BoldAction();
		italicAction=new ItalicAction();
		underlineAction=new UnderlineAction();
		sadrzajSlotaAction=new SadrzajSlotaAction();
		openProjectAction=new OpenProjectAction();
		infoAction=new InfoAction();
		saveProjectAction=new SaveProjectAction();
		changeAuthorAction=new ChangeAuthorAction();
		changeBackgroundAction=new ChangeBackgroundAction();
		deleteNodeAction=new DeleteNodeAction();
		
		slideShowAction=new SlajdShowAction();
		editStateAction=new EditStateAction();
		addRectangleAction=new AddRectangleAction();
		deleteRectangleAction=new DeleteRectangleAction();
		rectangleColorAction=new RectangleColorAction();
		rectangleFrameAction=new RectangleFrameAction();
		selectionStateAction=new SelectionStateAction();
		debljinaLinijeAction=new DebljinaOkviraAction();
		newNodeAction=new NewNodeAction();
		moveSlotStateAction=new MoveSlotStateAction();
		redoAction=new RedoAction();
		undoAction=new UndoAction();
		slotBackgroundAction=new SlotBackgroundAction();
		slotTypeAction=new SlotTypeAction();
		deljenjePrezentacijeAction=new DeljenjePrezentacijeAction();
		deljenjePrezentacijeSubmitAction=new DeljenjePrezentacijaSubmitAction();
		
		
	}

	
	////////////////////////////////////////////////////////
	
	
	
	
	public InfoAction getMyInfoAction() {
		return infoAction;
	}

	public BoldAction getBoldAction() {
		return boldAction;
	}

	public void setBoldAction(BoldAction boldAction) {
		this.boldAction = boldAction;
	}

	public ItalicAction getItalicAction() {
		return italicAction;
	}

	public void setItalicAction(ItalicAction italicAction) {
		this.italicAction = italicAction;
	}

	public UnderlineAction getUnderlineAction() {
		return underlineAction;
	}

	public void setUnderlineAction(UnderlineAction underlineAction) {
		this.underlineAction = underlineAction;
	}

	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}

	public void setOpenProjectAction(OpenProjectAction openProjectAction) {
		this.openProjectAction = openProjectAction;
	}

	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}

	public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
		this.saveProjectAction = saveProjectAction;
	}

	public DeljenjePrezentacijaSubmitAction getDeljenjePrezentacijeSubmitAction() {
		return deljenjePrezentacijeSubmitAction;
	}

	public void setDeljenjePrezentacijeSubmitAction(DeljenjePrezentacijaSubmitAction deljenjePrezentacijeSubmitAction) {
		this.deljenjePrezentacijeSubmitAction = deljenjePrezentacijeSubmitAction;
	}

	public DeljenjePrezentacijeAction getDeljenjePrezentacijeAction() {
		return deljenjePrezentacijeAction;
	}

	public void setDeljenjePrezentacijeAction(DeljenjePrezentacijeAction deljenjePrezentacijeAction) {
		this.deljenjePrezentacijeAction = deljenjePrezentacijeAction;
	}

	public void setMyInfoAction(InfoAction infoAction) {
		this.infoAction = infoAction;
	}

	

	public InfoAction getInfoAction() {
		return infoAction;
	}

	public void setInfoAction(InfoAction infoAction) {
		this.infoAction = infoAction;
	}

	public ChangeAuthorAction getChangeAuthorAction() {
		return changeAuthorAction;
	}

	public void setChangeAuthorAction(ChangeAuthorAction changeAuthorAction) {
		this.changeAuthorAction = changeAuthorAction;
	}

	public ChangeBackgroundAction getChangeBackgroundAction() {
		return changeBackgroundAction;
	}

	public void setChangeBackgroundAction(ChangeBackgroundAction changeBackgroundAction) {
		this.changeBackgroundAction = changeBackgroundAction;
	}

	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}

	public void setDeleteNodeAction(DeleteNodeAction deleteNodeAction) {
		this.deleteNodeAction = deleteNodeAction;
	}


	public SlajdShowAction getSlideShowAction() {
		return slideShowAction;
	}

	public void setSlideShowAction(SlajdShowAction slideShowAction) {
		this.slideShowAction = slideShowAction;
	}

	public EditStateAction getEditStateAction() {
		return editStateAction;
	}

	public void setEditStateAction(EditStateAction editStateAction) {
		this.editStateAction = editStateAction;
	}

	public AddRectangleAction getAddRectangleAction() {
		return addRectangleAction;
	}

	public void setAddRectangleAction(AddRectangleAction addRectangleAction) {
		this.addRectangleAction = addRectangleAction;
	}

	public DeleteRectangleAction getDeleteRectangleAction() {
		return deleteRectangleAction;
	}

	public void setDeleteRectangleAction(DeleteRectangleAction deleteRectangleAction) {
		this.deleteRectangleAction = deleteRectangleAction;
	}

	public RectangleFrameAction getRectangleFrameAction() {
		return rectangleFrameAction;
	}

	public void setRectangleFrameAction(RectangleFrameAction rectangleFrameAction) {
		this.rectangleFrameAction = rectangleFrameAction;
	}

	public RectangleColorAction getRectangleColorAction() {
		return rectangleColorAction;
	}

	public void setRectangleColorAction(RectangleColorAction rectangleColorAction) {
		this.rectangleColorAction = rectangleColorAction;
	}

	public SelectionStateAction getMouseStateAction() {
		return selectionStateAction;
	}

	public void setMouseStateAction(SelectionStateAction selectionStateAction) {
		this.selectionStateAction = selectionStateAction;
	}

	public DebljinaOkviraAction getDebljinaLinijeAction() {
		return debljinaLinijeAction;
	}

	public void setDebljinaLinijeAction(DebljinaOkviraAction debljinaLinijeAction) {
		this.debljinaLinijeAction = debljinaLinijeAction;
	}

	public NewNodeAction getNewNodeAction() {
		return newNodeAction;
	}

	public void setNewNodeAction(NewNodeAction newNodeAction) {
		this.newNodeAction = newNodeAction;
	}

	public SelectionStateAction getSelectionStateAction() {
		return selectionStateAction;
	}

	public void setSelectionStateAction(SelectionStateAction selectionStateAction) {
		this.selectionStateAction = selectionStateAction;
	}

	public MoveSlotStateAction getMoveSlotStateAction() {
		return moveSlotStateAction;
	}

	public void setMoveSlotStateAction(MoveSlotStateAction moveSlotStateAction) {
		this.moveSlotStateAction = moveSlotStateAction;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}

	public SlotBackgroundAction getSlotBackgroundAction() {
		return slotBackgroundAction;
	}

	public void setSlotBackgroundAction(SlotBackgroundAction slotBackgroundAction) {
		this.slotBackgroundAction = slotBackgroundAction;
	}


	public SlotTypeAction getSlotTypeAction() {
		return slotTypeAction;
	}

	public void setSlotTypeAction(SlotTypeAction slotTypeAction) {
		this.slotTypeAction = slotTypeAction;
	}

	public SadrzajSlotaAction getSadrzajSlotaAction() {
		return sadrzajSlotaAction;
	}

	public void setSadrzajSlotaAction(SadrzajSlotaAction sadrzajSlotaAction) {
		this.sadrzajSlotaAction = sadrzajSlotaAction;
	}

	public OpenPresentationAction getOpenPresentationAction() {
		return openPresentationAction;
	}

	public void setOpenPresentationAction(OpenPresentationAction openPresentationAction) {
		this.openPresentationAction = openPresentationAction;
	}

	public SavePresentationAction getSavePresentationAction() {
		return savePresentationAction;
	}

	public void setSavePresentationAction(SavePresentationAction savePresentationAction) {
		this.savePresentationAction = savePresentationAction;
	}
	
	
	
	
	
	
	
	
	
}
