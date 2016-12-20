/**
 * Created by Chris on 2016-12-19.
 *
 * Creates a map based on the simple rules for each row.
 */

// Work out the space based on previous 3 spaces
def newSpace(String border){
    if(border == "^.." || border == "..^"){ return "^"}
    if(border == "^^." || border == ".^^"){ return "^"}
    else{ return "." }
}

def countSafe(List room){

    int count = 0

    room.each{ it ->
        it.each{  space ->
            if(space == "."){ count++ }
        }
    }

    return count
}

// Set up room size
int ROOM_LENGTH = 400000

// Set up a room array
String initialRow = ".^.^..^......^^^^^...^^^...^...^....^^.^...^.^^^^....^...^^.^^^...^^^^.^^.^.^^..^.^^^..^^^^^^.^^^..^"
int ROOM_WIDTH = initialRow.length()
initialRow += "."
initialRow = "." + initialRow

// Create our room
List <String> room = []
room << initialRow

while(room.size() < ROOM_LENGTH) {
    def newRow = "."
    for (int i = 1; i <= ROOM_WIDTH; i++) {
        newRow = newRow + newSpace(room[room.size()-1][i - 1..i + 1])
    }
    newRow = newRow + "."
    room << newRow
}


// Tidy rows to show walls
def finalRoom = []

room.eachWithIndex{  row, index ->
    finalRoom[index] = "|" + row.substring(1,ROOM_WIDTH+1) + "|"

    println finalRoom[index]
}
println()

println countSafe(finalRoom)

