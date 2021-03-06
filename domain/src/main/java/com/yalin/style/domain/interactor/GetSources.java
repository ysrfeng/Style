package com.yalin.style.domain.interactor;

import com.yalin.style.domain.Source;
import com.yalin.style.domain.executor.PostExecutionThread;
import com.yalin.style.domain.executor.ThreadExecutor;
import com.yalin.style.domain.repository.SourcesRepository;
import com.yalin.style.domain.repository.WallpaperRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author jinyalin
 * @since 2017/5/22.
 */

public class GetSources extends UseCase<List<Source>, Void> {
    private SourcesRepository sourcesRepository;

    @Inject
    public GetSources(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread,
                      SourcesRepository sourcesRepository) {
        super(threadExecutor, postExecutionThread);
        this.sourcesRepository = sourcesRepository;
    }

    @Override
    Observable<List<Source>> buildUseCaseObservable(Void a) {
        return sourcesRepository.getSources();
    }
}
