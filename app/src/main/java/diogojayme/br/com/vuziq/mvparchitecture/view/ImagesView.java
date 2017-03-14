package diogojayme.br.com.vuziq.mvparchitecture.view;

import java.util.List;

/**
 * Created by diogojayme on 3/9/17.
 */

public interface ImagesView {
    /**
     * pega as imagjen
     *
     * @param images
     */
    void onLoadImagesSuccess(List<String> images);
    void onLoadImagesFailed(String message);
    void showImagesLoading();
    void hideImagesLoading();
}
