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
    Then Click on ApplayChange button
    #And Verify Confirmation message pop-up
    When User clicks on Yes button displayed in popup to update VoiceAgent address
    #Then VoiceAgent address should be updated at property level and displayed the notificatio