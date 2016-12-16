import Helper.Cipher
import Helper.Screen

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 8.
// Read in file line by line
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent8a_input.txt")
String line

Screen s = new Screen(6,50)

// Read in all the lines into array.
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        def instruction = line.tokenize()
        println(instruction)
        // If rect, call rect class
        if(instruction.head() == 'rect'){ s.rect(instruction[1].tokenize('x')[1].toInteger(), instruction[1].tokenize('x')[0].toInteger())}
        // If rotate, find out whether column or row
        if(instruction.head() == 'rotate'){
            // find index
            def index_number = instruction[2].tokenize('=')[1].toInteger()
            // find number
            def rot_number = instruction[4].toInteger()
            if (instruction[1] == 'row'){ s.rotate_row(index_number, rot_number) }
            if (instruction[1] == 'column'){ s.rotate_column(index_number, rot_number)}
        }
    }
}



s.report()




