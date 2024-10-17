package controller.factory;

import model.Slajd;
import model.nodes.RuNode;

public class SlajdFactory extends AbstractNodeFactory {

	@Override
	public RuNode createNode() {
		// TODO Auto-generated method stub
		return new Slajd();
	}

}
