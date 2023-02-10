package com.fdj.test.teams

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fdj.test.R
import com.fdj.test.teams.adapter.TeamsAdapter
import com.fdj.test.teams.model.Team
import kotlinx.android.synthetic.main.fragment_players.*

class TeamsFragment: Fragment(), TeamsView{

    private lateinit var playersPresenter: TeamsPresenter

    private var players: List<Team>? = emptyList()

    private lateinit var playersAdapter: TeamsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playersPresenter = TeamsPresenterImpl()

        playersPresenter.setView(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(context, 2)

        playersAdapter = TeamsAdapter(players) {
            // TODO implement listener
        }

        recyclerView.apply {
            adapter = playersAdapter
        }

        searchView.addTextChangedListener(textWatcher)

    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            playersPresenter.getTeams(charSequence)
        }

        override fun afterTextChanged(editable: Editable) {}

    }

    override fun onGetTeamsSuccess(items: List<Team>?) {
        players = items
        playersAdapter.setData(players)
    }

    companion object {
        fun newInstance(): TeamsFragment {
            return TeamsFragment()
        }
    }
}