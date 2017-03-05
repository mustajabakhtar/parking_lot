/**
 * 
 */
package com.go.jek.pojo;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class Slot {

	/**
	 * Reference for slot id
	 */
	private Integer slotId;

	/**
	 * Reference for slot allocated to car
	 */
	private Car slotAllocatedToCar;

	/**
	 * @return the slotId
	 */
	public Integer getSlotId() {
		return slotId;
	}

	/**
	 * @param slotId
	 *            the slotId to set
	 */
	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	/**
	 * @return the slotAllocatedToCar
	 */
	public Car getSlotAllocatedToCar() {
		return slotAllocatedToCar;
	}

	/**
	 * @param slotAllocatedToCar
	 *            the slotAllocatedToCar to set
	 */
	public void setSlotAllocatedToCar(Car slotAllocatedToCar) {
		this.slotAllocatedToCar = slotAllocatedToCar;
	}

}
