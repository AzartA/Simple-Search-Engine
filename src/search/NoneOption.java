package search;

public class NoneOption extends Searcher {

	@Override
	protected void setLnum(String pattern) {
		lnum = words.values().stream().flatMap(m -> m.stream()).collect(Collectors.toSet());
		lnum.removeAll(
				Arrays.stream(pattern.split("\\s"))
				.flatMap(word -> words.getOrDefault(word, new HashSet<Integer>()).stream())
				.collect(Collectors.toSet())
				);

	}

}
