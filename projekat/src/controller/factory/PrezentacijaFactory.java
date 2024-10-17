package controller.factory;

import model.Prezentacija;
import model.nodes.RuNode;

public class PrezentacijaFactory extends AbstractNodeFactory{

	@Override
	public RuNode createNode() {
		// TODO Auto-generated method stub
		return new Prezentacija();
	}

}
