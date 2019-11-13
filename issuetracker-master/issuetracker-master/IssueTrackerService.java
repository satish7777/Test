package com.learn.issuetracker.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.learn.issuetracker.exceptions.IssueNotFoundException;
import com.learn.issuetracker.model.Employee;
import com.learn.issuetracker.model.Issue;

public interface IssueTrackerService {

	long getClosedIssueCount();

	Issue getIssueById(String issueId) throws IssueNotFoundException;

	Optional<Employee> getIssueAssignedTo(String issueId);

	List<Issue> getIssuesByStatus(String status);

	Set<String> getOpenIssuesInExpectedResolutionOrder();

	List<Issue> getOpenIssuesOrderedByPriorityAndResolutionDate();

	List<String> getOpenIssuesDelayedbyEmployees();

	Map<String, Integer> getHighPriorityOpenIssueAssignedTo();

	Map<String, List<Issue>> getOpenIssuesGroupedbyPriority();

	Map<String, Long> getOpenIssuesCountGroupedbyPriority();

}