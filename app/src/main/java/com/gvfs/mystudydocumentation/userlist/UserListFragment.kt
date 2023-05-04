package com.gvfs.mystudydocumentation.userlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gvfs.mystudydocumentation.dao.UserDao
import com.gvfs.mystudydocumentation.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

    private val viewModel: UserListViewModel by viewModels()
    private val dao = UserDao();
    private val adapter = UserListAdapter(dao.findAll())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserListBinding.inflate(inflater, container, false)
            .apply {
            setupRecycleView(usersListRecycleview)
            }
        return binding.root
    }

    private fun setupRecycleView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
    }


}