package A2017
/**
 * Created by Chris on 2017-12-02.
 * Advent of code 2017, challenge 2
 * http://adventofcode.com/2017/day/2
 */


// Load in a Data File
def input = new File("DecFiles/Dec02")
println input
int answer = 0

// Read in each line and convert to integer lists
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def numbers = line.tokenize()
        numbers.eachWithIndex{  v, int i ->
            numbers[i] = v.toInteger()
        }
        // find min max in each list
        answer = answer + (numbers.max() - numbers.min())
    }
}

println answer
