package A2016
/**
 * Created by Chris on 2016-12-04.
 */

import java.security.MessageDigest

def generateMD5_A(String s, int stretch = 1){
    stretch.times{
        s = MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
    }
    return s
}

def findTriplet(String s){
        def x = s.find(/(.)\1\1/)
        if(x){ return x[0] }
}

String findQuintThousand(String salt, int index, char x, int stretch = 1){
    def loop = 1
    while( loop <= 1001){
        def testCode = salt + (index + loop).toString()
        def testHash = generateMD5_A(testCode, stretch)
        for(def i = 0; i <= testHash.length(); i++){
            if(testHash.contains("$x$x$x$x$x")){
                return testHash
            }
        }
        loop++
    }
}

// Track the index to add to the salt, the number of matches found, and total needed.
// Save our matches in the listOfHash table array.  it might come in useful
int index = 0
int found = 0
int TOTAL_NEEDED = 64
def salt = "ahsbgdzn"
def hash
def listOfHash = []
int stretch = 2017


while(found < TOTAL_NEEDED){
    // create a new hash
    def code = salt + index.toString()
    hash = generateMD5_A(code, stretch)

    // Check for a triplet
    def trip = findTriplet(hash)
    if(trip){
        def foundMatch = findQuintThousand(salt, index, trip[0].toCharacter(), stretch)
        if(foundMatch){
            listOfHash << hash
            println("$found | $index ... $hash ... $foundMatch")
            found++
        }
    }
    index++
}

println listOfHash.last()
println listOfHash.size()
println index