package by.itstep.pronovich.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authors")
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tariff_id", unique = true, nullable = false)
	private Long id;
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	@NotNull
	@Size(min = 3, max = 20)
	private String operator;
	@NotNull
	private Double subscriptionFee;
	@NotNull
	private String description;

	public Tariff() {
		super();
	}

	public Tariff(Long id, String name, String operator, Double subscriptionFee, String description) {
		this.id = id;
		this.name = name;
		this.operator = operator;
		this.subscriptionFee = subscriptionFee;
		this.description = description;
	}

	public Tariff(String name, String operator, Double subscriptionFee, String description) {
		this.name = name;
		this.operator = operator;
		this.subscriptionFee = subscriptionFee;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Double getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(Double subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((subscriptionFee == null) ? 0 : subscriptionFee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tariff other = (Tariff) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (subscriptionFee == null) {
			if (other.subscriptionFee != null)
				return false;
		} else if (!subscriptionFee.equals(other.subscriptionFee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tariff [id=" + id + ", name=" + name + ", operator=" + operator + ", subscriptionFee=" + subscriptionFee
				+ ", description=" + description + "]";
	}

}
