package org.test.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    var _showLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isShowLoading: LiveData<Boolean>
        get() {
            return _showLoading
        }

    var _errorMessage: MutableLiveData<String> = MutableLiveData()
    val getErrorMessage: LiveData<String>
        get() {
            return _errorMessage
        }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        clearDisposables()
    }

}
