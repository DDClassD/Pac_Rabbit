Graphical Abstract 



**Purpose of the software**  

**Which type of software development process is applied?** 

Agile process. 

**Why you choses this type?** 

Agile is suitable for the situation where the requirements are not clear, because it i my first software development for the first time, and the requirements are not very clear, so I need to gradually clarify the requirements in the process of continuous iteration.  Agile communication is usually much higher, and at the same time it is more flexible, requiring changes at almost any time. 

With Waterfall, it is not easy to define the requirements clearly in the early stage, and the hypothetical requirements based on the early plans may have great risks.  Also, many communications in waterfall are one-way communication in the early stage, and the later projects are very different from the original expectations. 

**Possible usage of your software.** 

Possible usage of my software is entertainment.		 



**Software development plan**  

**Development process** 

Main goals of the game  > Game mechanics > Game style and technical requirements > Character design(rabbit and turtle) and Game scenarios  > User Interface (UI) > Game code  > Credit > Game testing and modification  

I start by planning the main goals of the game, game mechanics and game style . 

**Main goals of the game:** 

Control the rabbit to eat all the carrots hidden in the maze without being caught by the turtle. When the rabbit eat all carrots, it need to go to the center

**Game mechanics:**  

There is a golden carrot in each of the four corners of the maze. When the rabbit eats the golden carrot, the rabbit can eat the tortoise in a short period of time; at the same time, the tortoise will turn dark blue, escape in the opposite direction, and move slowly; When the turtle is eaten, it will fly back to the cave to regenerate and return to its normal color; when the dark blue turtle flashes, it means that the effectiveness of the golden carrot is about to disappear. 

To enable the rabbit to eat carrot and avoid the pursuit of ghosts, it is necessary to realize the control of the rabbit. Here, the direction is controlled by the up, down, left, and right of the keyboard, and the movement is controlled by the coordinates. According to the keyboard, it is judged which direction is pressed, and the coordinate changes in different directions are calculated correspondingly, and then judge the situation after the movement and recalculate the coordinates. 

For the random movement of the turtle, first determine the current direction, and then determine how many directions the turtle can move up, down, left, and right, and then randomly choose a direction to move forward in the movable direction. When the turtle is in the cave, the shrunken turtle keeps moving in circles. 

**Game style:**
**
` `Casual games, Pixel,  just clear the game. 


**Character design and Game scenarios:** 

Character design: I use pixel style for character design, so that the whole process will not be too complicated, and the characters can be presented simply, making the whole game more casual.  

The rabbit and turtle below the picture are the characters will see in the game.


**Game code:** 

Use Javafx language to make these games and have tested and modified many times to ensure the stability and fluency of game.

**Game testing and modification**

In the test, need to test the pixel images which can make a suitable size to put on the page and labels. Then we need to test all the buttons match keyboardcan work normally, when the player presses it, rabbit can switch to other directions ? Test the games, is it incorrect to show game over when rabbit eat all carrot?



**Members (Roles & Responsibilities & Portion)**

Only me conduct game production, game design and game testing. I draw the rabbit, turtle, ui, ground, and carrot. I also code by using eclipse and test the game.

**Schedule**

I have planned a month schedule to develop this software. 

In the first week, I am going to figure it out what functions in this software. I want to develop games in this software. I want to develop a game based on Pac-Man. I refer to Pac-Man on https://github.com/RookieStupidCat/Pac\_Man to make my gmae.

In the second week, I am going to design my game style. My game style I want to use pixel style to design it, then I design my characters, backgrounds, UI. Also, I need to develop games separately and work in Javafx.  

In the third week, I am going to test my software. If there are errors in the above tests,  go back to design and develop it. 

In the last week, I am going to do an evaluation, write my README.md and record my demo.

**Algorithm**

Collision Detection Algorithm: This is seen in methods like hittedByTurtle() in the rabbit class, which checks whether the player's character intersects with an enemy character (turtle).

Movement Algorithm: Both the rabbit and turtle objects extend from MovingObject, and use the move() method for consistent movement on the game board. The method checks for wrapping around the game area edges to simulate a continuous space.



Pathfinding Algorithm: The turtles (enemies) seem to use a simple form of the random movement algorithm based on the randomChangeDirect() method. This method changes the direction of movement at intersections to simulate autonomous movement. It does not appear to involve any advanced pathfinding like A\* or Dijkstra's algorithm, instead relying on random decisions at predefined decision points to emulate 'AI'.

Game State Management: The game uses state variables to manage the flow of the game, including whether the game is running, whether the player has won or lost, and whether the player's character is in a powered-up state. For example, the game loop in GamePanel checks isGameOver and isWin to proceed with the game's actions accordingly.

Rendering Algorithm: The custom paint() methods in GamePanel and ScorePanel dictate how and when game elements are drawn to the screen.

Event-Driven Programming: The game responds to keyboard input for player control through the implementation of the KeyListener interface and its methods (keyPressed(), keyTyped(), and keyReleased()).

Animation and Frame Update Algorithm: The game uses a basic timing mechanism to update animations and movements, such as the action() loop in GamePanel and the time-based switching of frames in the rabbit's draw() method.

Power-Up Mechanism: When the rabbit collects a special item (golden carrot), the state of the turtles is changed, as managed by the static isEat variable in turtle. This alters their behavior and makes them vulnerable.

Initialization Algorithm: In classes like GamePanel, there is an initialization process for setting up the game state, including creating the grid of BlockLabel objects based on a predefined map, placing the rabbit and turtles in their starting positions, and setting up the scoring panel.

Sprite Animation Cycling: The draw() method in the rabbit class cycles through images to create an animation effect for the rabbit moving, which is a simple frame-based animation algorithm.


Game Timer/Thread Sleep Control: The use of Thread.sleep() in the game loop to control the speed of the game updates could be considered a very basic timing algorithm. It regulates how often the game state is refreshed and rendered.

Listeners and Interaction Handling: The implementation of KeyListener to handle keyboard events is part of an interaction handling algorithm, which directly influences the game based on user inputs.

Game Over and Win Conditions: The game defines conditions for losing the game (if the rabbit collides with a turtle and has no more lives) and for winning the game (achieving a certain score), which is part of the game logic algorithm.

Asset Loading: The way images and other resources are loaded might also be considered part of the asset management algorithm. For instance, the game panels utilize Toolkit.getDefaultToolkit().getImage() method calls to load images necessary for rendering game elements.

Item Consumption and Effect Application: In the rabbit class, when the rabbit consumes an item, the game checks if it's a special power-up and applies the effects to the turtles via the isEat flag. This is part of the broader game mechanic algorithm.

**Current status of your software**

Completed the expected user UI, game function, and play.

**Future plan**

My future plan is we will create a table of ranking which can record the scores of all players and then make a competition in these minigames.

Environment of the software development and running: 

1. Programming language: Javafx 
2. Software Requirnment:  
1. Language – Javafx  
2. ` `IDE – Eclipse 
3. OS – Windows 10  

**Reference Citation**

Code: 一个简单的基于java的吃豆人小游戏/A simple java-based Pac-Man game https://github.com/RookieStupidCat/Pac\_Man
