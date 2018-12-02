package developersancho.mvvm_s.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import developersancho.mvvm_s.R;
import developersancho.mvvm_s.data.remote.api.model.ParkResponse;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    List<ParkResponse> parks = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ParkResponse park = parks.get(position);
        holder.textName.setText(park.getName());
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView textName;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(parks.get(position));
                }
            });
        }
    }

    public ParkResponse getPark(int position) {
        return parks.get(position);
    }

    public void setParks(List<ParkResponse> parks) {
        this.parks = parks;
        notifyDataSetChanged();
    }

    // MainActivity classında kullanacaksın...
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(ParkResponse parkResponse);
    }
}

