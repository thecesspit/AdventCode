/**
 * Created by Chris on 02-Dec-17.
 *
 * 2015 - Dec 02 code
 */

// Function to find total square foot for one package
int wrappingNeeded(List dimensions) {

    def answer = 0
    dimensions = dimensions.sort()

    dimensions.each{ entry ->
        dimensions.each{ m ->
            answer = answer + (m * entry)
        }
        answer = answer - (entry * entry)
    }
    // Add the smallest side for stretch
    answer = answer + (dimensions[0]*dimensions[1])

    return answer
}

// Function needed to find total length of ribbon for one package
int ribbonNeeded(List dimensions) {
    def length = 0
    dimensions = dimensions.sort()

    length = 2 * (dimensions[0]+dimensions[1])
    length = length + (dimensions[0] * dimensions[1] * dimensions[2])

    return length
}

// Load in a Data File
BigInteger total = 0
def input = new File("DecFiles/Dec02")

input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        // For entyr, get a tuple of sizes and pass into the ribbon needed function
        List <String> rawsizes
        List <Integer> sizes = []
        rawsizes = line.tokenize('x')
        rawsizes.each{ sizes << it.toInteger() }
        total = total + ribbonNeeded(sizes)
    }
}

println total
