package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AllOption extends Searcher {

	@Override
	protected void setLnum(String pattern) {
		Stream <String> str = Arrays.stream(pattern.split("\\s"));
		long pCount = str.count();
		Stream<?> ii = str.map(word -> words.getOrDefault(word, Set.of()).stream());
				//.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
				
		

	}

}
