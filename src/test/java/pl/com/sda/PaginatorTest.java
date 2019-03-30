package pl.com.sda;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PaginatorTest {

    @Test
    public void testSimplePhrase1() {
        Paginator paginator = new Paginator(5);
        List<String> splittedPhrase = paginator.paginate("Ala ma kota");
        assertThat(splittedPhrase.get(0)).isEqualTo("Ala m");
        assertThat(splittedPhrase.get(1)).isEqualTo("a kot");
        assertThat(splittedPhrase.get(2)).isEqualTo("a");
    }

    @Test
    public void testSimplePhrase2() {
        Paginator paginator = new Paginator(2);
        List<String> splittedPhrase = paginator.paginate("Mama tata");
        assertThat(splittedPhrase.get(0)).isEqualTo("Ma");
        assertThat(splittedPhrase.get(1)).isEqualTo("ma");
        assertThat(splittedPhrase.get(2)).isEqualTo(" t");
        assertThat(splittedPhrase.get(3)).isEqualTo("at");
        assertThat(splittedPhrase.get(4)).isEqualTo("a");
    }

    @Test
    public void testEmptyPhrase() {
        Paginator paginator = new Paginator(2);
        List<String> splittedPhrase = paginator.paginate("");
        assertThat(splittedPhrase.size()).isEqualTo(0);
    }

}