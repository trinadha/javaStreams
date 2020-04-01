import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJavaStreams {

	public static void main(String a[]) {

		
		List<String> names = Arrays.asList("Anna", "Bob", "Carolina", "Denis", "Anna", "Jack", "Marketa", "Simon", "Anna");
		//before java 8
		for (String name: names){
		    if (name.equalsIgnoreCase("Anna")){
		        System.out.print(name);
		    }
		}
		System.out.println();
		//Java 8
		names.stream().forEach(k -> System.out.print(k));
		System.out.println();
		names.stream().filter(k -> k.equalsIgnoreCase("Anna")).forEach(k -> System.out.print(k));
		System.out.println();
		//Create streams
		final List<String> namesCollection = Arrays.asList("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
		Stream<String> namesStream = namesCollection.stream();
		System.out.println(namesStream);

		//Generating streams
		IntStream rangeStream = IntStream.range(1, 10);
		rangeStream.forEach(k -> System.out.print(k));
		System.out.println();
		System.out.println(isPalindromeRecursive("asd3dsa"));
		System.out.println(isPalindromeUsingIntStream("asd3dsa"));
		
	}

	public static boolean isPalindromeUsingIntStream(String text) {
	    String temp  = text.replaceAll("\\s+", "").toLowerCase();
	    return IntStream.range(0, temp.length() / 2)
	      .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
	}
	
	public static boolean isPalindromeRecursive(String text){
	    String clean = text.replaceAll("\\s+", "").toLowerCase();
	    return recursivePalindrome(clean,0,clean.length()-1);
	}
	 
	private static boolean recursivePalindrome(String text, int forward, int backward) {
	    if (forward == backward) {
	        return true;
	    }
	    if ((text.charAt(forward)) != (text.charAt(backward))) {
	        return false;
	    }
	    if (forward < backward + 1) {
	        return recursivePalindrome(text, forward + 1, backward - 1);
	    }
	 
	    return true;
	}
}
