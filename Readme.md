# Design Magical Arena with JAVA

## Project Setup
```bash
# You can start the project with below commands after unzipping the folder
javac Magical_Arena_App.java
java Magical_Arena_App
```

## Problem Statement
Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 
Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any players health reaches 0.
Player with lower health attacks first at the start of a match.

## Assumptions
1. We can add any number of players in the arena, but only two would be able to play a game at a time.
2. Interactive design is not the initial requirement, though we can make it interactive with minimal changes.
3. Number of dice = 1, however code is written to incorporate any number of dices.
4. The Game ends if no winner is found after 1000 moves.
5. While calculating Damage by attacker, If the Defense Value is greater than Attack Value, 0 damage is reduced.
6. While calculating updated health, If the Damage Value is greater than Current Health Value, Health is set to 0.
7. App is refactored constantly in order to incorporate any future change in requirements.

## Implementation Details

- Magical Arena App - 
    1. The start point of the project.
    2. Players are added in arena.
    3. Start game between two players after initializing required instances.

- Models -
    - Dice - 
        1. Set the count of number of dices.
        2. Get the value when Dice is rolled (rollDice()).
    - Player -
        1. Defines the player of the game.
        2. Getter and Setter for each attribute [Name, ID, Health, Attack, Strength].
    - Magic Arena Game -
        1. This is where Game simulation takes place.
        2. The Damage value of each turn is calculated using "Helpers" and player's health is updated accordingly.
        3. Winner and Loser of the game is displayed.

- Helpers - 
    - MoveCalculator - 
        - Parent Class which helps in calculating each MoveValue (Attack, Defense).
        - Inherited by Attack and Defense class, which can override parent class method if in future there is change in requirement.
    - DamageCalculator -
        - Helps in calculating total damage value in one turn.
    - HealthCalculator -
        - Helps in calculating the updated health after reducing damage from current health.   

- Test Class - 
    - Class to test each feature of the application.

## Contributing
Suggestions (and Pull requests) are welcome.

