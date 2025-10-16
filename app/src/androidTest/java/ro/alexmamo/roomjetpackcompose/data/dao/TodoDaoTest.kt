package ro.alexmamo.roomjetpackcompose.data.dao

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ro.alexmamo.roomjetpackcompose.data.network.TodoDb
import ro.alexmamo.roomjetpackcompose.utils.getTodoTest
import ro.alexmamo.roomjetpackcompose.utils.getUpdatedTodoTest
import java.io.IOException
import javax.inject.Inject

@HiltAndroidTest
class TodoDaoTest() {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var todoDao: TodoDao
    @Inject
    lateinit var todoDb: TodoDb

    val context = ApplicationProvider.getApplicationContext<Context>()
    private val todoTest = getTodoTest(context)
    private val updatedTodoTest = getUpdatedTodoTest(context)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    @Throws(Exception::class)
    fun testInsertAndGetTodoById() = runTest {
        todoDao.insertTodo(todoTest)
        val todo = todoDao.getTodoById(todoTest.id)
        Truth.assertThat(todo).isEqualTo(todoTest)
    }

    @Test
    @Throws(Exception::class)
    fun testInsertAndCheckIfTodoExistsInTodoList() = runTest {
        todoDao.insertTodo(todoTest)
        val todoList = todoDao.getTodoList().first()
        Truth.assertThat(todoTest).isIn(todoList)
    }

    @Test
    @Throws(Exception::class)
    fun testInsertAndCheckTheSizeOfTodoList() = runTest {
        todoDao.insertTodo(todoTest)
        val todoList = todoDao.getTodoList().first()
        Truth.assertThat(todoList.size).isEqualTo(1)
    }

    @Test
    @Throws(Exception::class)
    fun testUpdateAndGetTodoById() = runTest {
        todoDao.insertTodo(todoTest)
        todoDao.updateTodo(updatedTodoTest)
        val todo = todoDao.getTodoById(todoTest.id)
        Truth.assertThat(todo.title).isEqualTo(updatedTodoTest.title)
    }

    @Test
    @Throws(Exception::class)
    fun testInsertAndDeleteAndCheckTheSizeOfTodoList() = runTest {
        todoDao.insertTodo(todoTest)
        todoDao.deleteTodo(todoTest)
        val todoList = todoDao.getTodoList().first()
        Truth.assertThat(todoList).isEmpty()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        todoDb.close()
    }
}