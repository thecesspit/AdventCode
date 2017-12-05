/**
 * Created by Chris on 04-Dec-17.
 *
 * Advent of Code Day 5: http://adventofcode.com/2017/day/5
 *
 * Jumping Maze
 */

// Load in a Data File and place all entries into an integer List
def input = new File("DecFiles/Dec05")
def maze = []

input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def entry = line.tokenize(' ')
        maze << entry[0].toInteger()
    }
}
println maze

// Now tranverse the maze
def location = 0
def newlocation
BigInteger totalMoves = 0
while(location < maze.size() && location >= 0)
{
    newlocation = maze[location] + location
    //println("$totalMoves:  $location - ${maze[location]}")
    if(maze[location] < 3){ maze[location] += 1 }
    else{ maze[location] -- }
    location = newlocation
    totalMoves++
}


println totalMoves
