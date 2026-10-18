class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> samples = new HashSet<>();
        char[] genes = { 'A', 'C', 'G', 'T' };

        for (String gene : bank) {
            samples.add(gene);
        }

        if (!samples.contains(endGene))
            return -1;

        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();

        front.add(startGene);
        back.add(endGene);

        samples.remove(startGene);
        samples.remove(endGene);

        int length = 1;

        while (!front.isEmpty() && !back.isEmpty()) {

            if (front.size() > back.size()) {
                Set<String> temp = front;
                front = back;
                back = temp;
            }
            Set<String> next = new HashSet<>();

            for (String start : front) {
                char[] curGene = start.toCharArray();

                for (int i = 0; i < curGene.length; i++) {
                    char original = curGene[i];

                    for (char mutate : genes) {
                        curGene[i] = mutate;
                        String mGene = new String(curGene);

                        if (back.contains(mGene)) {
                            return length;
                        }

                        if (samples.remove(mGene)) {
                            next.add(mGene);
                        }

                    }
                    curGene[i] = original;
                }
            }
            length++;
            front = next;
        }
        return -1;
    }
}