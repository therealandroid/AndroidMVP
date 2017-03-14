package diogojayme.br.com.vuziq.mvparchitecture.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import diogojayme.br.com.vuziq.mvparchitecture.R;

/**
 * Created by diogojayme on 3/13/17.
 */

public class FragmentImages extends Fragment implements ImagesView{

    @BindView(R.id.images_error_view) ErrorViewLayout errorViewLayout;
    @BindView(R.id.fragment_images_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.image_progress) ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        ButterKnife.bind(this, view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    @Override
    public void onLoadImagesSuccess(List<String> images) {
        ImagesAdapter adapter = new ImagesAdapter(images);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadImagesFailed(String message) {
        errorViewLayout.hasError(true);
        errorViewLayout.setErrorViewMessage(message);
        errorViewLayout.setOnRetryClickListener(    new ErrorViewLayout.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //load it again

                errorViewLayout.hasError(false);
            }
        });
    }

    @Override
    public void showImagesLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImagesLoading() {
        progressBar.setVisibility(View.GONE);
    }


    ////ADAPTER////

    public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>{

        List<String> images;

        public ImagesAdapter(List<String> images){
            this.images = images;
        }

        @Override
        public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false));
        }

        @Override
        public void onBindViewHolder(ImagesViewHolder holder, int position) {
            Picasso.with(holder.itemView.getContext()).load(images.get(position)).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ImagesViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.image_view) ImageView imageView;
            public ImagesViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
