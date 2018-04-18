Feature: Verify login feature

  Scenario: Verify property admin able to login into property site and verify the site name
    Given Properties with devices in different status online, offline, error and updates and also device simulator is up and running
    When Login to Site property admin dashboard
    Then Site Property name should be displayed
    And JBL logo should be displayed
    And Device total count should be sum of Online, Offline and Error devices count
