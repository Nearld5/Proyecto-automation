@Navigation
Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links
 
Background: I am on the Free Range Testers web without logging in.
  Given I navigate to www.freerangetesters.com


    Scenario Outline: I can access the subpages through the navigation bar
    #El Given de este scenario esta dado por el Backgroudnd
        When I go to <section> using the navigation bar
        Examples:
            | section   |
            | Cursos    |
            | Recursos  |
            | Udemy     |
            | Mentorías |
            | Blog      |
     @Courses
        Scenario: Courses are presented correctly to potential customers
        #El Given de este scenario esta dado por el Backgroudnd
        When I go to Cursos using the navigation bar
        And  I Select Introducción al Testing

        @Plans
        Scenario: Users can select a plan when signing up
        #El Given de este scenario esta dado por el Backgroudnd
        When I go to Cursos using the navigation bar
        And I Select Introducción al Testing
        When The client selects elegir plan
        Then The client can validate the options in the checkout page
