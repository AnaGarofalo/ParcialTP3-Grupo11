package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.data.dao.TodoDao
import ro.alexmamo.roomjetpackcompose.data.network.TodoDb
import ro.alexmamo.roomjetpackcompose.data.repository.TodoRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideTodoDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        TodoDb::class.java,
        context.resources.getString(R.string.db_name)
    ).fallbackToDestructiveMigration().build()


    @Provides
    fun provideTodoDao(
        todoDb: TodoDb
    ) = todoDb.todoDao

    @Provides
    fun provideTodoRepository(
        todoDao: TodoDao
    ): TodoRepository = TodoRepositoryImpl(
        todoDao = todoDao
    )
}