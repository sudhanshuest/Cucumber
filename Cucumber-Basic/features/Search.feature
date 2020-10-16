Feature: Search
 
Scenario: Successful search clarivate.com in google
 Given Open the Chrome Browser
 When User Open the URL "https://www.google.com/"
 And Search for "Clarivate Analytics" 
 And Make sure "clarivate.com" is the first search result
 Then close the browser