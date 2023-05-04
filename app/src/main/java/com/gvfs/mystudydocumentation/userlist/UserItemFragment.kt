package com.gvfs.mystudydocumentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gvfs.mystudydocumentation.dao.UserDao
import com.gvfs.mystudydocumentation.databinding.FragmentUserListBinding
import com.gvfs.mystudydocumentation.databinding.UserItemBinding
import com.gvfs.mystudydocumentation.domain.User
import androidx.viewpager2.widget.ViewPager2

class UserItemFragment : Fragment() {

    private val viewModel: UserListViewModel by viewModels()
    private val dao = UserDao();
    private val adapter = UserListAdapter(dao.findAll())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserListBinding.inflate(inflater, container, false)
            .apply {
            setupRecycleView(viewPager)
            }
        return binding.root
    }

    private fun setupRecycleView(viewPager2: ViewPager2) {
        viewPager2.adapter = adapter
    }


}