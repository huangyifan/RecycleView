package com.example.huang.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Person> mDatas = new ArrayList<Person>();
    private PersonAdapter mAdapter;
    public Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_test_rv);


        initData();

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       /* mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.HORIZONTAL));*/
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter = new PersonAdapter(mDatas));

        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(5);
        dividerLine.setColor(Color.RED);
        mRecyclerView.addItemDecoration(dividerLine);

        mAdapter.setOnItemClickLitener(new PersonAdapter.OnItemClickLitener()
        {

            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(RecyclerActivity.this,position + " click",
                        Toast.LENGTH_SHORT).show();
                person = new Person();
                person.setName("huangyi");
                person.setAge("45");
                mAdapter.notifyItemInserted(position);
                mDatas.add(position, person);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(RecyclerActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();

                mAdapter.notifyItemRemoved(position);
                mDatas.remove(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());

            }
        });
    }

    private void initData() {
        for (int i=0;i<20;i++){
            person = new Person();
            person.setName("huang");
            person.setAge("age");
            mDatas.add(person);
        }

    }
}
