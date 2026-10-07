class Solution {
    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0;

        while (i < formula.length()) {

            char ch = formula.charAt(i);

            // (
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            }

            // )
            else if (ch == ')') {
                Map<String, Integer> current = stack.pop();
                i++;

                int num = 0;

                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (num == 0) num = 1;

                for (String atom : current.keySet()) {
                    current.put(atom, current.get(atom) * num);
                }

                Map<String, Integer> parent = stack.peek();

                for (String atom : current.keySet()) {
                    parent.put(atom,
                            parent.getOrDefault(atom, 0) + current.get(atom));
                }
            }

            // Element
            else {
                StringBuilder atom = new StringBuilder();

                atom.append(ch);
                i++;

                while (i < formula.length()
                        && Character.isLowerCase(formula.charAt(i))) {
                    atom.append(formula.charAt(i));
                    i++;
                }

                int num = 0;

                while (i < formula.length()
                        && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (num == 0) num = 1;

                String element = atom.toString();

                Map<String, Integer> map = stack.peek();

                map.put(element,
                        map.getOrDefault(element, 0) + num);
            }
        }

        Map<String, Integer> map = stack.peek();

        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);

        StringBuilder ans = new StringBuilder();

        for (String atom : atoms) {
            ans.append(atom);

            int count = map.get(atom);

            if (count > 1)
                ans.append(count);
        }

        return ans.toString();
    }
}