package com.example.as_c4_sp1_retrofit_task3;

import android.app.Application;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.List;

public class CPhotosAdapter extends RecyclerView.Adapter<CPhotosAdapter.ViewHolder> {
    private List<Photo> mPhotos;
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView solTextView,idTextView;
        public ImageView imageView;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            solTextView = itemView.findViewById(R.id.textView_Sol);
            idTextView = itemView.findViewById(R.id.textView_id);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    public Context context;
    public CPhotosAdapter(List<Photo> photos, Context context)
    {
        this.context = context;
        mPhotos = photos;
    }
    // inflating a layout from XML and returning the holder

    public CPhotosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recyclerview_item_layout, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(CPhotosAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Photo photo = mPhotos.get(position);
        // Set item views based on your views and data model
        TextView textViewName = holder.solTextView;
        textViewName.setText(photo.getSol());
        ImageView viewImage = holder.imageView;
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
