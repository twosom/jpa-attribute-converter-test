package com.icloud.converter.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderNo implements Serializable {

    @Column(name = "order_id")
    private String id;

    public OrderNo(String id) {
        this.id = id;
    }

    protected OrderNo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderNo orderNo = (OrderNo) o;
        return Objects.equals(id, orderNo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
