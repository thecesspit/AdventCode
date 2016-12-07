package Helper
/**
 * Created by Chris on 2016-12-03.
 * Designed to do vector math
 */

class myVector{

    def public vec = [0,0]

    myVector(int a, int b)
    {
        vec[0] = a
        vec[1] = b
    }

    // Adds the new vector
    def addVector(myVector b)
    {

        this.vec[0] = this.vec[0]+b.vec[0]
        this.vec[1] = this.vec[1]+b.vec[1]
    }

    // return size of a Vector from 0
    def sizeofVector()
    {
        return vec[0].abs() + vec[1].abs()
    }

    // turn the vector 90 degrees
    def rotateVector(String change)
    {
        if (change == 'L') {
            vec = [-vec[1], vec[0]]
        } else {
            vec = [vec[1], -vec[0]]
        }
    }

    // Multiply a vector by a scale, and return a new vector
    def scaleVector(int scale){
        def newVector = new myVector(this.vec[0],this.vec[1])
        newVector.vec[0] = newVector.vec[0] * scale
        newVector.vec[1] = newVector.vec[1] * scale

        return newVector
    }
}
