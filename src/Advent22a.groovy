import Helper.DataNode

/**
 * Created by Chris on 2016-12-21.
 *
 * For advent of Code Day 22.
 *
 * Loads in the data from the file, and places it into dataNode objects.
 * Grid is constructed of the node.
 *
 * Then for each node, find out if it has viable pair with each other node
 *
 */

// Read in the file
// For each node tokenize and put the data into a dataNode object
File input = new File("C:/Users/Chris/IdeaProjects/AdventCode/AdventFiles/Advent22a_input.txt")
def line
int count = 0

// Create the Data grid
DataNode [][] dataGrid = new DataNode[37][27]

input.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        int x
        int y
        line.find(/(x)(\d+)/){ match ->
            x = match[2].toInteger()
        }
        line.find(/(y)(\d+)/){ match ->
            y = match[2].toInteger()
        }

        List <String> sizeList = line.findAll(/(\d+)T/)
        int size = sizeList[0].takeWhile { it != "T" }.toInteger()
        int used = sizeList[1].takeWhile { it != "T" }.toInteger()
        int available = sizeList[2].takeWhile { it != "T" }.toInteger()

        def node = new DataNode(x,y, size, used, available)
        dataGrid[x][y] = node
    }
}

// For each node, find the number of pairs
dataGrid.each { dataRow ->
    dataRow.each { node ->
        if (node) {
            count += node.viablePartners(dataGrid)
            print(" $node.available ")
        }
    }
    println()
}

dataGrid[0][0].adjacentPartner(dataGrid)


println count
