package Helper

/**
 * Created by Chris on 2016-12-14.
 */
class Screen {

    public int height = 1
    public int width = 1

    List screen = []

    // Screen creator
    Screen(int height, int width) {
        this.height = height
        this.width = width

        // Create the array of Lists for the screen
        // Each row is it's own array, so screen[3][2] is row 3, col 2
        height.times { x ->
            screen << []
            width.times { screen[x] << '.'  }
        }
        this.report()
        println()
    }

    // Outputs the screen
    int report(){
        int count = 0
        height.times { int x ->
            width.times { int y ->
                if(screen[x][y] == '#'){ count++ }
                print screen[x][y]
            }
            println '   / '
        }
        println("Lit Pixels = $count")

        return count
    }

    // Creates a x by y rectangle in the upper left corner
    def rect(int x, int y){
        x.times{ int a ->
            y.times{ int b ->
                screen[a][b] = '#'
            }
        }
    }

    // Rotate a column X. Put 0 index into bottom index, shift everything up one
    def rotate_column(int col){
        int h
        def rollover = screen[height-1][col]
        for(h = (height - 1) ; h >= 1 ; h--){
            screen[h][col] = screen[h-1][col]
        }
    screen[0][col] = rollover
    }

    // Def multiple rotation
    def rotate_column(int col, int t){
        t.times{
            this.rotate_column(col)
        }
    }
    
    //Rotate a row Y.  Put 0 index into right index, shift the rest left.
    def rotate_row(int row){
        int r
        def rollover = screen[row][width-1]
        for(r = (width - 1) ; r >= 1; r--){
            screen[row][r] = screen[row][r-1]
        }
        screen[row][0] = rollover
    }

    // Multiple row rotations
    def rotate_row(int row, int t){
        t.times{
            this.rotate_row(row)
        }
    }
}

