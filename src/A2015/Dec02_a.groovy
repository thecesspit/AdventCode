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

// Load in a Data File
BigInteger total = 0
def input = new File("DecFiles/Dec02")
input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        List <String> rawsizes = []
        List <Integer> sizes = []
        rawsizes = line.tokenize('x')
        rawsizes.each{ sizes << it.toInteger() }
        total = total + wrappingNeeded(sizes)
    }
}

println total
