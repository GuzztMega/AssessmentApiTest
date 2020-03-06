Narrative:
    Run the "AssessmentApi" application
    In order to check Endpoints
    As a user
    I want to access \HealthCheck and see its status
    and \HealthCheck\dataBase to see database status

Scenario: Run the "AssessmentApi" application

Given I run the application
And I open the navigator
When I enter the "http://localhost:8080/HealthCheck" address
Then I should see "UP and Running"

Scenario: Run the "AssessmentApi" application database

Given I run the application
And I open the navigator
When I enter the "http://localhost:8080/HealthCheck/dataBase" address
Then I should see "UP and Running DATA BASE"