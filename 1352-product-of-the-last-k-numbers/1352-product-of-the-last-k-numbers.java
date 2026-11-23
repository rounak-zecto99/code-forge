class ProductOfNumbers {
    int[] list = new int[40001];
    int idx;
    int prepro;
    int latestZero;

    public ProductOfNumbers() {
        list[0] = 1;
        idx = 1;
        prepro = 1;
        latestZero = 0;
    }

    public void add(int num) {
        if (num == 0) {
            list[idx++] = 1;
            latestZero = idx - 1;
            prepro = 1;
            return;
        }

        prepro *= num;
        list[idx++] = prepro;
    }

    public int getProduct(int k) {
        if (idx - k <= latestZero)
            return 0;

        return prepro / list[idx - k - 1];
    }
}