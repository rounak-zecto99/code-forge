class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int s =0; int e = letters.length-1; int mid = s+((e-s)/2);
       while(s<=e){
        if(target=='z'||target>=letters[letters.length-1]){
            return letters[0];
        }
        else if(letters[mid]==target){
           s++;
        }
        else if(letters[mid]<target){
            s = mid + 1;
        }
        else if(letters[mid]>target){
            e = mid - 1;
       } 
       mid = s+((e-s)/2); 
    }
    return letters[s];
}
}