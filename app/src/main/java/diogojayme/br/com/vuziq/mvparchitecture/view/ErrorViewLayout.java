package diogojayme.br.com.vuziq.mvparchitecture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import diogojayme.br.com.vuziq.mvparchitecture.R;

/**
 * Created by diogojayme on 3/13/17.
 */

public class ErrorViewLayout extends FrameLayout {

    private OnRetryClickListener listener;

    @BindView(R.id.error_view_retry)  Button retryButton;
    @BindView(R.id.error_view_message) TextView errorMessage;

    private void init(Context context){
        View view = inflate(context, R.layout.error_view, this);
        ButterKnife.bind(this, view);
        //aways hidden
        hasError(false);
    }

    @OnClick(R.id.error_view_retry) public void onRetryClick(){
        if(listener == null){
            throw new NullPointerException("Invalid listener: Listener == null");
        }

        listener.onRetryClick();
    }

    public void setOnRetryClickListener(OnRetryClickListener listener){
        this.listener = listener;
    }

    public void setErrorViewMessage(String message){
        if(message == null)
            throw new NullPointerException("Invalid message");

        errorMessage.setText(message);
    }

    /**
     * Set true if an error happened so we can show the retry button
     * set to false in listener callback
     *
     * @param hasError
     */
    public void hasError(boolean hasError){
        setVisibility(hasError ? View.VISIBLE : View.GONE);
    }

    /**
     * Add this listener to catch when user click in retry
     *
     */
    public interface OnRetryClickListener{
        void onRetryClick();
    }

    public ErrorViewLayout(Context context) {
        super(context);
        init(context);
    }

    public ErrorViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ErrorViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

}
