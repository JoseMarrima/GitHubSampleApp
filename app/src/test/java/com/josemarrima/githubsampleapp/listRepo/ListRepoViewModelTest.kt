package com.josemarrima.githubsampleapp.listRepo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.josemarrima.githubsampleapp.data.Repository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ListRepoViewModelTest {
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: Repository

    lateinit var listRepoViewModel: ListRepoViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        listRepoViewModel = ListRepoViewModel(repository)
    }

    @Test
    fun getListRepo_Success_Response() {

    }
}