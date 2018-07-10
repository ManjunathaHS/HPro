@smoke
Feature: Verify device settings

  Background:
    Given Properties with devices in different status online, offline, error and updates and also device simulator is up and running
    When Login to Site property admin dashboard
      | manjunatha.s@harman.com |
      | SB0Yd8o_S3G             |
    Then Site Property name should be displayed

  Scenario: Edit Voiceagent/WakeWard details on property Level
    When Click on PropertySetting icon on Dashboard screen
    And Select VoiceAgent address and update VoiceAddress
    Then Click on ApplyChange button
    And Verify Confirmation message pop-up and click on yes button
    And Verify Voiceagent URL is updated