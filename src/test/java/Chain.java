import java.util.ArrayList;
import java.util.List;

public class Chain {
    public List<String> lines = new ArrayList<String>();

    public Chain add(String line) {
        lines.add(line);
        return this; // wskazuje na obiekt w którym sie znajdujemy
    }
}
