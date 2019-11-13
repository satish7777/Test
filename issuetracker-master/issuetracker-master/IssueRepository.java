package com.learn.issuetracker.repository;

import java.util.List;

import com.learn.issuetracker.model.Issue;

public interface IssueRepository {

	List<Issue> getIssues();

}
