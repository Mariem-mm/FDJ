package com.fdj.test.teams

import com.fdj.test.teams.model.Team

interface TeamsView {
    fun onGetTeamsSuccess(items: List<Team>?)
}