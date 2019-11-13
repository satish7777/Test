package com.learn.issuetracker.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.learn.issuetracker.exceptions.IssueNotFoundException;
import com.learn.issuetracker.model.Employee;
import com.learn.issuetracker.model.Issue;
import com.learn.issuetracker.repository.IssueRepository;

/*
 * This class contains functionalities for searching and analyzing Issues data Which is stored in a collection
 * Use Java8 streams API to do the analysis
 * 
*/
public class IssueTrackerServiceImpl implements IssueTrackerService {

	/*
	 * CURRENT_DATE contains the date which is considered as todays date for this
	 * application Any logic which uses current date in this application, should
	 * consider this date as current date
	 */
	private static final String CURRENT_DATE = "2019-05-01";

	/*
	 * The issueDao should be used to get the List of Issues, populated from the
	 * file
	 */
	private IssueRepository issueDao;
	private LocalDate today;

	/*
	 * Initialize the member variables Variable today should be initialized with the
	 * value in CURRENT_DATE variable
	 */
	public IssueTrackerServiceImpl(IssueRepository issueDao) {
		this.issueDao = issueDao;
		today = LocalDate.parse(CURRENT_DATE);
	}

	/*
	 * In all the below methods, the list of issues should be obtained by used
	 * appropriate getter method of issueDao.
	 */
	/*
	 * The below method should return the count of issues which are closed.
	 */
	@Override
	public long getClosedIssueCount() {
		return issueDao.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase("CLOSED")).count();
	}

	/*
	 * The below method should return the Issue details given a issueId. If the
	 * issue is not found, method should throw IssueNotFoundException
	 */

	@Override
	public Issue getIssueById(String issueId) throws IssueNotFoundException {
		Optional<Issue> issueById = issueDao.getIssues().stream().filter(issue -> issue.getIssueId().equals(issueId))
				.findFirst();
		if (issueById.isPresent())
			return issueById.get();
		else
			throw new IssueNotFoundException();
	}

	/*
	 * The below method should return the Employee Assigned to the issue given a
	 * issueId. It should return the employee in an Optional. If the issue is not
	 * assigned to any employee or the issue Id is incorrect the method should
	 * return empty optional
	 */
	@Override
	public Optional<Employee> getIssueAssignedTo(String issueId) {

		Optional<Issue> issueById = issueDao.getIssues().stream().filter(issue -> issue.getIssueId().equals(issueId))
				.findFirst();
		if (issueById.isPresent())
			return Optional.ofNullable(issueById.get().getAssignedTo());
		return Optional.empty();

	}

	/*
	 * The below method should return the list of Issues given the status. The
	 * status can contain values OPEN / CLOSED
	 */
	@Override
	public List<Issue> getIssuesByStatus(String status) {
		return issueDao.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase(status))
				.collect(Collectors.toList());
	}

	/*
	 * The below method should return a LinkedHashSet containing issueid's of open
	 * issues in the ascending order of expected resolution date
	 */
	@Override
	public Set<String> getOpenIssuesInExpectedResolutionOrder() {
		return issueDao.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase("OPEN"))
				.sorted(Comparator.comparing(Issue::getExpectedResolutionOn)).map(Issue::getIssueId)
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/*
	 * The below method should return a List of open Issues in the descending order
	 * of Priority and ascending order of expected resolution date within a priority
	 */
	@Override
	public List<Issue> getOpenIssuesOrderedByPriorityAndResolutionDate() {
		return issueDao
				.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase("OPEN")).sorted(Comparator
						.comparing(Issue::getPriority).reversed().thenComparing(Issue::getExpectedResolutionOn))
				.collect(Collectors.toList());
	}

	/*
	 * The below method should return a List of 'unique' employee names who have
	 * issues not closed even after 7 days of Expected Resolution date. Consider the
	 * current date as 2019-05-01
	 */
	@Override
	public List<String> getOpenIssuesDelayedbyEmployees() {
		return issueDao.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase("OPEN"))
				.filter(issue -> LocalDate.of(2019, 05, 01).minusDays(7).isAfter(issue.getExpectedResolutionOn()))
				.map(issue -> issue.getAssignedTo().getName()).collect(Collectors.toList());
	}

	/*
	 * The below method should return a map with key as issueId and value as
	 * assigned employee name. THe Map should contain details of open issues having
	 * HIGH priority
	 */
	@Override
	public Map<String, Integer> getHighPriorityOpenIssueAssignedTo() {
		return issueDao.getIssues().stream().filter(
				issue -> issue.getPriority().equalsIgnoreCase("HIGH") && issue.getStatus().equalsIgnoreCase("OPEN"))
				.collect((Collectors.toMap(Issue::getIssueId, issue -> issue.getAssignedTo().getEmplId())));
	}

	/*
	 * The below method should return open issues grouped by priority in a map. The
	 * map should have key as issue priority and value as list of open Issues
	 */
	@Override
	public Map<String, List<Issue>> getOpenIssuesGroupedbyPriority() {
		return issueDao.getIssues().stream().filter(issue -> issue.getStatus().equalsIgnoreCase("OPEN"))
				.collect(Collectors.groupingBy(Issue::getPriority));
	}

	/*
	 * The below method should return count of open issues grouped by priority in a
	 * map. The map should have key as issue priority and value as count of open
	 * issues
	 */
	@Override
	public Map<String, Long> getOpenIssuesCountGroupedbyPriority() {
		Map<String, List<Issue>> list = issueDao.getIssues().stream()
				.filter(issue -> issue.getStatus().equalsIgnoreCase("OPEN"))
				.collect(Collectors.groupingBy(Issue::getPriority));

		return list.entrySet().stream().collect(
				Collectors.toMap(item -> (String) item.getKey(), item -> Long.valueOf(item.getValue().size())));

	}
}