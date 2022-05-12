package com.icloud.converter.converter;

import com.icloud.converter.value.Money;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, String> {


    @Override
    public String convertToDatabaseColumn(Money money) {
        return money == null ?
                null :
                money.getValue() + money.getCurrency();
    }

    @Override
    public Money convertToEntityAttribute(String value) {
        return value == null ?
                null :
                new Money(Integer.parseInt(value.split("원")[0]), "원");
    }
}
