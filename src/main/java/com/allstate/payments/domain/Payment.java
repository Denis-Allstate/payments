package com.allstate.payments.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
@Entity
@Table(name="cctransactions")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double amount;

	private String country;

	private String currency;

	private Date date;
    @Column(name="order_id")
	private String orderId;

	private Integer taxCode;

	private Double taxRate;

	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(Integer taxCode) {
		this.taxCode = taxCode;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Payment(Integer id, Double amount, String country, String currency, Date date, String orderId, Integer taxCode, Double taxRate, String type) {
		this.id = id;
		this.amount = amount;
		this.country = country;
		this.currency = currency;
		this.date = date;
		this.orderId = orderId;
		this.taxCode = taxCode;
		this.taxRate = taxRate;
		this.type = type;
	}

	public Payment() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Payment payment = (Payment) o;
		return Objects.equals(id, payment.id) && Objects.equals(amount, payment.amount) && Objects.equals(country, payment.country) && Objects.equals(currency, payment.currency) && Objects.equals(date, payment.date) && Objects.equals(orderId, payment.orderId) && Objects.equals(taxCode, payment.taxCode) && Objects.equals(taxRate, payment.taxRate) && Objects.equals(type, payment.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount, country, currency, date, orderId, taxCode, taxRate, type);
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", amount=" + amount +
				", country='" + country + '\'' +
				", currency='" + currency + '\'' +
				", date=" + date +
				", orderId='" + orderId + '\'' +
				", taxCode=" + taxCode +
				", taxRate=" + taxRate +
				", type='" + type + '\'' +
				'}';
	}
}
