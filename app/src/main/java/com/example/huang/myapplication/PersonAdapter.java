package com.example.huang.myapplication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by huang on 16-7-7.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>  {
    private List<Person> list;
    private static final String TAG = PersonAdapter.class.getSimpleName();

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public PersonAdapter(List<Person> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_test_item_person, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        Person person = list.get(position);
        holder.name.setText(person.getName());
        holder.age.setText(person.getAge());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    Log.v(TAG,pos+"click");
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });

        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public int getItemViewType(int position) {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView name;
        public TextView age;

        public MyViewHolder(View view)
        {
            super(view);
            name = (TextView) view.findViewById(R.id.recycler_view_test_item_person_name_tv);
            age = (TextView) view.findViewById(R.id.recycler_view_test_item_person_age_tv);
        }
    }
}
