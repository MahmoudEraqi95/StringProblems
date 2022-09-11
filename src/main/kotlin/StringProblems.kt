package main.kotlin

class StringProblems {

    fun isPalindrome(s: String): Boolean {
        var originalS = s.toLowerCase().replace(" ", "")
        val regex = Regex("[^a-z0-9]")
        originalS =  regex.replace(originalS, "")
        return originalS == originalS.reversed()
    }

}