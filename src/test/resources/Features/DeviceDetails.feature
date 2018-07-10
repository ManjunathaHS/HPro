@smoke
Feature: Updating device details

  Background:
    Given Properties with devices in different status online, offline, error and updates and also device simulator is up and running
    When Login to Site property admin dashboard
      | manjunatha.s@harman.com |
      | SB0Yd8o_S3G             |
    Then Site Property name should be displayed

  Scenario: Change Device Placement Info Details
    When User selects the device which is online and click on Device Name
    Then Verify MapToAnotherRoom is displayed
    And Click on Edit Icon in General section
    Then Update Placement Info details
    Then Click on Save button

