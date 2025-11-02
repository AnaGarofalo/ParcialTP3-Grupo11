package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.data.dao.UserDao
import ro.alexmamo.roomjetpackcompose.data.network.UserDb
import ro.alexmamo.roomjetpackcompose.data.repository.UserRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideUserDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        UserDb::class.java,
        context.resources.getString(R.string.db_name)
    ).fallbackToDestructiveMigration().build()


    @Provides
    fun provideUserDao(
        userDb: UserDb
    ) = userDb.userDao

    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository = UserRepositoryImpl(
        userDao = userDao
    )
}