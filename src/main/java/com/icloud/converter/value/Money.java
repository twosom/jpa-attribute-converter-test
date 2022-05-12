package com.icloud.converter.value;

import javax.persistence.AttributeConverter;
import java.util.Objects;

/**
 * 보통 같으면 클래스 위에 {@link javax.persistence.Embeddable @Embeddable} 어노테이션을 붙이겠지만,
 * {@link AttributeConverter}를 이용해서 두 개 이상의 프로퍼티를 가진 밸류 타입을 한 개 칼럼에 매핑하려면 해당 어노테이션은 붙이면 안된다.
 */
public class Money {

    private int value;

    private String currency;

    protected Money() {
    }

    public Money(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getValue() == money.getValue() && Objects.equals(getCurrency(), money.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getCurrency());
    }
}
