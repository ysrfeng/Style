package com.yalin.style.data.lock;

import com.yalin.style.domain.executor.ThreadExecutor;
import com.yalin.style.domain.interactor.DefaultObserver;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * YaLin
 * On 2017/4/30.
 */
@Singleton
public class OpenInputStreamLock extends ResourceLock {

    @Inject
    public OpenInputStreamLock(ThreadExecutor threadExecutor) {
        super(threadExecutor);
    }

    @Override
    protected Observable<Void> appendDelay(Observable<Void> observable) {
        return observable.delaySubscription(1, TimeUnit.SECONDS);
    }
}
