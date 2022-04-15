package com.codingdojo.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Size(min = 2, max = 200, message="The name must be over 2 charaters long")
    private String expenseName;
    
    @NotNull
    @Size(min = 5, max = 200, message="The Vendor must be over 5 charaters long")
    private String vendor;
    
    @NotNull
    @Size(min = 1, max = 100, message="The Description must be over 1 charaters long")
    private String description;
    
    @NotNull
    @Max(value = 1000, message="Cannot cost more than 1000")
    @Min(value = 0, message="Cannot cost less than 0")
    private Integer amount;
    // This will not allow the createdAt column to be updated after creation
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Expense() {
    }
    
    public Expense(String expenseName, String vendor, String description, int amount) {
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }
    
    
    public Expense(Long id, @NotNull @Size(min = 5, max = 200) String expenseName,
			@NotNull @Size(min = 5, max = 200) String vendor, @NotNull @Size(min = 3, max = 200) String description,
			@NotNull @Min(100) Integer amount, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.description = description;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
	
}
