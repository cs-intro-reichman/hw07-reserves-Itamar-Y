

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		// System.out.println(dictionary[3]);
		// System.out.println(existInDictionary("wabadabdab", dictionary));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < 3000; i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {

		int dictLength = dictionary.length;
		boolean exists = false;

		for (int i = 0; i < dictLength; i++){
			String tester = dictionary[i];
			if (tester.equals(word)) {
				exists = true;
				break;
			} 
		}
		return exists;

		// if (dictionary[dictLength - 1] == word) {
		// 	return exists = true;
		// }
		// else {
		// 	dictionary = new String[dictLength - 1];
		// existInDictionary(word, dictionary);
		// }
		// return exists;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// converts hashtag into lowercase for dictionary comparison
		hashtag = hashtag.toLowerCase();

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			String str1 = hashtag.substring(0,i);
			if (existInDictionary(str1, dictionary)) {
				System.out.println(str1);
				hashtag = hashtag.substring(i);
				breakHashTag(hashtag, dictionary);
				return;
				} 
			}
        }
    }




