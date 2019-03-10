package com.rgu.memorygame.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.rgu.memorygame.R;
import com.rgu.memorygame.animationutils.AnimationFactory;
import com.rgu.memorygame.data.DrawbleMapping;
import com.rgu.memorygame.databinding.ItemImageLayoutBinding;

import java.util.Arrays;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<
        ImagesAdapter.ImageViewHolder> {

    private List<Integer> mImageItems;

    private ImageViewHolder firstSelectionView;
    private boolean shouldClickIntercept;

    public ImagesAdapter(Context context, Integer[] randomList) {
        mImageItems = Arrays.asList(randomList);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemImageLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_image_layout, parent, false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.updateView(position);
    }

    @Override
    public int getItemCount() {
        return mImageItems.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ItemImageLayoutBinding itemImageLayoutBinding;
        int position;

        public ImageViewHolder(ItemImageLayoutBinding itemImageLayoutBinding) {
            super(itemImageLayoutBinding.getRoot());
            this.itemImageLayoutBinding = itemImageLayoutBinding;
        }

        void updateView(int position) {
            this.position = position;
            flipToFlipperMode(itemImageLayoutBinding.viewFliper);

            itemImageLayoutBinding.viewFliper.setOnClickListener(v -> {
                if (shouldClickIntercept) {
                    return;
                }

                flipToNormalMode(itemImageLayoutBinding.viewFliper);

                if (firstSelectionView == null) {
                    firstSelectionView = ImageViewHolder.this;
                } else if (mImageItems.get(firstSelectionView.position).equals(mImageItems.get(position))) {
                    shouldClickIntercept = true;
                    hideImages(itemView, firstSelectionView.itemView);
                } else {
                    shouldClickIntercept = true;
                    flipToFlipperMode(firstSelectionView.itemImageLayoutBinding.viewFliper, itemImageLayoutBinding.viewFliper);
                }
            });
        }

        void setImage(int position) {
            itemImageLayoutBinding.scrambleIv.setImageResource(DrawbleMapping.iconMap.get(mImageItems.get(position)));
        }

        private void hideImages(View view1, View view2) {
            new Handler().postDelayed(() -> {
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);
                firstSelectionView = null;
                shouldClickIntercept = false;
            }, 1000);
        }

        private void flipToFlipperMode(ViewFlipper viewFliper1, ViewFlipper viewFliper2) {
            new Handler().postDelayed(() -> {
                flipToFlipperMode(viewFliper1);
                flipToFlipperMode(viewFliper2);
                firstSelectionView = null;
                shouldClickIntercept = false;
            }, 1000);
        }

        private void flipToFlipperMode(ViewFlipper flipper) {
            AnimationFactory.flipTransition(flipper, AnimationFactory.FlipDirection.LEFT_RIGHT);
        }

        private void flipToNormalMode(ViewFlipper flipper) {
            setImage(position);
            AnimationFactory.flipTransition(flipper, AnimationFactory.FlipDirection.RIGHT_LEFT);
        }
    }


}
