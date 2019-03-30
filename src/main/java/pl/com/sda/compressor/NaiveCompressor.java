package pl.com.sda.compressor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NaiveCompressor implements Compressor {

    public NaiveCompressor() {
        // empty
    }

    // @Override
    public String compress2(String sms) {
        if (sms == null || sms.isEmpty()) return "";
        String[] splitted = sms.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String str : splitted) {
            sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    @Override
    public String compress(String sms) {
        if (sms == null) return "";
        return Arrays.stream(sms.split(" "))
                .map(word -> word.length() > 0 ? word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
                        : word)
                .collect(Collectors.joining(""));

    }

//    @Override
    public String uncompress2(String input) {
        if (input == null || input.isEmpty()) return "";
        String[] camelCaseWords = input.split("(?=\\p{Lu})");
        for (int i = 0; i < camelCaseWords.length; i++) {
            camelCaseWords[i] = camelCaseWords[i].toLowerCase();
        }
        return String.join(" ", camelCaseWords);
    }

    @Override
    public String uncompress(String input) {
        if (input == null) return "";
        return Arrays.stream(input.split("(?=\\p{Lu})"))
                .map(String::toLowerCase)
                .collect(Collectors.joining(" "));
    }
}
