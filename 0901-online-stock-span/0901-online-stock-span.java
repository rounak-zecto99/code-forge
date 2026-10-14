class tuple {
    int stock;
    int span;

    tuple(int s, int t) {
        this.stock = s;
        this.span = t;
    }
}

class StockSpanner {
    Deque<tuple> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int t = 1;
        while (!stack.isEmpty() && stack.peek().stock <= price) {
            t += stack.pop().span;
        }
        stack.push(new tuple(price, t));
        return t;
    }
}
