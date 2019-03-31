package pl.com.sda.compressor;

import java.nio.charset.StandardCharsets;

public class OptimalCompressor implements Compressor {
    @Override
    public String compress(String sms) {
        Jsmaz jsmaz = new Jsmaz();
        return new String(jsmaz.compress(sms), StandardCharsets.ISO_8859_1);
    }

    @Override
    public String uncompress(String input) {
        Jsmaz jsmaz = new Jsmaz();
        return jsmaz.decompress(input.getBytes(StandardCharsets.ISO_8859_1));
    }
}
