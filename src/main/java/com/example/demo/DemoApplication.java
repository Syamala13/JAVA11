package com.example.demo;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		// JRF

//    	//Demonstarting JFR
//    	 Path recordingPath = Paths.get("D:\\TESTING\\recording.jfr");
//         
//         // Create a new recording
//         try (Recording recording = new Recording()) {
//             // Start the recording
//             recording.start();
//             System.out.println("Recording started. Press Enter to stop...");
//
//             // Wait for user input to stop the recording
//             System.in.read();
//
//             // Stop the recording
//             recording.stop();
//
//             // Dump the recording data to a file
//             recording.dump(recordingPath);
//             System.out.println("Recording stopped. Data saved to " + recordingPath);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

		// UNICODE 10

		String unicodeCharacter = "\u263A";

		// Print the character
		System.out.println("Unicode 10 character: " + unicodeCharacter);

		// Check if it's a valid character
		boolean isLetter = Character.isLetter(unicodeCharacter.codePointAt(0));
		System.out.println("Is it a letter? " + isLetter);

		
	//	 int[] array = new int[Integer.MAX_VALUE];  // this attempts will lead out of memory
		SpringApplication.run(DemoApplication.class, args);
	}

}
