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

Scenario: Test the AssessmentApi application if is not working
Given I set up the <address> address
When The application is not working
Then I should see <message>

Scenario: Test the "AssessmentApi" application database
Given I enter the <address> database adress
When the database application start
Then I should now see <message>

Scenario: Test the AssessmentApi database application if data base is not working
Given I set up the <address> address
When The data base is not working
Then I should see <message>

Examples:
      | address                                      | message                      |
      | "http://localhost:8080/HealthCheck"          | "UP and Running"             |
      | "http://localhost:8080/HealthCheck/dataBase" | "UP and Running DATA BASE"   |