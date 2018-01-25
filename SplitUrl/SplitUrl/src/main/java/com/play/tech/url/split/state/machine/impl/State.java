package com.play.tech.url.split.state.machine.impl;

import java.net.URL;

import com.play.tech.url.split.model.UrlDTO;

/**
 * This class provides states.
 * 
 * @author Sachin.kumar
 *
 */
public enum State {
	START, SCHEME, HOST, PORT, PATH;
	public void onEventParseScheme(URL aURL, UrlDTO urlState) {
		urlState.setScheme(aURL.getProtocol());
	}

	public void onEventParseHost(URL aURL, UrlDTO urlState) {
		urlState.setHost(aURL.getHost());
	}

	public void onEventParsePort(URL aURL, UrlDTO urlState) {
		urlState.setPort(aURL.getPort() != -1 ? Integer.toString(aURL.getPort()) : null);
	}

	public void onEventParsePath(URL aURL, UrlDTO urlState) throws Exception {
		urlState.setPath(aURL.getPath());

	}

	public void onEventParseParam(URL aURL, UrlDTO urlState) throws Exception {
		urlState.setQuery(aURL.getQuery());
	}

}