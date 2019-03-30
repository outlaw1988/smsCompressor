package pl.com.sda;

import java.util.ArrayList;
import java.util.List;

public class Paginator {

    private int numberOfChars;

    public Paginator(int numberOfChars) {
        this.numberOfChars = numberOfChars;
    }

    List<String> paginate(String input) {
        ArrayList<String> split = new ArrayList<>();
        if (input.isEmpty()) return split;
        for (int i = 0; i <= input.length() / numberOfChars; i++) {
            split.add(input.substring(i * numberOfChars, Math.min((i + 1) * numberOfChars, input.length())));
        }
        return split;
    }

}
