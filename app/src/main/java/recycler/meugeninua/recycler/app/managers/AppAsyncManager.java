package recycler.meugeninua.recycler.app.managers;

import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.di.scopes.PerApplication;

/**
 * @author meugen
 */
@PerApplication
public class AppAsyncManager {

    private final ScheduledExecutorService executor;

    @Inject
    AppAsyncManager() {
        this.executor = Executors.newScheduledThreadPool(2);
    }

    public <T> void execute(
            final Callable<T> callable,
            final ResultListener<T> listener) {
        executor.submit(new ResultRunnable<>(
                callable, listener));
    }

    private static class ResultRunnable<T> implements Runnable {

        private final Callable<T> callable;
        private final ResultListener<T> listener;

        ResultRunnable(
                final Callable<T> callable,
                final ResultListener<T> listener) {
            this.callable = callable;
            this.listener = listener;
        }

        @Override
        public void run() {
            try {
                final T result = callable.call();
                listener.onSuccess(result);
            } catch (Throwable t) {
                listener.onError(t);
            }
        }
    }

    public interface ResultListener<T> {

        void onSuccess(T result);

        void onError(Throwable t);
    }
}
