package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import ro.alexmamo.roomjetpackcompose.data.network.TodoDb
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListViewModel
import ro.alexmamo.roomjetpackcompose.data.repository.FakeTodoRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
class AppModuleTest {
    @Provides
    fun provideTodoDb() = Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext<Context>(),
        TodoDb::class.java
    ).build()

    @Provides
    fun provideTodoDao(
        todoDb: TodoDb
    ) = todoDb.todoDao

    @Provides
    fun provideTodoRepository(): TodoRepository = FakeTodoRepositoryImpl()

    @Provides
    fun provideTodoListViewModel(
        repo: TodoRepository
    ) = TodoListViewModel(repo)
}