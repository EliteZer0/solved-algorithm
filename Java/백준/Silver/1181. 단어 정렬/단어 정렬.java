import java.util.*;
import java.io.*;

public class Main {
    static class Word implements Comparable<Word> {
        private String word;
        private int length;

        public Word(String word, int length){
            this.word = word;
            this.length = length;
        }

        @Override
        public int compareTo(Word w){
            if (this.length>w.length) return 1;
            else if (this.length<w.length) return -1;
            else return this.word.compareTo(w.word);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Word> words = new ArrayList<>();
        for(int i = 0; i<N; i++){
            String input = br.readLine();
            Word newWord = new Word(input, input.length());
            words.add(newWord);
        }

        Collections.sort(words);

        List<String> noDuplicates = new ArrayList<>();

        for (Word w : words) {
            if(noDuplicates.size() == 0) {
                noDuplicates.add(w.word);
                continue;
            }
            String last = noDuplicates.get(noDuplicates.size()-1);
            String input = w.word;
            if(last.equals(input)) continue;
            else noDuplicates.add(w.word);
        }
        
        
        for (String str : noDuplicates) {
            System.out.println(str);
        }
    }
}