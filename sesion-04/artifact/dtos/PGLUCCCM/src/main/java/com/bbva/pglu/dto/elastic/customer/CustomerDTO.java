package com.bbva.pglu.dto.elastic.customer;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The CustomerDTO class...
 */
public class CustomerDTO implements Serializable  {

	private String audit_date;
	private String creation_date;
	private String creation_user_id;
	private String user_audit_id;
	private String customer_id;
	private String customer_name;
	private String customer_last_name;
	private String customer_leaving_date;
	private AddressDTO address_str;
	private String years_cust_age_number;

	public String getAudit_date() {
		return audit_date;
	}

	public void setAudit_date(String audit_date) {
		this.audit_date = audit_date;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getYears_cust_age_number() {
		return years_cust_age_number;
	}

	public void setYears_cust_age_number(String years_cust_age_number) {
		this.years_cust_age_number = years_cust_age_number;
	}

	public AddressDTO getAddress_str() {
		return address_str;
	}

	public void setAddress_str(AddressDTO address_str) {
		this.address_str = address_str;
	}

	public String getCustomer_leaving_date() {
		return customer_leaving_date;
	}

	public void setCustomer_leaving_date(String customer_leaving_date) {
		this.customer_leaving_date = customer_leaving_date;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getUser_audit_id() {
		return user_audit_id;
	}

	public void setUser_audit_id(String user_audit_id) {
		this.user_audit_id = user_audit_id;
	}

	public String getCreation_user_id() {
		return creation_user_id;
	}

	public void setCreation_user_id(String creation_user_id) {
		this.creation_user_id = creation_user_id;
	}

	@Override
	public String toString() {
		return "{" +
				"\"address_str\":" + address_str.toString() +
				",\"audit_date\":\"" + audit_date + '\"' +
				",\"creation_date\":\"" + creation_date + '\"' +
				",\"creation_user_id\":\"" + creation_user_id + '\"' +
				",\"customer_id\":\"" + customer_id + '\"' +
				",\"customer_last_name\":\"" + customer_last_name + '\"' +
				",\"customer_leaving_date\":\"" + customer_leaving_date + '\"' +
				",\"customer_name\":\"" + customer_name + '\"' +
				",\"user_audit_id\":\"" + user_audit_id + '\"' +
				",\"years_cust_age_number\":\"" + years_cust_age_number + '\"' +
				'}';

	}
}
