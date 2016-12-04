/**
 * Created by Chris on 2016-12-04.
 */

// Create a KeyPad
def keypad = [['0','0','5','0','0'],['0','2','6','A','0'],['1','3','7','B','D'],['0','4','8','C','0'],['0','0','9','0','0']]

// define the start location
def locationX = 0
def locationY = 2

// Read in instructions, line by line

File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent2a_input.txt")
def line
input.withReader { reader ->
    while ((line = reader.readLine()) != null){
// For each item move on the keypad.
        line.each { it ->
            if (it == "U" && locationY != 0) {
                if (keypad[locationX][locationY - 1] != '0') {
                    locationY = locationY - 1
                }
            }
            if (it == "D" && locationY != 4) {
                if (keypad[locationX][locationY + 1] != '0') {
                    locationY = locationY + 1
                }
            }
            if (it == "L" && locationX != 0) {
                if (keypad[locationX - 1][locationY] != '0') {
                    locationX = locationX - 1
                }
            }
            if (it == "R" && locationX != 4) {
                if (keypad[locationX + 1][locationY] != '0') {
                    locationX = locationX + 1
                }
            }
        }
        println keypad[locationX][locationY]

    }
}
