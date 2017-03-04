/**
 * 
 */
package com.go.jek.command.validator;

import com.go.jek.constants.Constants;
import com.go.jek.pojo.Command;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class CommandValidatorImpl implements CommandValidator {

	/**
	 * Validate the command
	 * 
	 * @param command
	 * @return
	 */
	@Override
	public Command validate(String[] command) {
		try {
			if (command.length == Constants.ONE) {
				if (command[Constants.ZERO].equals(Constants.STATUS)) {
					return Command.STATUS;
				}

			} else if (command.length == Constants.TWO) {

				if (command[Constants.ZERO].equals(Constants.CREATE_PARKING_LOT) && validateValue(command[Constants.ONE], "IntegerType")) {
					return Command.CREATE_PARKING_LOT;
				} else if (command[Constants.ZERO].equals(Constants.LEAVE) && validateValue(command[Constants.ONE], "IntegerType")) {
					return Command.LEAVE;
				} else if (command[Constants.ZERO].equals(Constants.REGISTRATION_NO_FOR_CAR_WITH_COLOUR) && validateValue(command[Constants.ONE], "RegEx")) {
					return Command.REGISTRATION_NO_FOR_CAR_WITH_COLOUR;
				} else if (command[Constants.ZERO].equals(Constants.SLOT_NO_FOR_CAR_WITH_COLOUR)) {
					return Command.SLOT_NO_FOR_CAR_WITH_COLOUR;
				} else if (command[Constants.ZERO].equals(Constants.SLOT_NO_FOR_REGISTRATION_NO) && validateValue(command[Constants.ONE], "RegEx")) {
					return Command.SLOT_NO_FOR_REGISTRATION_NO;
				}

			} else if (command.length == Constants.THREE) {

				if (command[Constants.ZERO].equals(Constants.PARK)) {
					return Command.PARK;
				}
			}
		} catch (Exception ex) {
			return Command.INVALID_SYNTAX;
		}
		return Command.INVALID_SYNTAX;
	}

	/**
	 * @param value
	 * @param type
	 * @return
	 */
	private Boolean validateValue(String value, String type) {
		switch (type) {
		case "IntegerType":
			if (Integer.valueOf(value) instanceof Integer)
				return Boolean.TRUE;
		case "StringType":
			return Boolean.TRUE;
		case "RegEx":
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
