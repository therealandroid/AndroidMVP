package diogojayme.br.com.vuziq.mvparchitecture.presenter;

/** Identifies the event kind which triggered a {@link RetrofitException}. */
public enum Kind {
    /** An {@link IOException} occurred while communicating to the server. */
    NETWORK,
    /** A non-200 HTTP status code was received from the server. */
    HTTP,
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    UNEXPECTED
}