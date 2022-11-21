package Text;

import java.util.Objects;

public class Word{
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private  String word;

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }



    public Word(String word) {
        this.word = word;
    }
}
