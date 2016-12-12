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

    //jmp
    def jump(String x, String y){
        if(registers[x] != 0){ pc = pc + y.toInteger()}
        else{ pc++ }
    }

    //Report on our registers
    def report(){
        registers.each {
            print("${it.key} .. $it.value ..")
        }
        println(" // $pc")
    }
}
