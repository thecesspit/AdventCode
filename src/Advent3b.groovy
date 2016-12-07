/**
 * Created by Chris on 2016-12-03.
 */

// Advent of Code challenge 3.  Reads in a file of triples, line by line, decides if the triple is a triangle

File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent3a_input.txt")

String line
int count = 0
def bigArray = []
// Read in all lines and make a large array of arrays.
    input.withReader { reader ->
        while ((line = reader.readLine()) != null) {
            def triple = line.tokenize()
            //convert array into a triple of integers
            def integerTriple = []
            triple.each {
                integerTriple << it.toInteger()
            }
            bigArray << integerTriple
        }
    }
// For each 3 lines, look at the column of three and assess if it's a triangle
while(bigArray.size() > 0) {
    def threeByThree = bigArray.take(3)
    println threeByThree
    for(int j = 0; j < 3; j++)
    {
        def triple = []
        triple << threeByThree[0][j]
        triple << threeByThree[1][j]
        triple << threeByThree[2][j]
        triple.sort()
        println triple
        if (triple[2] < triple[1] + triple[0]) {
            count++
        }
    }
    bigArray = bigArray.drop(3)
}









print("Triangle Count = $count")
