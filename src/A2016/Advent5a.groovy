package A2016
/**
 * Created by Chris on 2016-12-04.
 */

import java.security.MessageDigest

def generateMD5_A(String s){
    MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
}

// placeholder for answer
def answer = ['*','*','*','*','*','*','*','*',]
int index = 0
def doorID = "ffykfhsq"
def found = 0
def validpositions = ['0','1','2','3','4','5','6','7']

while(found < 8){
    def newhash = generateMD5_A(doorID+index.toString())
    if(newhash.take(5) == "00000"){
        def position = newhash[5]
        def hash = newhash[6]
        if(validpositions.find{ it == position}){
            int pos = position.toInteger()
            if(answer[pos] == '*'){
                answer[pos] = hash
                answer.each{
                    print("$it")
                }
                println()
                found ++
            }
        }
    }
    index ++
}

print answer