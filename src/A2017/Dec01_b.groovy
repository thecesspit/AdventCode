package A2017
/**
 * Created by Chris on 2017-11-30.
 *
 * From http://adventofcode.com/2017/day/1
 */

// Load in a Data File and tokenize
def inputString = new File("DecFiles/Dec01").text
def answer = 0

// Split the string in half, compare each at the same index, then multiple by two
def string1 = inputString.substring(0,(int) (inputString.size()/2))
def string2 = inputString.substring((int) (inputString.size()/2))

string1.eachWithIndex{ String entry, int i ->
    if(entry == string2[i]){
        answer = answer + entry.toInteger()
    }
}

println answer * 2

/*
def testStrings = [[1122,3], [1111,4], [1234,0], [91212129,9]]

testStrings.each{
    println numberCaptcha(it[0].toString())
}
*/
