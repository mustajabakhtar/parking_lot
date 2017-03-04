/**
 * 
 */
package com.go.jek.pojo;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class Car {

	/**
	 * 
	 */
	private String registrationNo;

	/**
	 * 
	 */
	private String colour;

	/**
	 * @return the registrationNo
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}

	/**
	 * @param registrationNo
	 *            the registrationNo to set
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour
	 *            the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationNo == null) ? 0 : registrationNo.hashCode());
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
		Car other = (Car) obj;
		if (registrationNo == null) {
			if (other.registrationNo != null)
				return false;
		} else if (!registrationNo.equals(other.registrationNo))
			return false;
		return true;
	}

}
