package A2016
/**
 * Created by Chris on 2016-12-02.
 */

import Helper.myVector

// This code tackles Advent of Code Day 1a

// Load in a Data File and tokenize
def inputString = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent1a_input.txt").text
def inputArray = inputString.tokenize(', ')


// Create the location co-ordinates to track [0,0]
// Set a direction array.  1,0 = North, 0,1 = East, etc.
def location = new myVector(0,0)
def direction = new myVector(0,1)

println inputArray

// Then for each item, split into a letter and a number
inputArray.each { moveString ->
    def change = moveString[0]
    def distance = moveString.substring(1).toInteger()

// Change direction and move in that direction
    direction.rotateVector(change)

    location.addVector(direction.scaleVector(distance))
}

println("Distance = ${location.sizeofVector()}")

