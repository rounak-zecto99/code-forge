class Solution {
    static class Tuple {
        int col;
        Node node;

        Tuple(int col,Node node) {
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList<Integer> topView(Node root) {
       ArrayList<Integer> list = new ArrayList<>();
       
       if(root == null)
       return list;
       
       TreeMap<Integer,Integer> map = new TreeMap<>();
       Queue<Tuple> q = new ArrayDeque<>();
       
       q.offer(new Tuple(0,root));
       
       while(!q.isEmpty()){
           Tuple cur = q.poll();
           
           int col = cur.col;
           Node node = cur.node;
           
           if(!map.containsKey(col)){
               map.put(col,node.data);
           }
           
           if(node.left!= null){
               q.offer(new Tuple(col-1,node.left));
           }
           
           if(node.right != null){
               q.offer(new Tuple(col+1,node.right));
           }
       }
       
       for(int val: map.values()){
           list.add(val);
       }
       
       return list;
    }
}