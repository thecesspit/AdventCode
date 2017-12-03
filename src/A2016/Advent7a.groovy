package A2016

import Helper.Cipher

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 7.
// Read in file line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent7a_input.txt")

String line
def abba_count = 0
def ssl_count = 0

// Read in all the lines into array.
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {

        // Mark if outside brackets and start with not being an ABBA
        Boolean outside = true
        Boolean abba = false
        Boolean search = true
        // FOR ABBA walk along the line and check if the current 0.1 pair equals the 3.2 pair
        for(def i = 0; i < line.length()-3; i++ ){
            if(search && line[i..i+1] == line[i+3..i+2]  && (line[i] != line[i+1])){
                if(outside) { abba = true }
                else{ abba = false; search = false }
            }
            if(line[i] == '['){ outside = false }
            if(line[i] == ']'){ outside = true }
        }
        if(abba){
            abba_count++
        }
        // FOR SSL walk along the line as before.
        // Mark if outside brackets and start with not being an ABBA
        Boolean search_ssl = false
        List newline = line.tokenize('[]')
         def j = 0
        while(j < newline.size()){
            for(def ch = 0; ch < newline[j]?.size()-2; ch++)
            {
                def threeCode = newline[j].substring(ch,ch+3)
                if(threeCode == threeCode.reverse() && threeCode[0] != threeCode[1])
                {
                    // Search the inside strings
                    for(def ins = 1; ins < newline.size(); ins = ins + 2)
                    {
                        def newThreeCode = threeCode.substring(0,2).reverse() + threeCode.substring(1,2)
                        if( newline[ins].contains(newThreeCode))
                        {
                            search_ssl = true
                        }
                    }
                }

            }
            j = j+2
        }
        if(search_ssl){
            ssl_count++
        }
    }
}


println abba_count
println ssl_count