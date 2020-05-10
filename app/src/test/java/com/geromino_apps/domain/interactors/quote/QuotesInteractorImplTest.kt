package com.geromino_apps.domain.interactors.quote

import com.geromino_apps.data.gateway.quotes.QueryGateWay
import com.geromino_apps.domain.entities.QuoteEntity

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*


@RunWith(MockitoJUnitRunner::class)
class QuotesInteractorImplTest {

    lateinit var SUT: QuotesInteractorImpl

    @Mock lateinit var mGateWay : QueryGateWay


    @Before
    fun setup() {
        SUT = QuotesInteractorImpl(mGateWay)
    }

    @Test
    fun storeQuotes() {
        //Act
        val quotes = ArrayList<QuoteEntity>()
        quotes.add(QuoteEntity())
        SUT.storeQuotes(quotes)
        //Assert
        verify(mGateWay, times(1)).store(anyObject())
    }

    @Test
    fun getQuotes() {
        //Act
        SUT.getQuotes(System.currentTimeMillis())
        //Assert
        verify(mGateWay, times(1)).query(ArgumentMatchers.anyLong())
    }


    private fun <T> anyObject(): T {
        Mockito.anyObject<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
}