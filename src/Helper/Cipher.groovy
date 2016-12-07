package Helper

/**
 * Created by Chris on 2016-12-04.
 */

// Code that helps cipher and decipher strings
class Cipher {

    static String decipher(k, text) {
        def c = { (it*2)[k..(k+25)].join() }
        text.tr('a-zA-Z', c('a'..'z') + c('A'..'Z'))
    }

    // Returns the most (mode = true) or least (mode = false) popular character in a List
    static String mostPopular(List text, Boolean mode) {
        // Sort the list
        text.sort()
        String current = text[0]

        // Group like terms together
        def cat = []
        for(def j = 1; j <= text.size(); j++){
            if(text[j] != current[0]){
                cat << current
                current = text[j]
            }
            else
            {
                current = current + text[j]
            }
        }

        // Sort to find most or least popular
        if(mode){
            cat.sort {x,y -> y.size() <=> x.size()}
            return cat.take(1)[0][0]
        }
        else {
            // Sort to find least popular
            cat.sort { x, y -> x.size() <=> y.size() }
            return cat.take(1)[0][0]
        }
    }
}

