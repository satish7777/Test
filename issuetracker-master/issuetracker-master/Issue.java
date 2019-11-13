package com.learn.issuetracker.model;

import java.time.LocalDate;

/*
 * Model class for storing Issue Object
*/

public class Issue {

	private String issueId;
	private String summary;
	private LocalDate createdOn;
	private LocalDate expectedResolutionOn;
	private String priority;
	private String status;
	private Employee assignedTo;

	public Issue() {
	}

	/*
	 * Complete the parameterized Constructor
	 */
	public Issue(String issueId, String summary, LocalDate createdOn, LocalDate expectedResolutionOn, String priority,
			String status, Employee assignedTo) {
		this.issueId=issueId;
		this.summary=summary;
		this.createdOn=createdOn;
		this.expectedResolutionOn=expectedResolutionOn;
		this.priority=priority;
		this.status=status;
		this.assignedTo=assignedTo;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getExpectedResolutionOn() {
		return expectedResolutionOn;
	}

	public void setExpectedResolutionOn(LocalDate expectedResolutionOn) {
		this.expectedResolutionOn = expectedResolutionOn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", summary=" + summary + ", createdOn=" + createdOn
				+ ", expectedResolutionOn=" + expectedResolutionOn + ", priority=" + priority + ", status=" + status
				+ ", assignedTo=" + assignedTo + "]";
	}
}