package Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence{
    public Sentence(List<Word> arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(new String(""));
        for (Word str: arr) {
            output.append(str.getWord());
            output.append(" ");
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return getArr().equals(sentence.getArr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArr());
    }

    public List<Word> getArr() {
        return arr;
    }

    public void setArr(List<Word> arr) {
        this.arr = arr;
    }

    List<Word> arr = new ArrayList<>();

}
