package ru.konsli.feature_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.konsli.feature_home.domain.model.Course
import ru.konsli.feature_home.domain.usecase.GetCoursesUseCase
import ru.konsli.feature_home.domain.usecase.RefreshCoursesUseCase
import ru.konsli.feature_home.domain.usecase.UpdateFavoriteUseCase
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase,
    private val refreshCoursesUseCase: RefreshCoursesUseCase
): ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadCourses()

        refreshCourses()
    }

    private fun refreshCourses(){
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                refreshCoursesUseCase()
            }
            catch (e: Exception){
                _state.update { it.copy(error = e.message) }
            }

            _state.update { it.copy(isLoading = false) }
        }
    }
    // Метод загрузки курсов. Данные отправляются автоматически при изменении
    private fun loadCourses(){
        viewModelScope.launch{
            getCoursesUseCase().collect{ courses ->
                _state.update {
                    it.copy(courses = courses)
                }
            }
        }
    }

    // Метод изменения статуса избранного
    fun onClickFavorite(course: Course){
        viewModelScope.launch {
            updateFavoriteUseCase(
                course.id,
                !course.isFavorite // При нажатии состояние будет меняться на обратное
            )
        }
    }

}