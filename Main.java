import java.util.*;

class WordSet{
    private Set<String> words;
    public WordSet(String s){
        words = new TreeSet<>();
        String[] wordarray = s.split("\\s+");
        words.addAll(Arrays.asList(wordarray));

    }
    public String union(WordSet other) {
        Set<String> unionSet = new TreeSet<>(words);
        unionSet.addAll(other.words);
        return String.join(" ", unionSet);
    }
    public String intersection(WordSet other) {
        Set<String> intersectionSet = new TreeSet<>(words);
        intersectionSet.retainAll(other.words);
        return String.join(" ", intersectionSet);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}