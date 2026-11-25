class MyHashSet {

    private final int[] bits = new int[31251];

    public void add(int key) {
        bits[key / 32] |= (1 << (key % 32));
    }

    public void remove(int key) {
        bits[key / 32] =  bits[key / 32] & ~(1 << (key % 32));
    }

    public boolean contains(int key) {
        return (bits[key / 32] & (1 << (key % 32))) != 0;
    }
}