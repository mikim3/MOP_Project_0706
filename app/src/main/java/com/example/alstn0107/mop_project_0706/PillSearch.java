package com.example.alstn0107.mop_project_0706;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PillSearch extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;

    private DatabaseReference mUserDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_text);
        Toast.makeText(getApplicationContext(), "nav_pill_search_text클릭후 onCreate실행", Toast.LENGTH_SHORT).show();


        mUserDatabase = FirebaseDatabase.getInstance().getReference("0/Pill");

        mSearchField=(EditText)findViewById(R.id.search_field);
        mSearchBtn= (ImageButton)findViewById(R.id.search_btn);

        mResultList= (RecyclerView)findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchText = mSearchField.getText().toString();  //클릭했을떄 넘겨줄 text를 정한다.

                firebaseInformationSearch(searchText);

            }
        });


    }

    private void firebaseInformationSearch(String searchText) {

        Toast.makeText(PillSearch.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("Itemname").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Information,InformationViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Information, InformationViewHolder>(
                Information.class,
                R.layout.list_layout,
                InformationViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(InformationViewHolder viewHolder, Information model, int position) {
                viewHolder.setDetails(getApplicationContext(),model.getName(),model.getStatus(),model.getImage());
            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter );

    }


    //View Holder Class
    public static class InformationViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public InformationViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDetails(Context ctx,String userName, String userStatus, String userImage){

            TextView item_name = (TextView)mView.findViewById(R.id.item_name);
            TextView company_name = (TextView)mView.findViewById(R.id.company_name);
            ImageView pill_image = (ImageView)mView.findViewById(R.id.pill_image);

            item_name.setText(userName);
            company_name.setText(userStatus);

            Glide.with(ctx).load(userImage).into(pill_image);


        }
    }
}
