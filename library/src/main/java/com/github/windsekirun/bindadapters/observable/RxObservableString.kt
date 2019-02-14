@file:JvmName("RxObservableString")

package com.github.windsekirun.bindadapters.observable


import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

class RxObservableString(private val observableString: ObservableString) : Observable<String>() {

    override fun subscribeActual(observer: Observer<in String>) {
        val listener = Listener(observableString, observer)
        observer.onSubscribe(listener)
        observableString.addOnPropertyChangedCallback(listener.onPropertyChangedCallback)
    }

    private inner class Listener internal constructor(
            private val observableString: ObservableString,
            observer: Observer<in String>
    ) : MainThreadDisposable() {
        internal val onPropertyChangedCallback: androidx.databinding.Observable.OnPropertyChangedCallback

        init {
            this.onPropertyChangedCallback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(
                        observable: androidx.databinding.Observable,
                        ignoredPropertyId: Int
                ) {
                    if (!isDisposed) {
                        val string = observable as ObservableString
                        observer.onNext(string.get() ?: "")
                    }
                }
            }
        }

        override fun onDispose() {
            observableString.removeOnPropertyChangedCallback(onPropertyChangedCallback)
        }
    }
}

fun ObservableString.propertyChanges() = RxObservableString(this)