package com.josemarrima.githubsampleapp.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@RunWith(JUnit4::class)
class RepoServiceTest {

    //@Rule
    //@JvmField
    //val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var repoService: RepoService

    private lateinit var mockServer: MockWebServer


    @Before
    fun setUp() {
        mockServer = MockWebServer()
        repoService = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(RepoService::class.java)
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun getListRepo_Success_Response() = runBlocking {


    }
}