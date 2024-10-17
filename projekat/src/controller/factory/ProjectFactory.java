package controller.factory;

import model.Projekat;
import model.nodes.RuNode;

public class ProjectFactory extends AbstractNodeFactory {

	@Override
	public RuNode createNode() {
		// TODO Auto-generated method stub
		return new Projekat("Projekat");
	}

}
