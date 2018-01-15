package mobileappscompany.dickssportinggood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fallaye on 1/15/18.
 */

public class SportingGoodAdapter extends RecyclerView.Adapter<SportingGoodAdapter.SportingGoodViewHolder> {
    Context context;
    List<SportingGood> sportingGoodList;

    public SportingGoodAdapter(Context context, List<SportingGood> list) {
        this.context = context;
        this.sportingGoodList = list;
    }

    @Override
    public SportingGoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sporting_good_container, null);

        return new SportingGoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SportingGoodViewHolder holder, int position) {
        SportingGood sg = sportingGoodList.get(position);
        holder.tvId.setText(sg.getId());
        holder.tvName.setText(sg.getName());
        holder.tvUrl.setText(sg.getUrl());
    }

    @Override
    public int getItemCount() {
        return sportingGoodList.size();
    }

    public class SportingGoodViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvUrl;

        public SportingGoodViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvUrl = itemView.findViewById(R.id.tvUrl);
        }
    }
}
