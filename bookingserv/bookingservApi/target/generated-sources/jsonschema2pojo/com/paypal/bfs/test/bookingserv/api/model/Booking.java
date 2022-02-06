
package com.paypal.bfs.test.bookingserv.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "check_in",
    "check_out",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;
    /**
     * Date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date of birth")
    private String dateOfBirth;
    /**
     * Check in
     * (Required)
     * 
     */
    @JsonProperty("check_in")
    @JsonPropertyDescription("Check in")
    private Date checkIn;
    /**
     * Check out
     * (Required)
     * 
     */
    @JsonProperty("check_out")
    @JsonPropertyDescription("Check out")
    private Date checkOut;
    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price")
    private Integer totalPrice;
    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit")
    private Integer deposit;
    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Check in
     * (Required)
     * 
     */
    @JsonProperty("check_in")
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * Check in
     * (Required)
     * 
     */
    @JsonProperty("check_in")
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Check out
     * (Required)
     * 
     */
    @JsonProperty("check_out")
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Check out
     * (Required)
     * 
     */
    @JsonProperty("check_out")
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkIn");
        sb.append('=');
        sb.append(((this.checkIn == null)?"<null>":this.checkIn));
        sb.append(',');
        sb.append("checkOut");
        sb.append('=');
        sb.append(((this.checkOut == null)?"<null>":this.checkOut));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
