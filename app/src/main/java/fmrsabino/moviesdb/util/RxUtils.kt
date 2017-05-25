package fmrsabino.moviesdb.util

import hu.akarnokd.rxjava.interop.RxJavaInterop
import rx.Observable

inline fun <T> Observable<T>.toRx2(): io.reactivex.Observable<T> = RxJavaInterop.toV2Observable(this)