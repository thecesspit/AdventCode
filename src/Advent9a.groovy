import Helper.Cipher

import java.lang.reflect.Array

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 0.
// Read in file line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent9a_input.txt")

String line


// Read in all the lines into array.
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        String newline = ""
        // replace all ( with (* and ) with &) before the tokenization
        line = line.replace('(','(*')
        line = line.replace(')','&)')
        List instructions = line.tokenize('()')
        // Walk through the instructions, looking at the head each time and making a decision
        while(instructions != [])
        {
            def next_instruction = instructions.head()
            instructions = instructions.drop(1)
            if(next_instruction[0] == '*'){
                // we have an instruction to follow, find the number and repeater
                int repeat = next_instruction.tokenize('*x&')[1].toInteger()
                int length = next_instruction.tokenize('*x&')[0].toInteger()
                // Now take the next part of our string and to create the repeated set
                String repeater = ""
                while(repeater.length() <= length && instructions != [])
                {
                    repeater = repeater + instructions.head()
                    instructions = instructions.drop(1)
                }
                // If we took too much, return the end of the string
                if(repeater.length() > length){
                    def return_to_instructions = repeater[length..-1]
                    repeater = repeater[0..length-1]
                    instructions[0..<0] = return_to_instructions
                }
                repeat.times{ newline = newline + repeater}
            }
            // Or we just dump whatever is in the next item into the newline.
            else{ newline = newline + next_instruction .toString()}
        }
        /*
        instructions.eachWithIndex{  String nextitem, i ->
            println nextitem

        }*/
        newline = newline.replace('*','(')
        newline = newline.replace('&',')')
        println newline
        println newline.length()
        println ""
    }
}



