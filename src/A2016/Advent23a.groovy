package A2016

import Helper.ChipBot
import Helper.assemBunny

/**
 * Created by Chris on 2016-12-05.
 */


// Advent of Code challenge 23.
// Used Day 12's computer again with some new magic.
// Read in file line by line into an array of instructions
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent23a_input.txt")

List <String> instructions = []

// Read in all the line, and for each value line, load our chips
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        instructions << line.tokenize()
    }
}

println instructions

santa = new assemBunny()
santa.registers['a'] = 12
santa.report()
// Now read our instructions
println instructions.size()
while(santa.pc  < instructions.size()){

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
    // Jnz Case
    else if(instructions[santa.pc][0] == 'jnz'){
        santa.jump(instructions[santa.pc][1], instructions[santa.pc][2])
    }
    // Tgl Case
    else if(instructions[santa.pc][0] == 'tgl'){
        santa.tgl(instructions[santa.pc][1], instructions)
        santa.pc++
    }
    santa.report()
}
santa.report()

