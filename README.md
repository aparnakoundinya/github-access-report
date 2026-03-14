GitHub Access Report

Spring Boot REST API that generates a GitHub organization access report by mapping users to the repositories they can access.

Table of Contents

Overview

Features

Technologies

Setup & Run

API Usage

Assumptions

Overview

This project provides a REST API that connects to a GitHub organization and generates a report showing which users have access to which repositories. It is designed to handle large organizations efficiently (100+ repos, 1000+ users) while avoiding unnecessary sequential API calls.

Features

Authenticate securely with GitHub using Personal Access Tokens.

Retrieve all repositories of an organization.

List all users who have access to each repository.

Aggregate data to map each user to the repositories they can access.

Expose a REST endpoint returning the report in JSON format.

Technologies

Java 17

Spring Boot 3.5.11

Spring Web (REST APIs)

Lombok

Maven

Git & GitHub API

Setup & Run

Clone the repository:

git clone https://github.com/yourusername/github-access-report.git
cd github-access-report

Configure GitHub authentication:

Generate a Personal Access Token in GitHub.

Add the token to application.properties (or as environment variable):

github.token=YOUR_PERSONAL_ACCESS_TOKEN
github.organization=YOUR_ORG_NAME

Build & run the project:

mvn clean install
mvn spring-boot:run

The API will be available at http://localhost:8080.

API Usage

Endpoint:
GET /api/access-report

Response Example:

{
  "organization": "test",
  "users": [
    {
      "username": "user1",
      "repositories": ["repo1", "repo2"]
    }
  ]
}

Each object contains a username and a list of repositories the user has access to.

Assumptions & Design Decisions

Only organization-level repositories are considered.

Access report is aggregated per user.

GitHub REST API pagination is handled for large datasets.

Personal Access Token is used for authentication.

Efficient API usage to avoid hitting rate limits.
