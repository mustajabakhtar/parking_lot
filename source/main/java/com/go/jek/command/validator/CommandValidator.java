/**
 * 
 */
package com.go.jek.command.validator;

import com.go.jek.pojo.Command;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public interface CommandValidator {

	/**
	 * @param command
	 * @return
	 */
	Command validate(String[] command);

}
