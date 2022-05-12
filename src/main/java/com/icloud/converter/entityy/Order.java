package com.icloud.converter.entityy;

import com.icloud.converter.value.Money;
import com.icloud.converter.value.OrderNo;

import javax.persistence.*;

@Entity
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId
    private OrderNo number;

    /**
     * 두 개 이상의 프로퍼티를 가진 밸류 타입을 한 개 칼럼에 매핑하려면 {@link Embeddable @Embeddable} 애너테이션으로는 처리 불가.<br/>
     * {@link Money} 클래스 안에 {@link Embeddable @Embeddable} 애너테이션을 붙이면 {@link AttributeConverter}가 동작하지 않는다.<br/>
     * <sup>이거때문에 엄청 헤맴....</sup><br/>
     * IntelliJ 상에서 컴파일 에러가 나는 것은 무시하자...
     */
    @Column(name = "total_amounts")
    private Money totalAmounts;

    public OrderNo getNumber() {
        return number;
    }

    public Money getTotalAmounts() {
        return totalAmounts;
    }

    public Order(OrderNo number, Money totalAmounts) {
        this.number = number;
        this.totalAmounts = totalAmounts;
    }

    protected Order() {
    }
}
