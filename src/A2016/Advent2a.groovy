package A2016
/**
 * Created by Chris on 2016-12-04.
 */

// Create a KeyPad
def keypad = [[1,4,7],[2,5,8],[3,6,9]]

// define the start location
def location = [1,1]

// Read in instructions, line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent2a_input.txt")

input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
// For each item move on the keypad.
        line.each { it ->
            if (it == "U" && location[1] != 0) {
                location[1] = location[1] - 1
            }
            if (it == "D" && location[1] != 2) {
                location[1] = location[1] + 1
            }
            if (it == "L" && location[0] != 0) {
                location[0] = location[0] - 1
            }
            if (it == "R" && location[0] != 2) {
                location[0] = location[0] + 1
            }
        }

        println keypad[location[0]][location[1]]
    }
}