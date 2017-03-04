/**
 * 
 */
package com.go.jek.logic.executor;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public interface ParkingLotExecutorEngine {

	/**
	 * @param parsedData
	 */
	void createParkingLot(String[] parsedData);

	/**
	 * @param parsedData
	 */
	void park(String[] parsedData);

	/**
	 * @param parsedData
	 */
	void leave(String[] parsedData);

	/**
	 * @param parsedData
	 */
	void registrationNoForCarWithColour(String[] parsedData);

	/**
	 * @param parsedData
	 */
	void slotNoForCarWithColour(String[] parsedData);

	/**
	 * Method for status
	 */
	void status();

	/**
	 * @param parsedData
	 */
	void slotNoForRegistrationNo(String[] parsedData);

}
