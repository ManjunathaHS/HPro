@smoke
Feature: Verify login feature

  Background:
    Given Properties with devices in different status online, offline, error and updates and also device simulator is up and running
    When Login to Site property admin dashboard
    |manjunatha.s@harman.com|
    |SB0Yd8o_S3G|
    Then Site Property name should be displayed

# Scenario: Verify property admin able to login into property site and verify the site name
#    And JBL logo should be displayed
#    And Device total count should be sum of Online, Offline and Error devices count
#
#  Scenario: Mute the device and verify the Success notification
#    When Select unmuted device and click on Mute
#    Then A popup should be displayed with the message Are you sure you want to mute the device
#    When User clicks on Yes button displayed in popup to mute the device
#    Then Device icon status should be changed from Mute to UnMute
#
#  Scenario: Unmute the device and verify the Success notification
#    When Select muted device and click on unMute
#    Then A popup should be displayed with the message Are you sure you want to unmute the device
#    When User clicks on Yes button displayed in popup to Unmute the device
#    Then Device icon status should be changed from Unmute to Mute
#
#  Scenario: Click on Reboot icon and verify the notification
#    When User selects the device which is online and click on Reboot icon
#    Then A popup should be displayed with the message Do you want to reboot the device
#    When User clicks on Yes button displayed in popup to reboot the device
#    Then Reboot should be initiated message should be displayed for the selected devices in notification

  Scenario: Verify the Total Devices count is Greater than Zero
         And Total device count should  be Greater than Zero