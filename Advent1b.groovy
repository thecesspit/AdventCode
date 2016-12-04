/**
 * Created by Chris on 2016-12-02.
 */


// This code tackles Advent of Code Day 1b

// Load in a Data File and tokenize
def inputString = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent1a_input.txt").text
def inputArray = inputString.tokenize(', ')


// Create the location co-ordinates to track [0,0]
// Set a direction array.  1,0 = North, 0,1 = East, etc.
def location = [0,0]
def direction = [1,0]
def previous = []

// Then for each item, split into a letter and a number
inputArray.each { moveString ->
    def change = moveString[0]
    def distance = moveString.substring(1).toInteger()

// Change direction
    if (change == 'R') {
        direction = [-direction[1], direction[0]]
    } else {
        direction = [direction[1], -direction[0]]
    }
    // Create a new location based on the direction and distance
    def newVector = [(direction[0] * distance), (direction[1] * distance)]
    def sizeofVector = newVector[0].abs() + newVector[1].abs()
    sizeofVector.times {
        location = [location[0] + direction[0], location[1] + direction[1]]
        println location

        // See if this location already exists in our previous visits
        if (previous.contains(location)) {
            println("HQ = ${location[0].abs() + location[1].abs()}")
            exit()
        }
        previous << location
    }
}

println("Distance = ${location[0].abs() + location[1].abs()}")

