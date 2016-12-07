/**
 * Created by Chris on 2016-12-04.
 */

import Helper.Cipher

// Advent of Code challenge 4.  Reads in a file of encoded room names, and then checks if it matches a checksum

File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent4a_input.txt")

String line

def count = 0
def decoder = new Cipher()

// Read in a line, split out the data, room number and checksum
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def roomData = line.tokenize('-')
        def roomNumber = roomData.last().tokenize('[]')[0]
        def roomChecksum = roomData.last().tokenize('[]')[1]
        roomData = roomData.dropRight(1)
        // For each item, add into a single string
        def roomList = []
        roomData.each {
            it.each {
                roomList = roomList + it
            }
        }
        // Sort the list
        roomList.sort()
        String current = roomList[0]
        // Group like terms together
         def roomListCat = []
        for(def i = 1; i <= roomList.size(); i++){
            if(roomList[i] != current[0]){
                roomListCat << current
                current = roomList[i]
            }
            else
            {
                current = current + roomList[i]
            }
        }
        roomListCat.sort {x,y -> y.size() <=> x.size()}

        // Create our checksum, and compare it
        def roomChk = ""
        roomListCat.take(5).each{
            roomChk = roomChk + it[0]
        }
        if(roomChk == roomChecksum){
            // We now know the room is valid, so decode it
            roomNumber = roomNumber.toInteger() % 26
            println decoder.decipher(roomNumber,line)
        }
    }
}

println count
