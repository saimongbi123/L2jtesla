package dev.Phantom.ai.Walker;

import dev.Phantom.FakePlayer;
import dev.Phantom.model.WalkNode;
import dev.Phantom.model.WalkerType;
import dev.l2j.tesla.commons.random.Rnd;

public class GludinWalkerAI extends WalkerAI {

    public GludinWalkerAI(FakePlayer character) {
        super(character);
    }

    @Override
    protected WalkerType getWalkerType() {
        return WalkerType.RANDOM;
    }

    private int currentNodeIndex = 0;

    @Override
    protected void setWalkNodes() {
        _walkNodes.add(new WalkNode(-80744, 149880, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80840, 149880, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80888, 149848, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80792, 150024, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80872, 150040, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80920, 149912, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80904, 150024, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80888, 149816, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80584, 149976, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80504, 150152, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80696, 150344, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80856, 150488, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80856, 150328, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-80936, 150376, -3040, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(-81016, 150232, -3040, Rnd.get(1, 5)));


        return;
    }

    public int getCurrentNodeIndex() {
        return currentNodeIndex;
    }

    public void setCurrentNodeIndex(int currentNodeIndex) {
        this.currentNodeIndex = currentNodeIndex;
    }

}
