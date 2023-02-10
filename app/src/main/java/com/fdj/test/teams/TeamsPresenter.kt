package com.fdj.test.teams

interface TeamsPresenter {
    fun setView(view: TeamsView)
    fun getTeams(query: CharSequence)
}