package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "We learn java basics as part of java sessions in java week1";
		String splitText[] = text.split(" ");
		int i = 0;
		List<String> listOfWords = new ArrayList<String>(); //Arrays.asList(text.split(" "))
		
		while(i < splitText.length) {
			listOfWords.add(splitText[i]);
			i++;
		}
		Set<String> uniqueWords = new LinkedHashSet<String>(listOfWords);
		
		listOfWords.clear();
//		uniqueWords.forEach(uniqueWord -> listOfWords.add(uniqueWord));
		for (String uniqueWord : uniqueWords) {
			listOfWords.add(uniqueWord);
		}
		
		System.out.println("Actual text: " + text);
		System.out.println("After removing duplicates: " + listOfWords);
	}

}
