/**
 * 
 */
package com.go.jek.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.go.jek.command.manager.CommandManager;
import com.go.jek.command.manager.CommandManagerImpl;
import com.go.jek.command.parser.CommandParser;
import com.go.jek.command.parser.CommandParserImpl;
import com.go.jek.command.validator.CommandValidator;
import com.go.jek.command.validator.CommandValidatorImpl;
import com.go.jek.logic.executor.ParkingLotExecutorEngine;
import com.go.jek.logic.executor.ParkingLotExecutorEngineImpl;

/**
 * @author Mustajab Akhtar
 * @since 1.0
 */
public class ParkingLot {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Call method to read resource file
		readResourceFile("file_inputs.txt");

	}

	/**
	 * Method to read the resource file and direct it to command manager
	 * 
	 * @param fileName
	 */
	private static void  readResourceFile(String fileName) {
		ClassLoader classLoader = ParkingLot.class.getClassLoader();
		// Parking lot engine initialization
		ParkingLotExecutorEngine ParkingLotExecutorEngine = new ParkingLotExecutorEngineImpl();
		// Command manager initialization
		CommandManager commandManager = new CommandManagerImpl(ParkingLotExecutorEngine);
		// Validator initialization
		CommandValidator commandValidator = new CommandValidatorImpl();
		// Command parser initialization
		CommandParser parser = new CommandParserImpl(commandManager, commandValidator);
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			System.out.println("---------------------OUTPUT--------------------------");

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.isEmpty())
					continue;
				// System.out.println(line);
				parser.parse(line);
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
		System.out.println("------------------------------------------------------");
	}

}
