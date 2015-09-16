package com.alfchee.recyclerviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by alfchee on 9/15/15.
 * MyRecyclerAdapter
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int position = holder.getLayoutPosition();

            FeedItem feedItem = feedItemList.get(position);
            Toast.makeText(mContext,feedItem.getTitle(),Toast.LENGTH_SHORT).show();
        }
    };

    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row,null);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        // Download image using  picasso library
        Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);

        // setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));

        // handle click event on both, title and Image
        customViewHolder.textView.setOnClickListener(clickListener);
        customViewHolder.imageView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
