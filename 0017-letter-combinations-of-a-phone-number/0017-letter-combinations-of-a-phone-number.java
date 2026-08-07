class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)
            return ans;

        String[] keypad = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        helper("", 0, digits, keypad, ans);

        return ans;
    }


    private void helper(String p, int index, String digits,
                        String[] keypad, List<String> ans) {

        if(index == digits.length()) {
            ans.add(p);
            return;
        }

        String letters = keypad[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            helper(
                p + letters.charAt(i),
                index + 1,
                digits,
                keypad,
                ans
            );
        }
    }
}