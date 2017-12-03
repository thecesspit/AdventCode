package A2016

import Helper.ChipBot

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 10.
// Read in file line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent10a_test.txt")

String line

List chipbotsList = []
List <ChipBot> outputBins = []

// Create Chip Bots
3.times{
    chipbotsList << new ChipBot(outputBins,chipbotsList,0,0,[0,0])
}

// Read in all the line, and for each value line, load our chips
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        // Readline
        def elements = line.tokenize(" ")
        // If a value line, set up the samples
        if (elements.head() == "value") {
            println line
            chipbotsList[elements[5].toInteger()].loadChip(elements[1].toInteger())
        }
    }
    chipbotsList.each { ChipBot a ->
        a.botStatus()
    }
}

// Now for each value line, set the rule
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        // Readline
        def elements = line.tokenize(" ")
        // If a value line, set up the samples
        if(elements[2] == "gives" ){
            println line
            def bot = elements[1].toInteger()
            def lowDest = elements[5]
            def highDest = elements[10]
            def lowRule = elements[6].toInteger()
            def highRule = elements[11].toInteger()
            if(lowDest == 'bot'){ lowRule = lowRule * -1 }
            if(highDest == 'bot'){ highRule = highRule * -1}
            chipbotsList[bot].setChipRule(lowRule, highRule)
        }
    }
    chipbotsList.each { ChipBot a ->
        a.botStatus()
    }
    chipbotsList.each { ChipBot b ->
        b.unloadChips()
    }

    println()

    chipbotsList.each { ChipBot a ->
        a.botStatus()
    }

    println outputBins
}



