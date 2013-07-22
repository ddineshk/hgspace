/**
 * 
 */
package com.model;

import java.util.Date;

/**
 * @author ddurairaj
 * 
 */
public class Application {
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * @return the tagName1
	 */
	public String getTagName1() {
		return tagName1;
	}
	/**
	 * @param tagName1 the tagName1 to set
	 */
	public void setTagName1(String tagName1) {
		this.tagName1 = tagName1;
	}
	/**
	 * @return the tagName2
	 */
	public String getTagName2() {
		return tagName2;
	}
	/**
	 * @param tagName2 the tagName2 to set
	 */
	public void setTagName2(String tagName2) {
		this.tagName2 = tagName2;
	}
	/**
	 * @return the tagName3
	 */
	public String getTagName3() {
		return tagName3;
	}
	/**
	 * @param tagName3 the tagName3 to set
	 */
	public void setTagName3(String tagName3) {
		this.tagName3 = tagName3;
	}
	/**
	 * @return the lastBuildDate
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}
	/**
	 * @param lastBuildDate the lastBuildDate to set
	 */
	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	/**
	 * @return the buildStatus
	 */
	public String getBuildStatus() {
		return buildStatus;
	}
	/**
	 * @param buildStatus the buildStatus to set
	 */
	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	private Integer id;
	private String appName;
	private String version;
	private String tagName;
	private String tagName1;
	private String tagName2;
	private String tagName3;
	private Date lastBuildDate;
	private String buildStatus;
}
