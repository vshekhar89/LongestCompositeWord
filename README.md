# LongestCompositeWord
# This repository contains the code to find the two largest concatenated words from a list of words containes in a file. </br>
# For example consider the files contains the words:</br>
# cats
# dog
# catsdog
# DoginHospital
# catsdogs
# dogcats
# The two longest concatenated words in this list are catsdog and dogcats as they are made by combination of other words present</br>
# already present in the list.
# The code also returns the total number of concatenated words present in the file.

#Approach Used:

#1) Read the test file and create a hash set with the input words.Creating a has set will help in retrieving the words later in #constant time.

#2) Sort the input words in the descending order of their lengths by using a custom comparator.
#The idea behind this is that we don’t need to go thorough the entire list of words again in average case to find the two largest # # # #concatenated words.

# 3) Iterate over the list of words and check whether they are valid concatenated words.
# This is done by taking substrings of the word starting from left and checking whether it exists in the hash set. If it does, then the # remainder of the word is checked by calling the function recursively. 

# 4) For every concatenated word found, increase the count of concatenated words.

# 5) Print the first two concatenated words found and the count of total concatenated words.

# Testing Instructions:

# 1) Please compile all the attached java files.

# 2) Run Test.java and provide the absolute/relative path of the file "wordsforproblem.txt" as an argument.

