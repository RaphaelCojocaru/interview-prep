    // https://www.hackerrank.com/challenges/java-anagrams
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] occurrences1 = new int[26];
        int[] occurrences2 = new int[26];
        
        if (a == null || b == null)
            return false;
        
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        for (char ch : a.toCharArray()) {
            if (Character.isLetter(ch) == false)
                return false;
            occurrences1[ch - 'a']++;
        }
        
        for (char ch : b.toCharArray()) {
            if (Character.isLetter(ch) == false)
                return false;
            occurrences2[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++)
            if (occurrences1[i] != occurrences2[i])
                return false;
        
        return true;
    }