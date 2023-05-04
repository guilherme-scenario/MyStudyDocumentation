package com.gvfs.mystudydocumentation.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.gvfs.mystudydocumentation.dao.UserDao
import com.gvfs.mystudydocumentation.domain.User

class UserListViewModel : ViewModel() {

    private val dao = UserDao()
    private val dataSource = dao.findAll()
}