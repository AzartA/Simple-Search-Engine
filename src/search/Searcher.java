package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Searcher {
	Set<Integer> lnum;
	Map <String, Set<Integer>> words;
	String[] sourse;
	
	protected abstract void setLnum(String pattern);
	
	public String search(String match, String[] sourse) {
		if("".equals(match)) return "Empty line!";
		this.sourse = sourse;
		words = makeInvertedIndex(sourse);
		setLnum(match.toLowerCase());
		if(lnum == null || lnum.size()== 0) return "No matching people found.\n";
		return makeRes();
	}
	
	private String makeRes() {
		StringBuilder sb = new StringBuilder();
		sb.append(lnum.size());
		sb.append(" persons found:");
		sb.append(System.lineSeparator());
		for(Integer l: lnum) {
			sb.append(sourse[l]);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	private Map <String, Set<Integer>> makeInvertedIndex(String[] sourseLines) {
		Map <String, Set<Integer>> words = new HashMap<>();
		for(int i = 0; i<sourseLines.length;i++) {
			for (String l:sourseLines[i].split("\\s")) {
				int i1 = i;
				words.compute(l.toLowerCase(), (k,v) -> {
					if(v==null) {
						Set<Integer> set1 = new HashSet<Integer>(5);
						set1.add(i1); 
						return set1;
					}else {
						v.add(i1);
						return v;
					}
				});
			}
		}
		return words;	
	}
	
}
