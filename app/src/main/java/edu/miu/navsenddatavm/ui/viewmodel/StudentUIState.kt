package edu.miu.navsenddatavm.ui.viewmodel

import edu.miu.navsenddatavm.model.Student

data class StudentUIState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)