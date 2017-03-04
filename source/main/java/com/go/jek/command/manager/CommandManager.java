/**
 * 
 */
package com.go.jek.command.manager;

import com.go.jek.pojo.Command;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public interface CommandManager {

	/**
	 * @param command
	 * @param parsedData
	 */
	void commandDirector(Command command, String[] parsedData);
}
