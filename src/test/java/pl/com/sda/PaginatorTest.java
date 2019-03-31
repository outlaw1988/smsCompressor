package pl.com.sda;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PaginatorTest {

    @Test
    public void testSimplePhrase1() {
        Paginator paginator = new Paginator(5);
        String[] splittedPhrase = paginator.paginate("Ala ma kota");
        assertThat(splittedPhrase[0]).isEqualTo("Ala m");
        assertThat(splittedPhrase[1]).isEqualTo("a kot");
        assertThat(splittedPhrase[2]).isEqualTo("a");
    }

    @Test
    public void testSimplePhrase2() {
        Paginator paginator = new Paginator(2);
        String[] splittedPhrase = paginator.paginate("Mama tata");
        assertThat(splittedPhrase[0]).isEqualTo("Ma");
        assertThat(splittedPhrase[1]).isEqualTo("ma");
        assertThat(splittedPhrase[2]).isEqualTo(" t");
        assertThat(splittedPhrase[3]).isEqualTo("at");
        assertThat(splittedPhrase[4]).isEqualTo("a");
    }

    @Test
    public void testEmptyPhrase() {
        Paginator paginator = new Paginator(2);
        String[] splittedPhrase = paginator.paginate("");
        assertThat(splittedPhrase.length).isEqualTo(0);
    }

}