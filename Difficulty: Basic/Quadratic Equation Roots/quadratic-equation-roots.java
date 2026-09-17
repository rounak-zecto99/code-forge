class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        int disc = b*b - 4*a*c;
        ArrayList<Integer> list = new ArrayList<>();
        
        if(disc<0){
        list.add(-1);
        return list;
        }
        int root1 = (int)Math.floor((-b+Math.sqrt(disc))/(2.0*a));
        int root2 = (int)Math.floor((-b-Math.sqrt(disc))/(2.0*a));
        
        list.add(root1);
        list.add(root2);
        
        return list;
    }
}