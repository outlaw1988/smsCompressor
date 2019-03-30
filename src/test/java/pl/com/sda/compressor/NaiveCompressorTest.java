package pl.com.sda.compressor;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class NaiveCompressorTest {

    private NaiveCompressor naiveCompressor;

    @Before
    public void before() {
        naiveCompressor = new NaiveCompressor();
    }

    @Test
    public void testCompressSimple1() {
        String phrase = "Ala ma kota";
        assertThat(naiveCompressor.compress(phrase)).isEqualTo("AlaMaKota");
    }

    @Test
    public void testCompressSimple2() {
        String phrase = "Stół z powyłamywanymi nogami";
        assertThat(naiveCompressor.compress(phrase)).isEqualTo("StółZPowyłamywanymiNogami");
    }

    @Test
    public void testMixedCase() {
        String phrase = "aLA mA kOtA";
        assertThat(naiveCompressor.compress(phrase)).isEqualTo("AlaMaKota");
    }

    @Test
    public void testCompressEmpty() {
        String phrase = "";
        assertThat(naiveCompressor.compress(phrase)).isEqualTo("");
    }

    @Test
    public void testCompressOneLetter() {
        String phrase = "a";
        assertThat(naiveCompressor.compress(phrase)).isEqualTo("A");
    }

    @Test
    public void testUncompress1() {
        String phrase = "AlaMaKota";
        assertThat(naiveCompressor.uncompress(phrase)).isEqualTo("ala ma kota");
    }

    @Test
    public void testUncompress2() {
        String phrase = "ConvertArrayOfStrings";
        assertThat(naiveCompressor.uncompress(phrase)).isEqualTo("convert array of strings");
    }

    @Test
    public void testUncompressUnicode() {
        String phrase = "ŻycieŻycieJestNowelą";
        assertThat(naiveCompressor.uncompress(phrase)).isEqualTo("życie życie jest nowelą");
    }

    @Test
    public void testEmptyUncompress() {
        String phrase = "";
        assertThat(naiveCompressor.uncompress(phrase)).isEqualTo("");
    }

}