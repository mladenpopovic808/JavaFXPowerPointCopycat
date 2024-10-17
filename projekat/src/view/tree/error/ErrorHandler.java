package view.tree.error;

import java.util.ArrayList;
import java.util.List;

import controller.IPublisher;
import controller.ISubscriber;

public class ErrorHandler implements IPublisher{
	
	
	private List<ISubscriber> subscribers=new ArrayList<ISubscriber>();
	public static ErrorHandler instance=null;
	public static int WORKSPACE_CAN_NOT_BE_DELETED=0;
	public static int SLAJD_CAN_BE_ADDED_ONLY_IN_PRESENTATION=1;
	public static int PICTURE_NOT_VALID=2;
	public static int NAME_NOT_VALID=3;
	public static int PROJECT_CAN_BE_ADDED_ONLY_IN_WORKSPACE=4;
	public static int PRESENTATION_CAN_BE_ADDED_ONLY_IN_PROJECT=5;
	public static int ON_WORKSPACE_CAN_ONLY_PROJECT_BE_ADDED=6;
	public static int ON_PROJECT_CAN_ONLY_PRESENTATION_BE_ADDED=7;
	public static int ON_PRESENTATION_CAN_ONLY_SLAJD_BE_ADDED=8;
	public static int NO_PROJECT_AVAILABLE=9;
	public static int NO_PRESENTATION_AVAILABLE=10;
	public static int NO_ITEM_SELECTED=11;
	public static int AUTHOR_NOT_VALID=12;
	public static int THICKNESS_NOT_VALID=13;
	public static int SLAJD_CANT_HAVE_CHILDREN=14;
	public static int NO_SLOT_SELECTED=15;
	public static int FILE_NOT_VALID=16;
	
	
	
	private ErrorHandler() {
		
	}
	@Override
	public void addSubscriber(ISubscriber sub) {
		if(!subscribers.contains(sub)) {
			subscribers.add(sub);
		}
		
	}

	@Override
	public void removeSubscriber(ISubscriber sub) {
		if(subscribers.contains(sub)) {
			subscribers.remove(sub);
		}
		
	}
	
	@Override
	public void notifySubscribers(Object notification) {
		for (ISubscriber sub : subscribers) {
			sub.update(notification);
			
		}
		
	}

	
	public static ErrorHandler getInstance() {
		if(instance==null) {
			instance=new ErrorHandler();
		}
		return instance;
	}
	
	public MyError generateError(int errorType) {
		MyError error=null;
		
		if(errorType==this.NAME_NOT_VALID) {
			error=new MyError("Ime cvora nije validno!" , errorType);
			
		}
		else if(errorType==this.PICTURE_NOT_VALID) {
			error=new MyError("Putanja do slike nije validna!" , errorType);
			
		}
		else if(errorType==this.SLAJD_CAN_BE_ADDED_ONLY_IN_PRESENTATION) {
			error=new MyError("Slajd se moze dodati samo na prezentaciju!" , errorType);
	
		}
		else if(errorType==this.WORKSPACE_CAN_NOT_BE_DELETED) {
			error=new MyError("Workspace ne moze biti obrisan!" , errorType);
			
		}
		else if(errorType==this.PRESENTATION_CAN_BE_ADDED_ONLY_IN_PROJECT) {
			error=new MyError("Prezentacija se moze dodati samo na projekat!" , errorType);
			
		}
		else if(errorType==this.PROJECT_CAN_BE_ADDED_ONLY_IN_WORKSPACE) {
			error=new MyError("Projekat se moze dodati samo na workspace!" , errorType);
			
		}
		else if(errorType==this.ON_WORKSPACE_CAN_ONLY_PROJECT_BE_ADDED) {
			error=new MyError("Na workspace se moze dodati samo projekat!" , errorType);
			
		}
		else if(errorType==this.ON_PROJECT_CAN_ONLY_PRESENTATION_BE_ADDED) {
			error=new MyError("Na projekat se moze dodati samo prezentacija!" , errorType);
			
		}
		else if(errorType==this.ON_PRESENTATION_CAN_ONLY_SLAJD_BE_ADDED) {
			error=new MyError("Na prezentaciju se moze dodati samo slajd!" , errorType);
			
		}else if(errorType==this.NO_PRESENTATION_AVAILABLE) {
			error=new MyError("Ne postoji prezentacija ili nije selektovana!" , errorType);
			
		}else if(errorType==this.NO_PROJECT_AVAILABLE) {
			error=new MyError("Ne postoji projekat ili nije selektovan!" , errorType);
			
		}else if(errorType==this.NO_ITEM_SELECTED) {
			error=new MyError("Niste izabrali cvor!" , errorType);
		}
		else if(errorType==this.AUTHOR_NOT_VALID) {
		error=new MyError("Ime autora nije validno!" , errorType);
		}
		else if(errorType==this.THICKNESS_NOT_VALID) {
			error=new MyError("Pogresan unos debljine linije!" , errorType);
			}
		else if(errorType==this.SLAJD_CANT_HAVE_CHILDREN) {
			error=new MyError("Slajd ne moze da sadrzi node-ove!" , errorType);
			}
		else if(errorType==this.NO_SLOT_SELECTED) {
			error=new MyError("Niste selektovali slot" , errorType);
			}
		else if(errorType==this.FILE_NOT_VALID) {
			error=new MyError("Izabrali ste pogrešan fajl!" , errorType);
			}
		
		
		
		notifySubscribers(error);
		return error;
		
		
		
	}

	
}
