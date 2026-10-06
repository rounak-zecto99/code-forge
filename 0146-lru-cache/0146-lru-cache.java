class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> cache;
    Node oldest = new Node(-1,-1);
    Node latest = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();

        latest.next = oldest;
        oldest.prev = latest;

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node k = cache.get(key);
            delete(k);
            insert(k);

            return k.val;
        }
        return -1;
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        Node second = latest.next;
        latest.next = node;
        node.prev = latest;
        second.prev = node;
        node.next = second;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            delete(node);
            insert(node);
        } else {
            if (cache.size() == cap) {
                Node node = oldest.prev;
                cache.remove(node.key);
                delete(node);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
            return;
        }
    }
}
