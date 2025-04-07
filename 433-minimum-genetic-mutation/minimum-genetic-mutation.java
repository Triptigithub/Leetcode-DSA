//kuch jyada nya nhi kra 
//hr word ke hr value ko checnge kra with a g t c and check kra vis toh nhi h new word jo bda h and also bank mein present h
//agar esa h toh queue mein dal diya bs 


//basically simple bfs run kri h





class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankset = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            bankset.add(bank[i]);
        }

        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        char[] word = { 'A', 'C', 'G', 'T' };

        HashSet<String> vis = new HashSet<>();
        vis.add(startGene);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                String s = q.poll();
                vis.add(s);

                if (s.equals(endGene))
                    return step;

                //now loop over the s
                for (int i = 0; i < s.length(); i++) {
                    for (int j = 0; j < word.length; j++) {

                        if (s.charAt(i) == word[j])
                            continue;
                        String str = s.substring(0, i) + word[j] + s.substring(i + 1);

                        //if bank mein h aur vis mein nhi h toh queu mein add kro
                        if (!vis.contains(str) && bankset.contains(str)) {
                            q.add(str);
                            vis.add(str);
                        }

                    }
                }
            }
            step++;
        }

        return -1;
    }
}