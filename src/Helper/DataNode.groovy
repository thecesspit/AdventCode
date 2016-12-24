package Helper

/**
 * Created by Chris on 2016-12-23.
 */
class DataNode {
    int x
    int y
    int size
    int used
    int available

    // Create a new Data Node
   DataNode(int x, int y, int size, int used, int available){
        this.x = x
        this.y = y
        this.size = size
        this.used = used
        this.available = available
    }
    // Print out the data node info
    def reportAll(){
        println("$size .. $used .. $available")
    }

    // Returns the viable partners for a node
    def viablePartners(datagrid){
        int grid_x = datagrid.size()
        int grid_y = datagrid[0].size()
        int partner = 0

        for(def row = 0; row < grid_x; row++){
            for(def column = 0; column < grid_y; column++){
                // Check there's Data in the node
                if(datagrid[x][y]?.used != 0){
                    // Check not the current node
                    if(!(row == x && column == y)){
                        if(used <= datagrid[row][column].available){
                            partner ++
                        }
                    }
                }
            }
        }
    return partner
    }

    // Return adjacent partners
    def adjacentPartner(datagrid){
        int grid_x = datagrid.size()
        int grid_y = datagrid[0].size()

        if(used <= datagrid[x-1][y]?.available){
            println("Partner Left")
        }
        if(used <= datagrid[x+1][y]?.available){
            println("Partner Right")
        }
        if(used <= datagrid[x][y-1]?.available){
            println("Partner Up")
        }
        if(used <= datagrid[x][y+1]?.available){
            println("Partner Down")
        }

    }
}
