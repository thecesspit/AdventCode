/**
 * Created by Chris on 2016-12-04.
 *
 * Advent of Code Day 16
 *
 * A magic checksum coder
 */

// Take a Boolean list and create a checksum
def checksum(List <Boolean> checkList){
    while(checkList.size() % 2 == 0){
        List <Boolean> newCheckList = []
        for(def i = 0; i < checkList.size(); i = i + 2){
            if(checkList[i] == checkList[i+1]){ newCheckList << true}
            else{ newCheckList << false }
        }
        checkList = newCheckList
    }
    return checkList
}

// Create a new padded String using the Dragon
List <Boolean> dragonPad(List <Boolean> listToExtend){
    List padding = listToExtend
    padding = padding.reverse()
    padding.eachWithIndex{  x, i ->
        if(x){ padding[i] = false}
        else{ padding[i] = true}
    }
    listToExtend << false
    listToExtend << padding
    return listToExtend.flatten()

}

def prettyPrintBooleanList(List <Boolean> output){
    output.each {
        if (it) { print "1" }
        else { print "0" }
    }
    println()

}

int DISKSIZE = 35651584
String input = "11110010111001001"
List <Boolean> disk = []
input.each{
    if(it == "1"){ disk << true }
    else{ disk << false }
}


// Fill the disk with padding data
while(disk.size() < DISKSIZE){
    disk = dragonPad(disk)
    println disk.size()
}

//prettyPrintBooleanList(disk)


// Take only the disk size of information
disk = disk.take(DISKSIZE)
def checksum = checksum(disk)
println()
prettyPrintBooleanList(checksum)




