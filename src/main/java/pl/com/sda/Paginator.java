package pl.com.sda;

import java.util.ArrayList;

public class Paginator {

    private int length;

    public Paginator(int length) {
        this.length = length;
    }

    String[] paginate(String input) {
        ArrayList<String> split = new ArrayList<>();

        if (input.isEmpty()) {
            return new String[0];
        }

        for (int i = 0; i <= input.length() / length; i++) {
            split.add(input.substring(i * length, Math.min((i + 1) * length, input.length())));
        }

        if (split.get(split.size() - 1).isEmpty()) {
            split.remove(split.size() - 1);
        }

        //System.out.println("Size: " + split.size());

        String[] output = new String[split.size()];
        return split.toArray(output);
    }

}
