Feature: Producer Restful APIs

Background:
* url 'http://localhost:8888/api'

Scenario: Create and retrieve a producer

Given path '/producers'
And request {name: 'pro1', country: 'UK'}
When method post
Then status 201
And match header Location contains '/producers'
  
Given url responseHeaders['Location'][0]
When method get
Then status 200
And match $ == {id: '#number', name: '#string', country: '#notnull'}