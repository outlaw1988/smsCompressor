package pl.com.sda;

import org.assertj.core.util.BigDecimalComparator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class CostCalculatorTest {

    @Test
    public void testCalculateCost1() {
        CostCalculator calculator = new CostCalculator(new BigDecimal(2));
        assertThat(calculator.calculate(4)).usingComparator(new BigDecimalComparator()).
                isEqualTo(new BigDecimal(8));
    }

    @Test
    public void testCalculateCost2() {
        CostCalculator calculator = new CostCalculator(new BigDecimal(1.5));
        assertThat(calculator.calculate(4)).usingComparator(new BigDecimalComparator()).
                isEqualTo(new BigDecimal(6));
    }

}