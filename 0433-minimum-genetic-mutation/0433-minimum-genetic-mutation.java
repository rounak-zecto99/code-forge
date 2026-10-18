class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> samples = new HashSet<>();
        char[] genes = { 'A', 'C', 'G', 'T' };

        for (String gene : bank) {
            samples.add(gene);
        }

        if (!samples.contains(endGene))
            return -1;

        Queue<String> mutated = new ArrayDeque<>();

        mutated.offer(startGene);
        samples.remove(startGene);

        int length = 1;

        while (!mutated.isEmpty()) {

            int size = mutated.size();

            for (int j = 0; j < size; j++) {
                String start = mutated.poll();
                char[] curGene = start.toCharArray();

                for (int i = 0; i < curGene.length; i++) {
                    char original = curGene[i];

                    for (char mutate : genes) {
                        curGene[i] = mutate;
                        String mGene = new String(curGene);

                        if (mGene.equals(endGene)) {
                            return length;
                        }

                        if (samples.remove(mGene)) {
                            mutated.offer(mGene);
                        }

                    }
                    curGene[i] = original;
                }
            }
            length++;
        }
        return -1;
    }
}