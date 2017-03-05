/**
 * 
 */
package com.go.jek.logic.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.go.jek.constants.Constants;
import com.go.jek.pojo.Car;
import com.go.jek.pojo.Slot;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class ParkingLotExecutorEngineImpl implements ParkingLotExecutorEngine {

	/**
	 * Slot car address reference
	 */
	private Map<Car, Integer> slotCarAddress;

	/**
	 * reverse slot car address reference
	 */
	private Map<Integer, Car> reversesSlotCarAddress;

	/**
	 * Min distance reference
	 */
	private TreeSet<Integer> minDistance;

	/**
	 * Constructor to initialize reference
	 * 
	 * @param slotCarAddress
	 * @param storeEmptyLocation
	 */
	public ParkingLotExecutorEngineImpl() {
		super();
		this.slotCarAddress = new HashMap<Car, Integer>();
		this.reversesSlotCarAddress = new HashMap<Integer, Car>();
		this.minDistance = new TreeSet<Integer>();
	}

	/**
	 * Method to create parking lot
	 * 
	 * @param parsedData
	 */
	@Override
	public void createParkingLot(String[] parsedData) {
		for (int counter = 1; counter <= Integer.parseInt(parsedData[Constants.ONE]); counter++) {
			minDistance.add(counter);
		}
		System.out.println("Created a parking lot with " + minDistance.size() + " slots");
	}

	/**
	 * Method to park cars
	 * 
	 * @param parsedData
	 */
	@Override
	public void park(String[] parsedData) {
		Car car = new Car();
		car.setRegistrationNo(parsedData[Constants.ONE]);
		car.setColour(parsedData[Constants.TWO]);
		Integer carAddress = slotCarAddress.get(car);
		if (carAddress != null) {
			System.out.println("You car is already parked at location:" + carAddress);
			return;
		}
		Integer leastDistance = minDistance.pollFirst();
		if (leastDistance != null) {
			slotCarAddress.put(car, leastDistance);
			reversesSlotCarAddress.put(leastDistance, car);
			System.out.println("Allocated slot number: " + leastDistance);
		} else {
			System.out.println("Sorry, parking lot is full");
		}
	}

	/**
	 * Method for leaving cars
	 * 
	 * @param parsedData
	 */
	@Override
	public void leave(String[] parsedData) {
		Car car = reversesSlotCarAddress.get(Integer.valueOf(parsedData[Constants.ONE]));
		if (car == null) {
			System.out.println("No car present at slot:" + parsedData[Constants.ONE]);
		} else {
			slotCarAddress.remove(car);
			reversesSlotCarAddress.remove(Integer.valueOf(parsedData[Constants.ONE]));
			minDistance.add(Integer.valueOf(parsedData[Constants.ONE]));
			System.out.println("Slot number " + parsedData[Constants.ONE] + " is free");
		}

	}

	/**
	 * Method to find registration number for car with colour
	 * 
	 * @param parsedData
	 */
	@Override
	public void registrationNoForCarWithColour(String[] parsedData) {
		if (isSlotAddressEmpty()) {
			return;
		}
		int counter = 0;
		for (Map.Entry<Car, Integer> entry : slotCarAddress.entrySet()) {
			Car car = entry.getKey();
			if (car.getColour().equals(parsedData[Constants.ONE])) {
				System.out.println(car.getRegistrationNo());
				counter++;
			}
		}
		notFound(counter);
	}

	/**
	 * Method to fins slot number for cars with color
	 * 
	 * @param parsedData
	 */
	@Override
	public void slotNoForCarWithColour(String[] parsedData) {
		if (isSlotAddressEmpty()) {
			return;
		}
		int counter = 0;
		for (Map.Entry<Car, Integer> entry : slotCarAddress.entrySet()) {
			Car car = entry.getKey();
			if (car.getColour().equals(parsedData[Constants.ONE])) {
				System.out.println(entry.getValue());
				counter++;
			}
		}
		notFound(counter);
	}

	/**
	 * Method to find status
	 * 
	 * @param parsedData
	 */
	@Override
	public void status() {
		System.out.println("No\tRegistration Slot No.\tColour");
		if (isSlotAddressEmpty()) {
			return;
		}
		List<Slot> listOfSlot = new ArrayList<Slot>();
		for (Map.Entry<Car, Integer> entry : slotCarAddress.entrySet()) {
			Car car = entry.getKey();
			Slot slot = new Slot();
			slot.setSlotId(entry.getValue());
			slot.setSlotAllocatedToCar(car);
			listOfSlot.add(slot);
		}
		Collections.sort(listOfSlot, (o1, o2) -> o1.getSlotId().compareTo(o2.getSlotId()));
		for (Slot slot : listOfSlot) {
			System.out.println(slot.getSlotId() + "\t" + slot.getSlotAllocatedToCar().getRegistrationNo() + "\t\t" + slot.getSlotAllocatedToCar().getColour());
		}

	}

	/**
	 * Method to find slot no for registration no
	 * 
	 * @param parsedData
	 */
	@Override
	public void slotNoForRegistrationNo(String[] parsedData) {
		if (isSlotAddressEmpty()) {
			return;
		}
		int counter = 0;
		for (Map.Entry<Car, Integer> entry : slotCarAddress.entrySet()) {
			Car car = entry.getKey();
			if (car.getRegistrationNo().equals(parsedData[Constants.ONE])) {
				System.out.println(entry.getValue());
				counter++;
			}
		}
		notFound(counter);
	}

	/**
	 * Method to find if the slot address is empty or not
	 * 
	 */
	private Boolean isSlotAddressEmpty() {
		if (slotCarAddress.size() == 0) {
			System.out.println("No car are present in the parking slot");
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * Method implementing not found
	 * 
	 */
	private void notFound(int counter) {
		if (counter == 0) {
			System.out.println("Not Found");
		}
	}
}
