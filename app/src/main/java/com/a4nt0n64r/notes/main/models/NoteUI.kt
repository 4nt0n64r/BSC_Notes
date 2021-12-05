package com.a4nt0n64r.notes.main.models

import java.io.Serializable

/**
 * Класс заметки
 */
data class NoteUI(
    val header: String,
    val text: String,
    val date: String
) : Serializable
