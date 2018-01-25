package com.play.tech.url.split.state.machine.impl;

import java.net.URL;

import com.play.tech.url.split.model.UrlDTO;
/**
 * This class hold the methods of machine.
 * @author sachin.kumar
 *
 */
public class StateMachineSpiltURL {

	public State currentState;

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public void startProcessScheme(URL URL, UrlDTO urlState) {
		urlState.setScheme(URL.getProtocol());
	}

	public void startProcessHost(URL URL, UrlDTO urlState) {
		urlState.setHost(URL.getHost());
	}

	public void startProcessPort(URL URL, UrlDTO urlState) {
		urlState.setPort(URL.getPort() != -1 ? Integer.toString(URL.getPort()) : null);
	}

	public void startProcessPath(URL URL, UrlDTO urlState) throws Exception {
		urlState.setPath(URL.getPath().substring(1));
	}

	public void startProcessQueryParam(URL URL, UrlDTO urlState) throws Exception {
		urlState.setQuery(URL.getQuery());
	}
}
