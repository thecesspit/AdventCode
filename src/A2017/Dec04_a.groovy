/**
 * Created by Chris on 03-Dec-17.
 *
 * Advent of Code day 4
 */

// Load in a Data File
BigInteger total = 0
def input = new File("DecFiles/Dec04")
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def passphrase = line.tokenize(' ')
        println passphrase
        def matchFound = false
        passphrase.eachWithIndex{    String word, int index ->
            def matches = passphrase.findAll{  it == word }
            if(matches.size() > 1){ matchFound = true}
        }
        if(!matchFound){ total ++ }
    }
}

println total
