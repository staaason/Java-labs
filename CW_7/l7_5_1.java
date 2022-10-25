import Text.*;

import java.util.ArrayList;
import java.util.List;


public class l7_5_1 {
    public static void main(String[] args){
        Word word1 = new Word("hello");
        Word word2 = new Word("my");
        Word word3 = new Word("word");
        List<Word> words = new ArrayList<Word>(){
            {
                add(word1);
                add(word2);
                add(word3);
            }
        };
        Sentence sentence1 = new Sentence(words);
        Sentence sentence2 = new Sentence(words);
        Sentence sentence3 = new Sentence(words);
        List<Sentence> sentences = new ArrayList<Sentence>(){
            {
                add(sentence1);
                add(sentence2);
                add(sentence3);
            }
        };
        Text text = new Text(sentences);
        Text text2 = new Text(sentences);
        System.out.println(text);
        System.out.println(text.equals(text2));
        System.out.println(text.hashCode());
    }

}
