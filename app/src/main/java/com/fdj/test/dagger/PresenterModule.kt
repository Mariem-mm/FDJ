package com.fdj.test.dagger

import com.fdj.test.teams.TeamsPresenter
import com.fdj.test.teams.TeamsPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    @Inject
    fun providePlayersPresenter(): TeamsPresenter = TeamsPresenterImpl()

}