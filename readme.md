# JPA AttributeConverter를 활용한 밸류 매핑 처리 실습

목표
---

* Order 엔티티 안에 Money라는 Embeddable 객체가 있어야 한다.
* Money 객체는 안에 int value, String currency를 가지고 있어야 한다.
* Order 엔티티가 DB에 저장될 때 Money 객체는 value 와 currency를 합친 값(예: 1000 + “원” = “1000원”)으로 저장되어야 한다.
* DB에 저장된 Order 엔티티를 불러올 때 문자열로 저장 된 value + currency 값을 Money 객체에 적절하게 할당할 수 있어야 한다.