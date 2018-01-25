package com.play.tech.url.split.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.play.tech.url.split.model.UrlDTO;
import com.play.tech.url.split.state.machine.impl.State;
import com.play.tech.url.split.state.machine.impl.StateMachineSpiltURL;

/**
 * This class is having business logic for Splitting URL by Regex and State
 * Machine
 * 
 * @author sachin.kumar
 *
 */

public class SplitUrlUtilService {
	private final static String urlPattern = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*)?)?(#(.*))?";

	// Executing Split URL logic by Regex
	public UrlDTO splitUrlByRegex(String urlString) throws Exception {
		UrlDTO urlDTO = new UrlDTO();
		long startTime = getTime();
		for (int i = 0; i < 10000; i++) {
			splitUrlByRegex(urlString, urlDTO);
		}
		long endTime = getTime();
		urlDTO.setTotalExcutionTime(endTime - startTime);
		return urlDTO;
	}

	private void splitUrlByRegex(String urlString, UrlDTO urlDTO) {
		try {
			Pattern pattern = Pattern.compile(urlPattern);
			Matcher matcher = pattern.matcher(urlString);
			matcher.find();
			urlDTO.setScheme(matcher.group(2));
			String hostAndPort = matcher.group(4);
			urlDTO.setHost(checkHost(hostAndPort));
			urlDTO.setPort(checkPort(hostAndPort));
			urlDTO.setPath(getPath(matcher.group(5)));
			urlDTO.setQuery(matcher.group(7));
		} catch (Exception e) {
			System.out.println("Exception occured while regex parsing......." + e);
		}
	}

	// checking Path
	private String getPath(String group) {
		return group.substring(1);
	}

	// checking part
	private String checkPort(String hostAndPort) {
		return hostAndPort.contains(":") ? hostAndPort.split(":")[1] : null;
	}

	// checking Host
	private String checkHost(String hostAndPort) {
		return hostAndPort.contains(":") ? hostAndPort.split(":")[0] : hostAndPort;
	}

	// Executing Split URL logic by StateMachine
	public UrlDTO splitUrlByStateMachine(String urlString) {
		UrlDTO urlDTO = new UrlDTO();
		try {
			URL url = new URL(urlString);
			long startTime = getTime();
			for (int i = 0; i < 1000; i++) {
				splitUrlByStateMachine(url, urlDTO);
			}
			long endTime = getTime();
			urlDTO.setTotalExcutionTime(endTime - startTime);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return urlDTO;
	}

	private void splitUrlByStateMachine(URL url, UrlDTO urlDTO) {

		try {
			StateMachineSpiltURL machine = new StateMachineSpiltURL();
			machine.setCurrentState(State.START);
			machine.startProcessScheme(url, urlDTO);
			machine.setCurrentState(State.SCHEME);
			machine.startProcessHost(url, urlDTO);
			machine.setCurrentState(State.HOST);
			machine.startProcessPort(url, urlDTO);
			machine.setCurrentState(State.PORT);
			machine.startProcessPath(url, urlDTO);
			machine.setCurrentState(State.PATH);
			machine.startProcessQueryParam(url, urlDTO);
		} catch (Exception e) {
			System.out.println("Exception occured while state machine parsing operation.......");
		}
	}

	public long getTime() {
		return System.currentTimeMillis();
	}

	public long totalTime(long startTime, long endTime) {
		return endTime - startTime;
	}

	// checking the format of the URL argument.
	public void checkURLStringFormat(String uRLString) throws MalformedURLException {
		URL url = new URL(uRLString);
	}

}
