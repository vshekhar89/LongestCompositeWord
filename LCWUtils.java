/***
 * @author Vimalendu Shekhar
 * @date : 02/16/2016
 * @version:1
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LCWUtils {

	// Array to store the list of input words
	private String[] inputWords;

	// Maintain a set of input words for retrieval in O(1) time
	private HashSet<String> inputSet;

	/*
	 * This methods prints the largest, second largest concatenated words and the number of
	 * concatenated words
	 * @param args
	 * @throws IOException
	 */
	public void getResults(String args[]) throws IOException {
		
		//Read the contents of the file
		String fileContent = readFile(args);

		//Extract the words in the string array
		inputWords = fileContent.replaceAll("\r", "").split("\n");

		//Create a hash set of the input words for constant time retrieval 
		inputSet = new HashSet<String>(Arrays.asList(inputWords));
		
		//Sort the words in the array in the descending order of their lengths
		Collections.sort(Arrays.asList(inputWords), new CustomComparator());

		int concatenatedWords = 0;
		int resultCount = 1;

		//iterating over each word to find the concatenated words
		for (int i = 0; i < inputWords.length; i++) {
			
			//check whether the word is a valid concatenated word
			if (checkValidConcatenatedWord(inputWords[i], inputWords[i].length())) {
				concatenatedWords++;

				// if-block to check if the 2 largest concatenated strings have
				// been found
				if (resultCount <= 2) {

					/*
					 * As the words are checked in the descending order of their
					 * length the first valid concatenated word is the longest
					 * concatenated word the second valid concatenated word is
					 * the second largest concatenated word
					 */

					if (resultCount == 1) {
						System.out.println("Longest Concatenated Word: " + inputWords[i]);
						resultCount++;
						continue;
					}else if (resultCount == 2) {
						System.out.println("Second Longest Concatenated Word: " + inputWords[i]);
						resultCount++;
					}
				}

			}
		}
		System.out.println("Number of concatenated words in the file: " + concatenatedWords);

	}

	/*
	 * This method checks whether the word is  valid concatenated word
	 * @param word
	 * @param length
	 * @returns true if the word is 
	 */
	public boolean checkValidConcatenatedWord(String word, int length) {

		int nlen = word.length();
		
		//base case for recursion
		if (nlen == 0) {
			return true;
		}

		String subString;
		
		//checking each substring starting from left
		for (int i = 1; i <= nlen; i++) {
			
			//reached end of word
			if (i == length) {
				return false;
			}
			subString = word.substring(0, i);
			if (inputSet.contains(subString)) {
				if (checkValidConcatenatedWord(word.substring(i), length)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * This method reads the list of words from the file
	 * @param args
	 * @throws IOException
	 * @returns the content of the file
	 */
	private String readFile(String args[]) throws IOException {

		File testFile = new File(args[0]);

		BufferedInputStream bs = new BufferedInputStream(new FileInputStream(testFile));
		byte[] fileData = new byte[(int) testFile.length()];
		bs.read(fileData);
		bs.close();
		String content = new String(fileData, "UTF-8").trim();
		return content;
	}
}
