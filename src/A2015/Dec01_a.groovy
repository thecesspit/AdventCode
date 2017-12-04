/**
 * Created by Chris on 02-Dec-17.
 *
 * 2015 - Dec 01 code
 */

// Function to find out the floor after the string of ( )'s
int floorFinder(bracketString){
    def floor = 0
    bracketString.each{
        if(it == '('){
            floor++
        }
        if(it == ')'){
            floor --
        }
    }
    return floor
}

// Load in a Data File
def input = new File("DecFiles/Dec01")
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        print floorFinder(line)
    }
}