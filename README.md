"# kataSocrates" 
US - 1 Cold Meals :
As an organiser
I want to get the number of "cold meals" to serve on "thursday evening"
In order to communicate this information to the castle
Scenario:

    Given I have CheckIn participant dates
    when I ask to count all the cold meals for "thursday evening"
    then I get the number of persons checking on thursday after 21h00 PM
    and a warning if there are participants with empty checkin date (different feature)

US - 2 : Registration: calculate the price

As an organiser of SocratesFR
I want to get the price of the participation for one candidate
In order to use this information to refund participant and for financial sheet

Given the following prices by choices
Choice 	Price
Single 	610
Double 	510
Triple 	410
No Accommodation 	240

And the price by meal is 40€
Scenario: Complete Price

Given A participant with a checkin on thursday and checkout on sunday after 14hPM
When I calculate the price
Then I get the total amount of her/his choice
Scenario: Price without one meal

Given A participant with (2 examples)

    a checkin on Friday and checkout on sunday or
    a checkin on thursday and checkout on saturday 18PM

When I calculate the price
Then I get the total amount of her/his choice minus 40
Scenario: Price without two meals

Given A participant with a checkin on Friday AND checkout on saturday 18PM
When I calculate the price
Then I get the total amount of her/his choice minus 2 * 40

US - 3 : Meals: Counting Covers by Diet

As an organiser of SocratesFR
I want to have the number of covers by diet for all the meals
In order to communicate this information to the castle
Scenario: count vegetarian diet

Given I have a participant with vegetarian diet
when I request the number of covers for meals
then I get the number of vegetarian covers for each meal
Scenario: count vegan diet

same as the previous scenario but for vegan
Scenario: count pescatarian diet

same as the previous scenario but for pescatarian
Scenario: count covers for all participants

Should get for every meal the number of covers by diet
Should for the meal of thursday night, highlight meals that should served cold (when the attendee checks in after 21PM)

