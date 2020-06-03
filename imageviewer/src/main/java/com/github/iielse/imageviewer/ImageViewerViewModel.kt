package com.github.iielse.imageviewer

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.github.iielse.imageviewer.adapter.Repository
import com.github.iielse.imageviewer.core.Photo

class ImageViewerViewModel : ViewModel() {
    private val repository = Repository()
    val dataList = repository.dataSourceFactory().toLiveData(PagedList.Config.Builder().setPageSize(1).build())

    @Suppress("UNCHECKED_CAST")
    fun remove(item: Any?) {
        (item as? List<Photo>?)?.let { repository.removeAll(it) }
    }
}