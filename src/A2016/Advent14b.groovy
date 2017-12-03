package A2016
/**
 * Created by Chris on 2016-12-04.
 *
 * Solve Day 14 Challenge 2
 * Creates a list of Stretched hashes to use, finds matches, and continues on extending the list each time
 */

import java.security.MessageDigest

// Generate and MD5 hash, iterated over a number of times
def generateMD5_A(String s, int stretch = 1){
    stretch.times{
        s = MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
    }
    return s
}

// Find three or more indentical symbols in a row
def findTriplet(String s){
        def x = s.find(/(.)\1\1/)
        if(x){ return x[0] }
}

String findQuintThousand(char x, int t, List listOfHash){
    int loop = t
    while( loop <= t+1000){
        String testHash = listOfHash[loop]
        if(testHash.contains("$x$x$x$x$x")){
            return testHash
        }
        loop++
    }
}

// Our requirements.  Number of times to MD%, the Salt and the Total Keys needed.
int STRETCH = 2017
int TOTAL_NEEDED = 64
def SALT = "ahsbgdzn"

// Use index to find out far we have gone, found to count the number
int index = 0
int found = 0

// Holders for our answers. List of Hashes we keep all the stretched hashes collected so far, Answer Map to track our keys.
List listOfHash = []
def mapOfAnswers = [:]

// Loop around until we have all our keys
while(found < TOTAL_NEEDED){
    // create and extend our hash list so it's always 1001 more than our current.
    // probably would want to clean up the hashes we've passed
    while(listOfHash.size() <= index + 1001){
        def code = SALT + (listOfHash.size()+1).toString()
        listOfHash << generateMD5_A(code, STRETCH)
    }

    // Check for a triplet in the current hash row
    def trip = findTriplet(listOfHash[index].toString())
    if(trip){
        // If we find match, look through the next 1000 hashes for a quintuple occurrence
        def foundMatch = findQuintThousand(trip[0].toCharacter(), index+1, listOfHash)
        if(foundMatch){
            mapOfAnswers.put((index+1), foundMatch)
            println("$found | ${index+1} ... ${mapOfAnswers[index+1]}")
            found++
        }
    }
    index++
}

println mapOfAnswers[index]
