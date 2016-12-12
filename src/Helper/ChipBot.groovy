package Helper

/**
 * Created by Chris on 2016-12-11.
 */
class ChipBot {

    // Each Chipbot has two registers, high and low
    int high = 0
    int low = 0
    def distributionRule = [0,0]

    List outputArray
    List chipbotList

    // Constructor
    ChipBot(List globalOutputs, List globalChipBots, int high = 0, int low = 0, distributionRule = [0,0]){
        this.high = high
        this.low = low
        outputArray = globalOutputs
        chipbotList = globalChipBots
        this.distributionRule = distributionRule
    }

    // Method to load a chip.  If bot is empty handed, place in low, else sort the chips
    def loadChip(int chipNumber){
        if(high == 0 && low == 0){
            low = chipNumber
        }
        else{
            if(low < chipNumber){ high = chipNumber }
            if(low > chipNumber){ high = low; low = chipNumber}
        }
    }

    // Set Rule
    def setChipRule(int lowRule, int highRule){
        distributionRule[0] = lowRule
        distributionRule[1] = highRule
    }

    // Method to output chips
    def unloadChips(){
        // If destination is negative, load to another bot
        if(distributionRule[0] < 0 ){ chipbotList[distributionRule[0] * -1].loadChip(low) }
        if(distributionRule[1] < 0 ){ chipbotList[distributionRule[0] * -1].loadChip(high) }
        if(distributionRule[0] > 0 ){ outputArray[distributionRule[0]] = low }
        if(distributionRule[1] > 0 ){ outputArray[distributionRule[1]] = high }
    }

    // Print method to show contents
    def botStatus(){
        println("$low ... $high .. $distributionRule")
    }
}
