class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> result;
        int startIndex = 0;
        
        while (startIndex < words.size()) {
            int lineLength = words[startIndex].length();
            int endIndex = startIndex + 1;
            
            while (endIndex < words.size() && lineLength + words[endIndex].length() + (endIndex - startIndex) <= maxWidth) {
                lineLength += words[endIndex].length();
                endIndex++;
            }
            
            int spaces = maxWidth - lineLength;
            int numWords = endIndex - startIndex;
            
            if (numWords == 1 || endIndex == words.size()) {
                string line = words[startIndex];
                for (int i = startIndex + 1; i < endIndex; i++) {
                    line += " " + words[i];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
                result.push_back(line);
            } else {
                int baseSpaces = spaces / (numWords - 1);
                int extraSpaces = spaces % (numWords - 1);
                
                string line = words[startIndex];
                for (int i = startIndex + 1; i < endIndex; i++) {
                    int spacesToAdd = baseSpaces + (i - startIndex <= extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        line += " ";
                    }
                    line += words[i];
                }
                result.push_back(line);
            }
            
            startIndex = endIndex;
        }
        
        return result;
    }
};
