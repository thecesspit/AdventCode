import Helper.Cipher

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 6.

File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent6a_input.txt")

String line
def allArrays = []
def answerMost = ""
def answerLeast = ""

// Read in all the lines into arrays.
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        allArrays << line
    }
}

// For each column, turn into an array list, sort and find the most common symbol (reuse code from challenge 4).
for(def i = 0; i < allArrays[0].size(); i++){
    def pivotArray = []
    allArrays.forEach {  ch ->
        pivotArray << ch[i]
    }
    answerMost = answerMost + Cipher.mostPopular(pivotArray, true)
    answerLeast = answerLeast + Cipher.mostPopular(pivotArray, false)

}

println answerMost
println answerLeast




// Print out symbol