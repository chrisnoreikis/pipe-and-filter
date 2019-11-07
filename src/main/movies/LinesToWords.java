package movies;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinesToWords implements Filter {
    @Override
    public List<String> doWork(List<String> input) throws IOException {
        return input.stream().flatMap(e -> {
            return Arrays.stream(e.replaceAll("[^A-Za-z\\s+]", "").toLowerCase().split("\\s+"));
        }).filter(e -> e.length() > 0).collect(Collectors.toList());
    }
}