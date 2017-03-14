package diogojayme.br.com.vuziq.mvparchitecture.presenter;

/**
 * Created by diogojayme on 3/11/17.
 */

public class RetrofitError {
    private Kind kind;
    private int code;
    private String message;

    public RetrofitError(Kind kind, int code, String message) {
        this.kind = kind;
        this.code = code;
        this.message = message;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
