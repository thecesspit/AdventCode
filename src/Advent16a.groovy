/**
 * Created by Chris on 2016-12-04.
 *
 * Advent of Code Day 16
 *
 * A magic checksum coder
 */

// Take a Boolean list and create a checksum
def checksum(String checkList){
    while(checkList.size() % 2 == 0){
        String newCheckList = ""
        for(def i = 0; i < checkList.length(); i = i + 2){
            if(checkList[i] == checkList[i+1]){ newCheckList = newCheckList + "1"}
            else{ newCheckList = newCheckList + "0"}
        }
        checkList = newCheckList
    }
    return checkList
}

// Create a new padded String using the Dragon
def dragonPad(String stringToExtend){
    String padding = stringToExtend
    padding = padding.reverse()
    String newPadding = ""
    padding.each{  x ->
        if(x == "1"){ newPadding += "0"}
        else{ newPadding += "1"}
    }
    return  stringToExtend + "0" + newPadding
}

int DISKSIZE = 35651584
String input = "11110010111001001"
String disk = input

// Fill the disk with padding data
while(disk.length() < DISKSIZE){
    disk = dragonPad(disk)
    println disk.length()
}

// Take only the disk size of information
disk = disk.take(DISKSIZE)
def checksum = checksum(disk)
println(checksum)


