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
@Table(name = "tariffs")
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tariff_id", unique = true, nullable = false)
	private Long id;
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	@NotNull
	@Size(min = 2, max = 5)
	private String operator;
	@NotNull
	private Double subscriptionFee;
	@NotNull
	@Size(min = 10, max = 1000)
	private String description;
	@NotNull
	private Double callCost;
	@NotNull
	private Double smsCost;
	@NotNull
	private Double numberOfMegabytes;

	public Tariff() {
		super();
	}

	public Tariff(Long id, @NotNull @Size(min = 3, max = 20) String name,
			@NotNull @Size(min = 3, max = 20) String operator, @NotNull Double subscriptionFee,
			@NotNull String description, @NotNull Double callCost, @NotNull Double smsCost,
			@NotNull Double numberOfMegabytes) {
		super();
		this.id = id;
		this.name = name;
		this.operator = operator;
		this.subscriptionFee = subscriptionFee;
		this.description = description;
		this.callCost = callCost;
		this.smsCost = smsCost;
		this.numberOfMegabytes = numberOfMegabytes;
	}

	public Tariff(@NotNull @Size(min = 3, max = 20) String name, @NotNull @Size(min = 3, max = 20) String operator,
			@NotNull Double subscriptionFee, @NotNull String description, @NotNull Double callCost,
			@NotNull Double smsCost, @NotNull Double numberOfMegabytes) {
		super();
		this.name = name;
		this.operator = operator;
		this.subscriptionFee = subscriptionFee;
		this.description = description;
		this.callCost = callCost;
		this.smsCost = smsCost;
		this.numberOfMegabytes = numberOfMegabytes;
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

	public Double getCallCost() {
		return callCost;
	}

	public void setCallCost(Double callCost) {
		this.callCost = callCost;
	}

	public Double getSmsCost() {
		return smsCost;
	}

	public void setSmsCost(Double smsCost) {
		this.smsCost = smsCost;
	}

	public Double getNumberOfMegabytes() {
		return numberOfMegabytes;
	}

	public void setNumberOfMegabytes(Double numberOfMegabytes) {
		this.numberOfMegabytes = numberOfMegabytes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callCost == null) ? 0 : callCost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberOfMegabytes == null) ? 0 : numberOfMegabytes.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((smsCost == null) ? 0 : smsCost.hashCode());
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
		if (callCost == null) {
			if (other.callCost != null)
				return false;
		} else if (!callCost.equals(other.callCost))
			return false;
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
		if (numberOfMegabytes == null) {
			if (other.numberOfMegabytes != null)
				return false;
		} else if (!numberOfMegabytes.equals(other.numberOfMegabytes))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (smsCost == null) {
			if (other.smsCost != null)
				return false;
		} else if (!smsCost.equals(other.smsCost))
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
				+ ", description=" + description + ", callCost=" + callCost + ", smsCost=" + smsCost
				+ ", numberOfMegabytes=" + numberOfMegabytes + "]";
	}

}
