/**
 * 
 */
package com.go.jek.command.parser;

import com.go.jek.command.manager.CommandManager;
import com.go.jek.command.validator.CommandValidator;
import com.go.jek.constants.Constants;
import com.go.jek.pojo.Command;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class CommandParserImpl implements CommandParser {

	/**
	 * Command manager reference
	 */
	private CommandManager commandManager;

	/**
	 * Command validator reference
	 */
	private CommandValidator validator;

	/**
	 * Constructor to initialize command manager and validator
	 * 
	 * @param commandManager
	 */
	public CommandParserImpl(CommandManager commandManager, CommandValidator validator) {
		super();
		this.commandManager = commandManager;
		this.validator = validator;
	}

	/**
	 * Method to implement the command parser
	 * 
	 * @param command
	 */
	@Override
	public void parse(String command) {
		String[] splittedCommand = command.split(" ");
		if (splittedCommand.length > Constants.SYNTAX_LENGTH)
			System.out.println(Constants.INVALID_SYNTAX);
		Command validatorResponse = validator.validate(splittedCommand);
		if (validatorResponse != Command.INVALID_SYNTAX)
			commandManager.commandDirector(validatorResponse, splittedCommand);
	}
}
