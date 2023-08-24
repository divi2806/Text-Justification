import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        
        while (startIndex < words.length) {
            int lineLength = words[startIndex].length();
            int endIndex = startIndex + 1;
            
            while (endIndex < words.length && lineLength + words[endIndex].length() + (endIndex - startIndex) <= maxWidth) {
                lineLength += words[endIndex].length();
                endIndex++;
            }
            
            int spaces = maxWidth - lineLength;
            int numWords = endIndex - startIndex;
            
            if (numWords == 1 || endIndex == words.length) {
                StringBuilder sb = new StringBuilder(words[startIndex]);
                for (int i = startIndex + 1; i < endIndex; i++) {
                    sb.append(" ").append(words[i]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                result.add(sb.toString());
            } else {
                int baseSpaces = spaces / (numWords - 1);
                int extraSpaces = spaces % (numWords - 1);
                
                StringBuilder sb = new StringBuilder(words[startIndex]);
                for (int i = startIndex + 1; i < endIndex; i++) {
                    int spacesToAdd = baseSpaces + (i - startIndex <= extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        sb.append(" ");
                    }
                    sb.append(words[i]);
                }
                result.add(sb.toString());
            }
            
            startIndex = endIndex;
        }
        
        return result;
    }
}
