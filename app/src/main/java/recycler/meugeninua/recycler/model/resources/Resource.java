package recycler.meugeninua.recycler.model.resources;

import android.support.annotation.IntDef;

/**
 * @author meugen
 */
public class Resource<T> {

    @IntDef({LOADING,SUCCESS,ERROR})
    public @interface Status {}
    public static final int LOADING = 1;
    public static final int SUCCESS = 2;
    public static final int ERROR = 3;

    public static <T> Resource<T> loading(final T result) {
        return new Resource<>(LOADING, result, null);
    }

    public static <T> Resource<T> success(final T result) {
        return new Resource<>(SUCCESS, result, null);
    }

    public static <T> Resource<T> error(final Throwable t) {
        return new Resource<>(ERROR, null, t);
    }

    @Status
    public final int status;
    public final T result;
    public final Throwable error;

    private Resource(
            final int status,
            final T result,
            final Throwable error) {
        this.status = status;
        this.result = result;
        this.error = error;
    }
}
