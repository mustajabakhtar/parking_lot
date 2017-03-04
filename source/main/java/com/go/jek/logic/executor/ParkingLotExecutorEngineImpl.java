/**
 * 
 */
package com.go.jek.logic.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.go.jek.constants.Constants;
import com.go.jek.pojo.Car;

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
	public void status(String[] parsedData) {

	}

	/**
	 * @param parsedData
	 */
	@Override
	public void slotNoForRegistrationNo(String[] parsedData) {
	  Integer slot =slotCarAddress.get(parsedData[1]);
	  if(slot!=null){
		  System.out.println(slot); 
	  }else{
		  System.out.println("Not found");
	  }
     
	}
}
