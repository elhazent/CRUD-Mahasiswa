package fiqri.com.mahasiswa.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fiqri.com.mahasiswa.R;
import fiqri.com.mahasiswa.model.DatanyaItem;
import fiqri.com.mahasiswa.ui.UpdateDelete;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<DatanyaItem> data;

    public MyAdapter(List<DatanyaItem> data) {
        this.data = data;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_mahasiswa, parent, false);

        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, final int position) {

        holder.tvNim.setText(data.get(position).getNim());
        holder.tvNama.setText(data.get(position).getName());
        holder.tvJurusan.setText(data.get(position).getJurusan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(holder.itemView.getContext(),
                        UpdateDelete.class);
                i.putExtra("id", data.get(position).getId());
                i.putExtra("nim", data.get(position).getNim());
                i.putExtra("nama", data.get(position).getName());
                i.putExtra("jurusan", data.get(position).getJurusan());
                holder.itemView.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNim, tvNama, tvJurusan;

        public MyViewHolder(View v) {
            super(v);

            tvNim = v.findViewById(R.id.txt_nim);
            tvNama = v.findViewById(R.id.txt_nama);
            tvJurusan = v.findViewById(R.id.txt_jurusan);

        }
    }
}
