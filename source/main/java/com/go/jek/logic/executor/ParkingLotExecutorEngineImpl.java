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
	 * 
	 */
	private Map<Car, Integer> slotCarAddress;

	/**
	 * 
	 */
	private Map<Integer, Car> reversesSlotCarAddress;

	/**
	 * 
	 */
	private TreeSet<Integer> minDistance;

	/**
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
			System.out.println("Slot number " + parsedData[Constants.ONE] + " is free");
		}

	}

	/**
	 * @param parsedData
	 */
	@Override
	public void registrationNoForCarWithColour(String[] parsedData) {

	}

	/**
	 * @param parsedData
	 */
	@Override
	public void slotNoForCarWithColour(String[] parsedData) {

	}

	/**
	 * @param parsedData
	 */
	@Override
	public void status() {
		System.out.println("No\tRegistration Slot No.\tColour");
		if (slotCarAddress.size() == 0) {
			System.out.println("No car are present in the parking slot");
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
	 * @param parsedData
	 */
	@Override
	public void slotNoForRegistrationNo(String[] parsedData) {
		Integer slot = slotCarAddress.get(parsedData[1]);
		if (slot != null) {
			System.out.println(slot);
		} else {
			System.out.println("Not found");
		}

	}
}
