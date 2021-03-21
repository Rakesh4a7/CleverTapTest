package com.rakesh.clevertaptest

import com.rakesh.clevertaptest.adapter.DataAdapter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class DataAdapterTest {

    private var dataAdapter: DataAdapter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun addGridItemsToViewNotifiesParentAndAddsItemToTileList() {
        dataAdapter = spy(DataAdapter{ })
        doNothing().`when`(dataAdapter)?.internalNotifyDataSetChanged()
        dataAdapter?.updateData(ArrayList())
        verify(dataAdapter)?.internalNotifyDataSetChanged()
    }
}