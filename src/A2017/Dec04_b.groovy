/**
 * Created by Chris on 03-Dec-17.
 *
 * Advent of Code day 4
 */

// Load in a Data File
BigInteger total = 0
def input = new File("DecFiles/Dec04")
input.withReader { reader ->
    // read in each line to see if it's valid
    while ((line = reader.readLine()) != null) {
        def passPhrase = line.tokenize(' ')
        println passPhrase
        // sort each word alphabetically in the passPhrase
        def sortedPassPhrase = []
        passPhrase.eachWithIndex{    word, int index ->
            def newWord = word.toList()
            sortedPassPhrase << newWord.sort()
        }

        def matchFound = false
        // for each word in the passPhrase, count how many words match in the passPhrase, if more than 1, it's invalid
        // so set matchFound to true
        sortedPassPhrase.eachWithIndex{ word, int index ->
            def matches = sortedPassPhrase.findAll{  it == word }
            if(matches.size() > 1){ matchFound = true}
        }
        if(!matchFound){ total ++ }
    }
}

println total
