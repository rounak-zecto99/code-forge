class MyCircularQueue {
    int[] arr;
    int front;
    int cur;
    int size;
    int writer;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        front = -1;
        cur = 0;
        writer = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        writer = (writer + 1) % size;
        arr[writer] = value;

        if (cur == 0) {
            front = writer;
        }

        cur++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        else {
            cur--;
            front = (front + 1) % size;

            if (cur == 0) {
                front = -1;
                writer = -1;
            }
        }
        return true;
    }

    public int Front() {
        return front == -1 ? -1 : arr[front];
    }

    public int Rear() {
        return writer == -1 ? -1 : arr[writer];
    }

    public boolean isEmpty() {
        return cur == 0;
    }

    public boolean isFull() {
        return cur == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */