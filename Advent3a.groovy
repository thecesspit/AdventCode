/**
 * Created by Chris on 2016-12-03.
 */

// Advent of Code challenge 3.  Reads in a file of triples, line by line, decides if the triple is a triangle

File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent3a_input.txt")

String line
int count = 0

// Read in three lines
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def triple = line.tokenize()
        //convert array into a triple of integers
        def integerTriple = []
        triple.each {
            integerTriple << it.toInteger()
        }
        integerTriple.sort()
        println integerTriple

        if (integerTriple[2] < integerTriple[0] + integerTriple[1])
        {
            count++
        }
    }
}

print("Triangle Count = $count")
