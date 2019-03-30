package pl.com.sda;

import java.math.BigDecimal;

public class CostCalculator {

    private final BigDecimal oneSmsCost;

    public CostCalculator(BigDecimal oneSmsCost) {
        this.oneSmsCost = oneSmsCost;
    }

    BigDecimal calculate(int smsCount) {
        return oneSmsCost.multiply(new BigDecimal(smsCount));
    }

}
