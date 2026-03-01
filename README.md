# CSC 207: Text Editor

**Author**: Carrie Little and Ella Tobben

## Resources Used

+ oracle javadocs pages for String, char, Throwable
+ Referenced Ella & Cadel's SpeedReader for try/catch syntax as well as the lab page for SpeedReader
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Analyzing the Simple String Buffer
----insert method of SimpleStringBuffer----
Relevant inputs: Length of existing buffer (n), index of cursor (c)
Critical operations: 2 assignments, 2 concats, 2 substrings. We count character accessing within a string, 
which occurs in concats and in substrings.  
Model: O(n)=2n+c
insert is O(n)
Explanation:
insert first copies all characters in buffer up until the cursor into a string. This is (c) operations.
It then concatenates the desired character to the end, copying the aforementioned string character-by-character.
This concat is another (c) operations, bringing us to (2c) operations total.
Then it reads all characters including and following the one at cursor position in buffer into a string. 
This is (n-c) operations, bringing us to (n+c) operations.
Finally it concats this new string of the rest of buffer to the end our main string. It does this by copying
first our main string, which is (c+1) operations, and then our remainder string, which is (n-c) operations. 
This brings us to (2n+c+1) operations total.
