package CustomerModule.Customer.Controller;

public class equalFrequency {
    public boolean equalFrequency(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    count++;
                } else if (word.charAt(i) != word.charAt(j)) {
                    j++;
                }
            }
        }
        if(count
        }

    }
}
