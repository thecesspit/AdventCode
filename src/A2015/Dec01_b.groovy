/**
 * Created by Chris on 02-Dec-17.
 *
 * 2015 - Dec 01 code
 */

// Function to find out the floor after the string of ( )'s
int basementFinder(bracketString){
    def floor = 0
    def answer = 0
    for(def i = 0; i < bracketString.size(); i++)
    {
        if(bracketString[i] == '(') { floor++ }
        if(bracketString[i] == ')') { floor -- }
        if(floor == -1){ answer = i+1; break }
    }
    return answer
}

// Load in a Data File
def input = new File("DecFiles/Dec01")
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        print basementFinder(line)
    }
}