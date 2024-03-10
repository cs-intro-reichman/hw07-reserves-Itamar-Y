
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		str = str.substring(1);
		return str;
	}

	public static int levenshtein(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
	
		if (length1 == 0) {
			return length2;
		}
		if (length2 == 0) {
			return length1;
		}
	
		if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2));

		} else {
			int option1 = levenshtein(tail(word1), word2);        
			int option2 = levenshtein(word1, tail(word2));       
			int option3 = levenshtein(tail(word1), tail(word2));  
	
			int min = Math.min(option1, Math.min(option2, option3));
			return min +1;
		}
	}
	
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < 3000; i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	// public static String spellChecker(String word, int threshold, String[] dictionary) {

	// 	for (int i = 0; i < dictionary.length; i++) {
	// 		if (dictionary[i].equals(word)) {
	// 			return word;
	// 		} 
	// 		if (threshold >= levenshtein(word, dictionary[i])) {
	// 			word = dictionary[i];
	// 		}
	// 		if (threshold < levenshtein(word, dictionary[i])) {
	// 			return word;
	// 			}
	// 	}
	// 	return word;
	// }

	// public static String spellChecker(String word, int threshold, String[] dictionary) {
	// 	for (int i = 0; i < dictionary.length; i++) {
	// 		if (dictionary[i].equals(word)) {
	// 			return word;
	// 		}
	
	// 		int distance = levenshtein(word, dictionary[i]);
	
	// 		if (threshold >= distance) {
	// 			word = dictionary[i];
	// 		}
	// 	}
	// 	return word;
	// }

	// public static String spellChecker(String word, int threshold, String[] dictionary) {
	// 	for (int i = 0; i < dictionary.length; i++) {
	// 		if (dictionary[i].equals(word)) {
	// 			return word;
	// 		}
	
	// 		int distance = levenshtein(word, dictionary[i]);
	
	// 		if (distance < levenshtein(word, dictionary[i]) && distance <= threshold) {
	// 			word = dictionary[i];
	// 		}
	// 	}
	// 	return word;
	// }

	// public static String spellChecker(String word, int threshold, String[] dictionary) {
	// 	int minDistance = Integer.MAX_VALUE;
	// 	String closestWord = word;
	
	// 	for (int i = 0; i < dictionary.length; i++) {
	// 		if (dictionary[i].equals(word)) {
	// 			return word;
	// 		}
	
	// 		int distance = levenshtein(word, dictionary[i]);
	
	// 		if (distance <= threshold && distance < minDistance) {
	// 			minDistance = distance;
	// 			closestWord = dictionary[i];
	// 		}
	// 	}
	
	// 	return closestWord;
	// }

	// public static String spellChecker(String word, int threshold, String[] dictionary) {
	// 	int minDistance = -1;  // Initialize to a value higher than any possible Levenshtein distance
	// 	String closestWord = word;
	
	// 	for (int i = 0; i < dictionary.length; i++) {
	// 		if (dictionary[i].equals(word)) {
	// 			return word;
	// 		}
	
	// 		int distance = levenshtein(word, dictionary[i]);
	
	// 		if (minDistance == -1 || distance < minDistance) {
	// 			minDistance = distance;
	// 			closestWord = dictionary[i];
	// 		}
	// 	}
	
	// 	if (minDistance <= threshold) {
	// 		return closestWord;
	// 	} else {
	// 		return word;
	// 	}
	// }

	public static String spellChecker(String word, int threshold, String[] dictionary) {

		String closestWord = word;
	
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) {
				return word;
			}
	
			int distance = levenshtein(word, dictionary[i]);
	
			if (distance <= threshold || distance < levenshtein(word, closestWord)) {
				closestWord = dictionary[i];
			}
		}
		return closestWord;
	}
	
}
