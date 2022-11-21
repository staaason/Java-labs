package Text;

import java.util.List;
import java.util.Objects;

public class Text {
    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text = (Text) o;
        return Objects.equals(getSentences(), text.getSentences());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Sentence sentence: sentences) {
            output.append(sentence);

        }
        output.deleteCharAt(output.length() - 1);
        return "Text{" + output + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSentences());
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    private List<Sentence> sentences;

}
