/**
 * 
 */
package com.go.jek.command.manager;

import com.go.jek.constants.Constants;
import com.go.jek.logic.executor.ParkingLotExecutorEngine;
import com.go.jek.pojo.Command;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class CommandManagerImpl implements CommandManager {

	/**
	 * Parking lot executor reference
	 */
	private ParkingLotExecutorEngine parkingLotExecutor;

	/**
	 * Constructor to initialize parking lot executor engine
	 * 
	 * @param parkingLotExecutor
	 */
	public CommandManagerImpl(ParkingLotExecutorEngine parkingLotExecutor) {
		super();
		this.parkingLotExecutor = parkingLotExecutor;
	}

	/**
	 * Method to implement command director
	 * 
	 * @param command
	 * @param parsedData
	 */
	public void commandDirector(Command command, String[] parsedData) {
		switch (command) {
		case CREATE_PARKING_LOT:
			parkingLotExecutor.createParkingLot(parsedData);
			break;
		case PARK:
			parkingLotExecutor.park(parsedData);
			break;
		case LEAVE:
			parkingLotExecutor.leave(parsedData);
			break;
		case REGISTRATION_NO_FOR_CAR_WITH_COLOUR:
			parkingLotExecutor.registrationNoForCarWithColour(parsedData);
			break;
		case SLOT_NO_FOR_CAR_WITH_COLOUR:
			parkingLotExecutor.slotNoForCarWithColour(parsedData);
			break;
		case SLOT_NO_FOR_REGISTRATION_NO:
			parkingLotExecutor.slotNoForRegistrationNo(parsedData);
			break;
		case STATUS:
			parkingLotExecutor.status();
			break;
		default:
			System.out.println(Constants.INVALID_SYNTAX);

		}

	}

}
