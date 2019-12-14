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
		lnum =	Arrays.stream(pattern.split("\\s"))
				.map(word -> words.getOrDefault(word, new HashSet<Integer>()))
				.reduce((s1,s2) -> {
					s2.retainAll(s1);
					return new HashSet<>(s2);})
				.get();
	}

}
