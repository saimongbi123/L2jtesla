package dev.Phantom.ai.Walker;

import dev.Phantom.FakePlayer;
import dev.Phantom.model.WalkNode;
import dev.Phantom.model.WalkerType;
import dev.l2j.tesla.commons.random.Rnd;

public class DionWalkerAI extends WalkerAI {

    public DionWalkerAI(FakePlayer character) {
        super(character);
    }

    @Override
    protected WalkerType getWalkerType() {
        return WalkerType.RANDOM;
    }

    private int currentNodeIndex = 0;

    @Override
    protected void setWalkNodes() {
        _walkNodes.add(new WalkNode(15992, 142952, -2696, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15880, 142968, -2696, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15752, 143000, -2712, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15624, 142984, -2704, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15720, 143032, -2704, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15960, 143080, -2712, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16136, 143128, -2744, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16296, 143416, -2816, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16184, 143560, -2840, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(16312, 144136, -2976, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15544, 143240, -2712, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15688, 143336, -2728, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16024, 143352, -2776, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15784, 143240, -2728, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15832, 143336, -2752, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(15912, 143416, -2784, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16104, 143656, -2864, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16232, 143640, -2864, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16328, 143064, -2720, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16328, 143144, -2744, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16232, 143784, -2896, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16360, 143768, -2904, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16648, 144024, -2976, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16680, 144424, -3000, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16552, 143368, -2808, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(16824, 144392, -3000, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(16744, 144456, -3000, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(16584, 144440, -2992, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(16504, 143608, -2872, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(15688, 143080, -2704, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(15800, 143064, -2712, Rnd.get(1, 5)));
        _walkNodes.add(new WalkNode(16040, 143224, -2752, Rnd.get(1, 5)));
        //_walkNodes.add(new WalkNode(99999, 999999, -9999, Rnd.get(1, 5)));



        return;
    }

    public int getCurrentNodeIndex() {
        return currentNodeIndex;
    }

    public void setCurrentNodeIndex(int currentNodeIndex) {
        this.currentNodeIndex = currentNodeIndex;
    }

}
