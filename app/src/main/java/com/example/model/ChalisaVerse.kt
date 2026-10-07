package com.example.model

enum class VerseType {
    DOHA,
    CHAUPAI
}

data class ChalisaVerse(
    val id: Int,
    val type: VerseType,
    val numberTitle: String,
    val numberTitleHindi: String,
    val hindiText: String,
    val englishTranslit: String,
    val gujaratiText: String,
    val marathiText: String,
    val hindiMeaning: String,
    val englishMeaning: String
)
