package ADataStructure.A2LinkedList;

public class NodeRandom {
    public int val;
    public NodeRandom next;
    public NodeRandom random;

    public NodeRandom() {
    }
    public NodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeRandom getNext() {
        return next;
    }

    public void setNext(NodeRandom next) {
        this.next = next;
    }

    public NodeRandom getRandom() {
        return random;
    }

    public void setRandom(NodeRandom random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "NodeRandom{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
