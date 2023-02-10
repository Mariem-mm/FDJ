package com.fdj.test.dagger

import com.fdj.test.teams.TeamsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (PresenterModule::class)])
// The component is used to connect objects to their dependencies, typically by use of overridden inject() methods
// Here, you’ve told Dagger that AppComponent is a singleton component interface for the app.
interface AppComponent {
    fun inject(target: TeamsFragment)

}