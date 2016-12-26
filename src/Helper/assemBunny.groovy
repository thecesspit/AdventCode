package Helper

/**
 * Created by Chris on 2016-12-11.
 */
class assemBunny {
    // Define our registers
    Map<String, Integer> registers = [a:0, b:0, c:1, d:0]
    public int pc

    // Creator
    assemBunny(){
        pc = 0
        println ("Initialized the Bunny with $pc")
    }

    // Cpy
    def copy(String x, String y){
        if(x == 'a' || x == 'b' || x == 'c' || x == 'd'){ registers[y] = registers[x]}
        else{ registers[y] = x.toInteger() }
        pc++
    }

    // inc
    def inc(String x){
        registers[x]++
        pc++
    }

    // dec
    def dec(String x){
        registers[x]--
        pc++
    }

    //jnz
    def jump(String x, String y){
        if(registers[x] != 0){
            // Passed in a numeric
            if(y.find(/^(-)*(\d+)$/)){
                pc = pc + y.toInteger()
            }
            // Passed in a register value
            else if(y.find(/^[abcd]$/)){
                pc = pc + registers[y]
            }
            else
            {
                println("$x $y")
            }
        }
        else{ pc++ }
    }

    //tgl
    def tgl(x, instructions){
        int jump = registers[x]

        if(!instructions[pc+jump]){
            println "Skipping Toggle"
        }
        else if(instructions[pc + jump][0] == 'inc' ){
            instructions[pc + jump][0] = 'dec'
        }
        else if(instructions[pc + jump][0] == 'dec' ){
            instructions[pc + jump][0] = 'inc'
        }
        else if(instructions[pc + jump][0] == 'tgl' ){
            instructions[pc + jump][0] = 'inc'
        }
        else if(instructions[pc + jump][0] == 'jnz' ){
            instructions[pc + jump][0] = 'cpy'
        }
        else if(instructions[pc + jump][0] == 'cpy' ){
            instructions[pc + jump][0] = 'jnz'
        }
    }

    //Report on our registers
    def report(){
        registers.each {
            print("${it.key} .. $it.value ..")
        }
        println(" // $pc")
    }
}
