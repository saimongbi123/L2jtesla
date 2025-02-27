package dev.Phantom.ai.Walker;

import dev.Phantom.FakePlayer;
import dev.Phantom.model.WalkNode;
import dev.Phantom.model.WalkerType;
import dev.l2j.tesla.commons.random.Rnd;

public class GiranWalkerAI extends WalkerAI {

	public GiranWalkerAI(FakePlayer character) {
		super(character);
	}

	@Override
	protected WalkerType getWalkerType() {
		return WalkerType.RANDOM;
	}

	private int currentNodeIndex = 0;

	@Override
	protected void setWalkNodes() {
		_walkNodes.add(new WalkNode(83256, 148664, -3408, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83320, 148984, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83512, 148184, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83624, 147752, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83304, 147672, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(82072, 147640, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83288, 148584, -3408, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(82904, 148456, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(82968, 148040, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(81928, 147784, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(82264, 149032, -3464, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(81512, 148632, -3464, Rnd.get(1, 10)));
		//teste
		_walkNodes.add(new WalkNode(83576, 148744, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83464, 148728, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83608, 148648, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83576, 148536, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83592, 149112, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83624, 148744, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83608, 148472, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83608, 148168, -3400, Rnd.get(1, 10)));
		_walkNodes.add(new WalkNode(83496, 148168, -3400, Rnd.get(1, 10)));


		return;
	}

	public int getCurrentNodeIndex() {
		return currentNodeIndex;
	}

	public void setCurrentNodeIndex(int currentNodeIndex) {
		this.currentNodeIndex = currentNodeIndex;
	}

}
