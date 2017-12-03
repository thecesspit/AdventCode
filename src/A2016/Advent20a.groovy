package A2016
/**
 * Created by Chris on 2016-12-20.
 *
 * Day 20 on the Advent of Code.
 *
 * Find the lowest unblocked IP
 *
 * - import the IP block table into a list of pairs
 * - sort the list by the first number in each pair
 * - starting from 0, find a pair that the number is in
 * - jump to the last number in the pair + 1
 * - repeat till we fall through.
 */


// Import the IP Block list
// Read in instructions, line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent20a_input.txt")
def line

List <List <BigInteger>> blockedPorts = []

input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        blockedPorts << line.tokenize('-')
    }
}
// Sort the Ports list
blockedPorts.sort{ a,b -> a[0] <=> b[0] }

// Start finding an open port
BigInteger openPort = 0
List <BigInteger> openPorts  = []

BigInteger maxAnswer = 4294967295

println maxAnswer

while(openPort < maxAnswer){
    for(def i = 0; i <= blockedPorts.size(); i++) {
        if(i == blockedPorts.size()){
            openPorts << openPort
            openPort ++
            break
        }
        BigInteger lowEnd = blockedPorts[i][0].toBigInteger()
        BigInteger highEnd = blockedPorts[i][1].toBigInteger()
        if(openPort >= lowEnd && openPort <= highEnd){
            // This a blocked Port number
            openPort = highEnd + 1
            break
        }
    }
}

openPorts.each {println it}
println openPorts.size()