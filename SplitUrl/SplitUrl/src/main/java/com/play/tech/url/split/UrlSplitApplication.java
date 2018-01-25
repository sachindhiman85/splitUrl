package com.play.tech.url.split;

import java.net.MalformedURLException;

import com.play.tech.url.split.model.UrlDTO;
import com.play.tech.url.split.service.impl.SplitUrlUtilService;

/**
 * This is the main class of the Url splitting application.
 * 
 * @author sachin.kumar
 *
 */
public class UrlSplitApplication {

	public static void main(String[] args) {
		if (args.length != 0) {
			SplitUrlUtilService service = new SplitUrlUtilService();
			String URLString = args[0];
			try {
				service.checkURLStringFormat(URLString);
				UrlDTO regexDto = service.splitUrlByRegex(args[0]);
				UrlDTO stateDto = service.splitUrlByStateMachine(args[0]);
				displayOutput(regexDto, stateDto);
			} catch (MalformedURLException e) {
				System.out.println("Url Format is not correct. Please give the right URL.");
			} catch (Exception e) {
				System.out.println("Error accour while pasring.");
			}
		} else {
			System.out.println("Please provide the Url value...");
		}
	}
	
	private static void displayOutput(UrlDTO regexDto, UrlDTO stateDto) {
		System.out.println(regexDto);
		System.out.println("Regex: " + regexDto.getTotalExcutionTime() + "msec");
		System.out.println("State: " + stateDto.getTotalExcutionTime() + "msec");

	}

}