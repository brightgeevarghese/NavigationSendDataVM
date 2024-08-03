package edu.miu.navsenddatavm.ui.viewmodel


import androidx.lifecycle.ViewModel
import edu.miu.navsenddatavm.model.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel: ViewModel() {
    private val _studentUIState = MutableStateFlow(StudentUIState())
    val studentUIState = _studentUIState.asStateFlow()

    fun setStudent(student: Student) {
        _studentUIState.value = _studentUIState.value.copy(student = student)
    }

    fun setLoading(isLoading: Boolean) {
        _studentUIState.value = _studentUIState.value.copy(isLoading = isLoading)
    }

    fun setError(error: String) {
        _studentUIState.value = _studentUIState.value.copy(error = error)
    }

}