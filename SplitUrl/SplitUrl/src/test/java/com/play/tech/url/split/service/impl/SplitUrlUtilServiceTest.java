/**
 * 
 */
package com.play.tech.url.split.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.play.tech.url.split.model.UrlDTO;

/**
 * @author sachin.kumar
 *
 */
public class SplitUrlUtilServiceTest {

	SplitUrlUtilService splitService;
	String urlString = "";
	String urlWithOutPort = "";
	String urlWithOutParam = "";
	String urlWithOutParamAndPort = "";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		splitService = new SplitUrlUtilService();
		urlString = "http://playtech:8080/path?param";
		urlWithOutPort = "http://playtech/path?param";
		urlWithOutParam = "http://playtech:8080/path";
		urlWithOutParamAndPort = "http://playtech/path";;
	}

	@Test()
	public void whenSchemeIsGivenReturnhttpByRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlString);
		assertEquals("http", url.getScheme());
	}

	@Test()
	public void whenSchemeIsGivenReturnhttpByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlString);
		assertEquals("http", url.getScheme());
	}

	@Test()
	public void whenHostIsGivenReturnPlaytechbyRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlString);
		assertEquals("playtech", url.getHost());
	}

	@Test()
	public void whenHostIsGivenReturnPlaytechByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlString);
		assertEquals("playtech", url.getHost());
	}
	
	@Test()
	public void whenPortIsGivenRetur8080byRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlString);
		assertEquals("8080", url.getPort());
	}

	@Test()
	public void whenPortIsGivenReturn8080byStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlString);
		assertEquals("8080", url.getPort());
	}
	@Test()
	public void whenPortIsMissingReturnNullbyRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlWithOutPort);
		assertEquals(null, url.getPort());
	}
	
	@Test()
	public void whenPortIsMissingReturnNullbyStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlWithOutPort);
		assertEquals(null, url.getPort());
	}
	
	@Test()
	public void whenPathIsGivenReturPathByRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlString);
		assertEquals("path", url.getPath());
	}

	@Test()
	public void whenPathIsGivenReturnPathByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlString);
		assertEquals("path", url.getPath());
	}
	
	
	@Test()
	public void whenParamIsGivenReturParamByRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlString);
		assertEquals("param", url.getQuery());
	}

	@Test()
	public void whenParamIsGivenReturnParamByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlString);
		assertEquals("param", url.getQuery());
	}
	
	@Test()
	public void whenParamIsMissingReturParamByRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlWithOutParam);
		assertEquals(null, url.getQuery());
	}

	@Test()
	public void whenParamIsMissingReturnParamByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlWithOutParam);
		assertEquals(null, url.getQuery());
	}
	
	@Test()
	public void whenPortAndParamIsMissingReturNullByRegex() throws Exception {
		UrlDTO url = splitService.splitUrlByRegex(urlWithOutParamAndPort);
		assertEquals(null, url.getQuery());
		assertEquals(null, url.getPort());
	}

	@Test()
	public void whenPortAndParamIsMissingReturnNullByStateMachine() throws Exception {
		UrlDTO url = splitService.splitUrlByStateMachine(urlWithOutParamAndPort);
		assertEquals(null, url.getQuery());
		assertEquals(null, url.getPort());
		
	}
	
	
	
}
