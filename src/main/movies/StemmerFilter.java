package movies;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StemmerFilter implements PipeFilter {
    private PipeFilter previousFilter;

    public StemmerFilter(PipeFilter f) {
        this.previousFilter = f;
    }

    public List<String> transformIntoRoot(List<String> input) throws IOException {
        return input
                .stream()
                .map(e -> {
                    Stemmer s = new Stemmer();
                    s.add(e.toCharArray(), e.length());
                    s.stem();
                    return s.toString();
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<String> run() throws IOException {
        List<String> input = this.previousFilter.run();
        List<String> output = this.transformIntoRoot(input);
        return output;
    }
}
