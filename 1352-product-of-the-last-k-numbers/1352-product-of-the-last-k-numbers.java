class ProductOfNumbers {
    ArrayList<Integer> list;
    int prepro;
    int latestZero;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        
        prepro = 1;
    }

    public void add(int num) {
        if(num == 0){
            list.add(1);
            latestZero = list.size() - 1;
            prepro = 1;
            return;
        }

        prepro *= num;
        list.add(prepro);

    }

    public int getProduct(int k) {
        if(list.size() - k <= latestZero)
        return 0;

        // System.out.println(list);
        // System.out.println(prepro);
        // System.out.println(k);
        // System.out.println(latestZero);

        return prepro / list.get(list.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */