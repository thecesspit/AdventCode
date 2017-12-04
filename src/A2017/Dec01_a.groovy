package A2017
/**
 * Created by Chris on 2017-11-30.
 */

def numberCaptcha(String numberString){
    int answer = 0
     numberString.eachWithIndex{   value, int index ->
        if(index+1 == numberString.size()){
            if(value == numberString[0]){
                answer = answer + value.toInteger()
            }
        }
        else if(value == numberString[index+1]){
            answer = answer + value.toInteger()
        }
    }
    return answer
}

// Load in a Data File and tokenize
def inputString = new File("DecFiles/Dec01").text

println numberCaptcha(inputString)

/*
def testStrings = [[1122,3], [1111,4], [1234,0], [91212129,9]]

testStrings.each{
    println numberCaptcha(it[0].toString())
}
*/
