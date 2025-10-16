package ro.alexmamo.roomjetpackcompose.domain

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository
import ro.alexmamo.roomjetpackcompose.utils.getTodoTest
import ro.alexmamo.roomjetpackcompose.utils.getUpdatedTodoTest
import javax.inject.Inject

@HiltAndroidTest
class TodoRepositoryTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Inject
    lateinit var fakeRepo: TodoRepository

    val context = ApplicationProvider.getApplicationContext<Context>()
    private val todoTest = getTodoTest(context)
    private val updatedTodoTest = getUpdatedTodoTest(context)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testInsertAndGetTodoById() = runBlocking {
        fakeRepo.insertTodo(todoTest)
        val todo = fakeRepo.getTodoById(todoTest.id)
        Truth.assertThat(todo).isEqualTo(todoTest)
    }

    @Test
    fun testInsertAndCheckIfTodoExistsInTodoList() = runBlocking {
        fakeRepo.insertTodo(todoTest)
        val todoList = fakeRepo.getTodoList().first()
        Truth.assertThat(todoTest).isIn(todoList)
    }

    @Test
    fun testInsertAndCheckTheSizeOfTodoList() = runTest {
        fakeRepo.insertTodo(todoTest)
        val todoList = fakeRepo.getTodoList().first()
        Truth.assertThat(todoList.size).isEqualTo(1)
    }

    @Test
    fun testUpdateAndGetTodoById() = runTest {
        fakeRepo.insertTodo(todoTest)
        fakeRepo.updateTodo(updatedTodoTest)
        val todo = fakeRepo.getTodoById(todoTest.id)
        Truth.assertThat(todo?.name).isEqualTo(updatedTodoTest.name)
    }

    @Test
    @Throws(Exception::class)
    fun testInsertAndDeleteAndCheckTheSizeOfTodoList() = runTest {
        fakeRepo.insertTodo(todoTest)
        fakeRepo.deleteTodo(todoTest)
        val todoList = fakeRepo.getTodoList().first()
        Truth.assertThat(todoList).isEmpty()
    }
}