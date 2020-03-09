Narrative:
    Run the "AssessmentApi" application
    In order to check Endpoints from my localhost:8080
    As a secure code developer
    I want to access \HealthCheck and see its status
    and \HealthCheck\dataBase to see database status

Scenario: Test the "AssessmentApi" application

Given I enter the <address> address
When the application start
Then I should see <message>

Scenario: Test the "AssessmentApi" application database
Given I enter the <address> database adress
When the database application start
Then I should see database <message>

Examples:
      | address                                      | message                      |
      | "http://localhost:8080/HealthCheck"          | "UP and Running"             |
      | "http://localhost:8080/HealthCheck/dataBase" | "UP and Running DATA BASE"   |