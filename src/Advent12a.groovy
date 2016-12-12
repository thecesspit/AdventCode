import Helper.ChipBot
import Helper.assemBunny

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 12.
// Read in file line by line into an array of instructions
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent12a_input.txt")

def instructions = []

// Read in all the line, and for each value line, load our chips
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        instructions << line.tokenize()
    }
}

println instructions

santa = new assemBunny()
santa.report()
// Now read our instructions
println instructions.size()
while(santa.pc  < instructions.size()){
    santa.report()
    // Copy Case
    if(instructions[santa.pc][0] == 'cpy'){
        santa.copy(instructions[santa.pc][1], instructions[santa.pc][2] )
    }
    // Inc Case
    else if(instructions[santa.pc][0] == 'inc'){
        santa.inc(instructions[santa.pc][1])
    }
    // Dec Case
    else if(instructions[santa.pc][0] == 'dec'){
        santa.dec(instructions[santa.pc][1])
    }
    // Jmp Case
    else if(instructions[santa.pc][0] == 'jnz'){
        santa.jump(instructions[santa.pc][1], instructions[santa.pc][2])
    }
}
santa.report()

