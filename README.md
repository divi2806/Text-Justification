# Text-Justification
This is a new interesting leetcode question that is tagged as hard difficulty , which I am sharing in various languages

Here is the question . 

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth




EXPLAINATION BELOW - 

Initialization: We start by preparing an empty list (vector) named result which will hold our final formatted lines. We also set startIndex to 0, indicating that we're going to start formatting the words from the beginning.

Loop through Words: We go through each word in the list of words.

Creating a Line: For each word, we start building a line of text. We calculate the length of the word, and then we move to the next word by incrementing endIndex.

Check Line Length: We keep adding words to the line until we reach a point where adding the next word would make the line too long (beyond the maxWidth). When this happens, we stop adding words and move to the next step.

Distributing Spaces: Now that we have a line with words that can fit within the maximum width, we calculate the number of spaces we need to distribute between these words to make the line reach the desired width (maxWidth).

Handling Single Words and Last Line: If the line contains only one word or if it's the last line, we left-align the words by adding extra spaces to the right until the line reaches the desired width. This ensures the word is flush with the left side.

Distributing Spaces Evenly: If the line has multiple words and it's not the last line, we calculate the base number of spaces to insert between each word, and then we distribute any extra spaces as evenly as possible, with the left words getting more extra spaces if needed. This ensures the line looks balanced.

Building the Line: We build the final line by appending words and spaces as required based on the conditions above.

Adding to Result: The formatted line is added to the result vector.

Moving to Next Line: We update startIndex to the value of endIndex, indicating that the next line starts from where the previous line ended.

Repeat the Process: We keep repeating this process until we have gone through all the words in the list.

Return Result: Finally, we return the result vector, which contains all the formatted lines.



