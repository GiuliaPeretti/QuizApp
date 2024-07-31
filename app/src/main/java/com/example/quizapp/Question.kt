package com.example.quizapp

class Question(topic: String, question: String, rightAnswer: String, ans: String) {
    var topic: String = topic
        get() = field
        set(value) { field = value }
    var question: String= question
        get() = field
        set(value) { field = value }
    var rightAnswer: String=rightAnswer
        get() = field
        set(value) { field = value }
    var answers: List<String> = ans.substring(1,ans.length-1).split(';').shuffled()
        get() = field
        set(value) { field = value }

    override fun toString(): String {
        return "Question(topic='$topic', question='$question', rightAnswer='$rightAnswer', answers=$answers)"
    }

}