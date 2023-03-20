import java.util.*;
import java.util.stream.Stream;

public class LambdasAndStreams{
	public static void main(String[] args){
		List<String> strings = List.of("I", "am", "a", "list", "of", "strings");
		Stream<String> stream = strings.stream();

		stream.forEach(str -> System.out.println(str));


		//////// we already consumed the stream to iterate over strings, so we need to create another stream with stream() method
		Stream<String> limit = strings.stream().limit(4); //this is intermediate method on stream which returns a stream
		long result = limit.count(); //this is a terminal method
		System.out.println(result);

	}
}