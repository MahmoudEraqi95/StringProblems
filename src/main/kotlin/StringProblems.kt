package main.kotlin

import kotlin.math.min

class StringProblems {

    fun isPalindrome(s: String): Boolean {
        var originalS = s.toLowerCase().replace(" ", "")
        val regex = Regex("[^a-z0-9]")
        originalS =  regex.replace(originalS, "")
        return originalS == originalS.reversed()
    }


    //Restore IP Addresses till line 43
    val ipAddresses = mutableListOf<String>()
    var ipLength = 0;
    var ip = ""
    var numberOfIterations = 0
    fun restoreIpAddresses(s: String): List<String>{

        if(s.length>12)
            return listOf()
        ipLength = s.length
        ip = s
        restoreIpBacktrack(0, "", 0)
        println(numberOfIterations)
        return ipAddresses
    }

    fun restoreIpBacktrack(i: Int, currentIP: String, numberOfDots: Int){
        numberOfIterations++;
        if (numberOfDots==4 && i==ipLength) {
            ipAddresses.add(currentIP.dropLast(1))
            return
        }
        for( j in i until min(i+3, ipLength)){
            val newBlock = ip.substring(i until j+1)

            if (newBlock.toInt()<256 &&(i == j || ip[i]!= '0'))
                if (ipLength-((currentIP.length)+(j-i))+numberOfDots<(4-numberOfDots)*3)
                    restoreIpBacktrack(j+1, "$currentIP$newBlock.", numberOfDots+1)
        }


    }

}