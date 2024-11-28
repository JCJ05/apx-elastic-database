package com.bbva.pglu.dto.elastic.customer;

public class AddressDTO {

    private String cust_address_desc;

    public String getCust_address_desc() {
        return cust_address_desc;
    }

    public void setCust_address_desc(String cust_address_desc) {
        this.cust_address_desc = cust_address_desc;
    }

    @Override
    public String toString() {
        return "{" +
                "\"cust_address_desc\":\"" + cust_address_desc + '\"' +
                '}';

    }
}
