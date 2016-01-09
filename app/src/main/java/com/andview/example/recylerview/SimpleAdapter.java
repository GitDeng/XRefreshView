package com.andview.example.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.example.R;
import com.andview.refreshview.recyclerview.UltimateViewAdapter;

import java.util.List;

public class SimpleAdapter extends
        UltimateViewAdapter<SimpleAdapter.SimpleAdapterViewHolder> {
    private List<Person> list;

    public SimpleAdapter(List<Person> list) {
        this.list = list;
    }

    @Override
    public void onBindView(final SimpleAdapterViewHolder holder,
                           int position) {
        Person person = list.get(position);
        holder.nameTv.setText(String.valueOf(person.getName()));
        holder.ageTv.setText(person.getAge());
    }

    @Override
    public int getAdapterItemCount() {
        return list.size();
    }

    @Override
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recylerview, parent, false);
        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, true);
        return vh;
    }

    public void insert(Person person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder {

        public View rootView;
        public TextView nameTv;
        public TextView ageTv;
        public int position;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                nameTv = (TextView) itemView
                        .findViewById(R.id.recycler_view_test_item_person_name_tv);
                ageTv = (TextView) itemView
                        .findViewById(R.id.recycler_view_test_item_person_age_tv);
                rootView = itemView
                        .findViewById(R.id.recycler_view_test_item_person_view);
            }

        }
    }

    public Person getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}