Feature: Login

Scenario: Valid Login

Given User launches Chrome browser
When User opens ParaBank website
And User enters username and password
And Clicks Login button
Then User should login successfully