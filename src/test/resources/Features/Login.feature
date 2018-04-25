Feature: Verify login feature

  Background:
    Given Properties with devices in different status online, offline, error and updates and also device simulator is up and running
    When Login to Site property admin dashboard
    Then Site Property name should be displayed

  Scenario: Verify property admin able to login into property site and verify the site name
    And JBL logo should be displayed
    And Device total count should be sum of Online, Offline and Error devices count

  Scenario: Mute the device and verify the Success notification
    When Select unmuted device and click on Mute
    Then A popup should be displayed with the message Are you sure you want to mute the device
    When User clicks on Yes button displayed in popup to mute the device
    Then Device icon status should be changed from Mute to UnMute

  Scenario: Unmute the device and verify the Success notification
    When Select muted device and click on unMute
    Then A popup should be displayed with the message Are you sure you want to unmute the device
    When User clicks on Yes button displayed in popup to Unmute the device
    Then Device icon status should be changed from Unmute to Mute