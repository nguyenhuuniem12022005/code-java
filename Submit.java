import java.util.Scanner;
import java.util.TreeSet;

public class Submit {
    static class WordSet {
        TreeSet<String> s = new TreeSet<>();

        public WordSet() {
        }

        // CORRECTED: Words are converted to lowercase immediately upon creation.
        public WordSet(String str) {
            String[] splitted = str.toLowerCase().split("\\s+");
            for (String i : splitted) {
                s.add(i);
            }
        }

        // SIMPLIFIED: With normalized data, union is a simple addAll.
        public WordSet union(WordSet other) {
            WordSet res = new WordSet();
            res.s.addAll(this.s);
            res.s.addAll(other.s);
            return res;
        }

        // CORRECTED & SIMPLIFIED: Intersection logic is now correct and much cleaner.
        public WordSet intersection(WordSet other) {
            WordSet res = new WordSet();
            res.s.addAll(this.s); // Start with a copy of the first set
            res.s.retainAll(other.s); // Keep only the elements that are also in the second set
            return res;
        }

        // IMPROVED: Using String.join() is more efficient and modern.
        @Override
        public String toString() {
            return String.join(" ", this.s);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    public static void main8497966(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
