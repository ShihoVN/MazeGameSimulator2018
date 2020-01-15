
PROJECT TITLE: Maze game
PURPOSE OF PROJECT: design and implement a multi-player game
VERSION or DATE: 5/52018
HOW TO START THIS PROJECT: run the program with the appropriate parameters
AUTHORS:Shiho Numakura
USER INSTRUCTIONS:
Parameters include the limit, number of players, max number on the dice, graph description filename, and file with starting node and ending nodes
Once you are asked for a prompt
Press 'x' to exit program.
Press 'p' to print all players positions.
Press 'i' to continue with a round for all player
Press 'c' to continue playing without further prompts

This program will simulate a graph based maze game played by multiple players. Each
player will be assigned an algorithm to choose their direction in the game. There are nodes that connect to multiple edges which will direct to another node. Each edge will have different weights, representing the different steps that is required to take in order to reach a node. So, the different types of player will choose their edges differently. Each turn, the player will roll and dice and proceed to their direction. However, the first three types of player will proceed to move on to the exit node when the exit nodes are in their neighbor. The last two types of players will be slightly different. Using a given limit (in parameter), if the distance to closest path to an exit node using Dijkstra’s algorithm (13.05.01 e-textbook) is within the limit, the fourth player will use the shortest path and the last player will use the longest path. The program will ask for the input for a prompt every round, unless it is commanded to continue without it. Throughout the game, the user will be able to see where all players are located. The goal for program is for one of the players to reach an exit node to finish the game.
Report included. 
