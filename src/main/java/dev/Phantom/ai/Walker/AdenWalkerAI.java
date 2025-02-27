package dev.Phantom.ai.Walker;

import dev.Phantom.FakePlayer;
import dev.Phantom.model.WalkNode;
import dev.Phantom.model.WalkerType;
import dev.l2j.tesla.commons.random.Rnd;

public class AdenWalkerAI extends WalkerAI {

    public AdenWalkerAI(FakePlayer character) {
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
        _walkNodes.add(new WalkNode(148088, 25864, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(148072, 25768, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(148056, 25720, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147928, 25752, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147816, 25720, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147768, 25864, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147640, 25800, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147576, 25928, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147384, 25800, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147416, 25688, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147256, 25688, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147128, 25672, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147048, 25784, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(146936, 25800, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(146824, 25800, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(146984, 25864, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147064, 25864, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147160, 25848, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147256, 25816, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147304, 25864, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147384, 25912, -2008, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147320, 26664, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147320, 26920, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147384, 27128, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147432, 27272, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147560, 27224, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147576, 27128, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147576, 26936, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147592, 26744, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147896, 26760, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(148088, 26840, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(148056, 26952, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147944, 26952, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(148120, 27080, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147992, 27144, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147752, 27144, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147464, 27144, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147208, 27144, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(146968, 27144, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147032, 27096, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147048, 26936, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147032, 26808, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(146968, 26824, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147192, 26952, -2200, Rnd.get(1, 10)));
        _walkNodes.add(new WalkNode(147240, 27048, -2200, Rnd.get(1, 10)));



        return;
    }

    public int getCurrentNodeIndex() {
        return currentNodeIndex;
    }

    public void setCurrentNodeIndex(int currentNodeIndex) {
        this.currentNodeIndex = currentNodeIndex;
    }

}
