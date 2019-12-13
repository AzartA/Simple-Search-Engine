package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class AnyOption extends Searcher {

	@Override
	protected void setLnum(String pattern) {
		lnum = Arrays.stream(pattern.split("\\s"))
					.flatMap(word -> 
								words.getOrDefault(word, new HashSet<Integer>())
							.stream())
					.collect(Collectors.toSet());
		

	}

}
