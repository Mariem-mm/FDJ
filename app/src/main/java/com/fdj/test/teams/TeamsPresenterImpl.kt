package com.fdj.test.teams

import com.fdj.test.DataHandler

class TeamsPresenterImpl: TeamsPresenter {

    private lateinit var view: TeamsView

    override fun setView(view: TeamsView) {
        this.view = view
    }

    override fun getTeams(query: CharSequence) {
        DataHandler.getTeams(query) { result ->
            view.onGetTeamsSuccess(result)
        }
    }

}