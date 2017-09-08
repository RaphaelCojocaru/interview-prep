        // https://www.hackerrank.com/challenges/java-bigdecimal
        // Write your code here
        BigDecimal[] b = new BigDecimal[n];
        for (int i = 0; i < n; i++)
            b[i] = new BigDecimal(s[i]);
        
/*
        // perform insertion sort on both arrays:
        for (int i = 1; i < n; i++) {
            int j = i;
            BigDecimal value = b[i];
            String valueString = s[i];
            while (j > 0 && b[j - 1].compareTo(value) < 0) {
                b[j] = b[j - 1];
                s[j] = s[j - 1];
                j--;
            }
            b[j] = value;
            s[j] = valueString;
        }
*/      
        // perform bubble sort
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;
            
            for (int j = 0; j < n - 1; j++) {
                if (b[j].compareTo(b[j + 1]) < 0) {
                    BigDecimal tmp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = tmp;
                    String tmpS = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = tmpS;
                    numberOfSwaps++;
                }
            }
            // works without this too
            if (numberOfSwaps == 0)
                break;
        }
