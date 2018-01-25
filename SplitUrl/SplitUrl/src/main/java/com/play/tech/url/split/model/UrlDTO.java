package com.play.tech.url.split.model;

/**
 * This is model for URL.
 * 
 * @author Sachin.kumar
 *
 */
public class UrlDTO {

	private String scheme;

	private String host;

	private String port;

	private String path;

	private String query;

	private long totalExcutionTime;

	public UrlDTO() {
		// TODO Auto-generated constructor stub
	}

	public UrlDTO(String scheme, String host, String port, String path, String query) {
		this.scheme = scheme;
		this.host = host;
		this.port = port;
		this.path = path;
		this.query = query;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public long getTotalExcutionTime() {
		return totalExcutionTime;
	}

	public void setTotalExcutionTime(long l) {
		this.totalExcutionTime = l;
	}

	@Override
	public String toString() {

		return this.scheme + "\n" + this.host + "\n" + (this.port != null ? this.port + "\n" : "") + this.path + "\n"
				+ (this.query != null ? this.query + "\n" : "");
	}

}