
/**
 * Created by Chris on 2017-12-02.
 * Advent of code 2017, challenge 3
 * http://adventofcode.com/2017/day/3
 */


def answer = 0
double input = 265149

// First, work out which ring the number is on - find which odd square is higher, subtract one, divide by two.
double ring = 0
double biggestRingInteger = 1
double lowestRingInteger = 0
while(input > biggestRingInteger) {
    ring++
    biggestRingInteger = ((ring*2) + 1) ** 2
}

lowestRingInteger = ((ring-1)*2 + 1)**2

// Then work out the four numbers on a direct line to the centre
ringCardinalPoints = []
(0..3).forEach{  i ->
    ringCardinalPoints << lowestRingInteger + ring + (ring * i * 2)
}
println ringCardinalPoints

// Now find out which is the closest to our target.
// This minimal difference will be the steps to the closest rin point to the centre
def closestPoints = []
ringCardinalPoints.each{
    closestPoints << (it - input).abs()
}

// Print answer
answer = answer + ring + closestPoints.min()
println ring
println answer