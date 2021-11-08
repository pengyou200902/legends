# CS611-Legends

Name
-------------------------------------------------------------------------------------------------
--You Peng--
--U82384393--


Files
-------------------------------------------------------------------------------------------------
Armor.java                  class for armor
BaseCharacter.java          base abstract class for character
Castable.java               in this project, it's for spells cuz they can be casted
DataReader.java             parser class, for reading data files in ./ConfigFiles
Dragon.java                 class for Dragon monster
Exoskeleton.java            class for Exoskeleton monster
FireSpell.java              class for FireSpell
Game.java                   base abstract class for game
Hero.java                   base class for Heroes
HeroCreator.java            creator which creates Hero instances after reading ConfigFiles
HeroList.java               class to store all kinds of heroes in the game
HeroTeam.java               class for team of Heroes
IceSpell.java               class for IceSpell
Inventory.java              class for Inventory containing various items, which is used both in Hero and Market
Item.java                   base class for items
ItemCreator.java            creator which creates various kinds of Item instances after reading ConfigFiles
LegendController.java       game logic controller
LegendCreator.java          create a legend game
LegendMarket.java           class for markets in a legend game
LegendWorld.java            class for a world in a legend game
LightningSpell.java         class for LightningSpell
Main.java                   Main class for running the program
Market.java                 base class for markets
Monster.java                base class for monsters
MonsterCreator.java         creator which creates various kinds of Monster instances after reading ConfigFiles
MonsterList.java            class to store all kinds of monsters in the game
MonstersAndHeroes.java      Game class for MonstersAndHeroes game
MonsterTeam.java            class for a team of monsters
Paladin.java                Monster Paladin
Potion.java                 class for potion
RPGCharacter.java           base abstract class for characters in a RPGGame including some basic properties like hp, level...
RPGGame.java                base abstract class for a RPG game
RPGItem.java                base abstract class for an item in a RPG game
SingleUse.java              interface for single-use potions
Sorcerer.java               Hero Sorcerer
Spell.java                  base abstract class for spells
Spirit.java                 Monster Spirit
Team.java                   base abstract class for Teams in a game
TileType.java               enum class for tile types
Tradable.java               interface for tradable items
Warrior.java                Hero Warrior
Weapon.java                 class for weapons
Wearable.java               interface for wearable items
World.java                  base abstract class for a world in a game



Notes:
-------------------------------------------------------------------------------------------------
1. Data files are stored in ConfigFiles, my parser class is DataReader.java

2. Bonus Done:
    - colored output in terminal
    - 3 *Creator.java files for creating different items for legend game, which acts like factories/addons.
    - My parser class is DataReader.java which can skip N lines, quite useful for skipping files with headers.
    - Use a short regular expressions when parsing the data files.
    - ./legendsOOD.png shows the whole structure and design of project java files.

3. Things instructions to note
    - Data files are stored in ConfigFiles, my parser class is DataReader.java.
    - legendsOOD.png shows the whole structure and design of project java files.
    - ./legendsOOD.png shows the whole structure and design of project java files.


How to run:
-------------------------------------------------------------------------------------------------
1. javac Main.java && java Main
2. Run the following instructions on command line:
	javac *.java
	java Main.java
