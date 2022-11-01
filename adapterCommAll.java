package com.maverickz.mad_project_hope;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class adapterCommAll extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    public adapterCommAll(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<Post> list;
    int pos;

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comm_all_single,parent,false);
        return new MyAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        this.pos = position;
        Post post = list.get(position);
        holder.heading.setText(post.getHeading());
        // holder.imageUri.setText(post.getImageUri());
        holder.description.setText(post.getDescription());

//        Glide.with(context).load(image)


        Picasso.get().load(post.getImageUri()).into(holder.img);
//        holder.img.setImageURI(Uri.parse(post.getImageUri()));
//Edit Option-----------------------------------------------------------------------------------------------------------Start--------------------

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView heading, description,imageUri;
        ImageView img;
//        FloatingActionButton editfloatingActionBut;
//        FloatingActionButton deletefloatingActionBut;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.itempostcardHeading);
            description = itemView.findViewById(R.id.itempostcardDescription);
            img = itemView.findViewById(R.id.itempostimage);

            //ImageView img = (ImageView) imageUri.findViewById(R.id.itempostimage);
            //img = itemView.find

//            editfloatingActionBut = itemView.findViewById(R.id.editfloatingActionBut);
//            deletefloatingActionBut = itemView.findViewById(R.id.deletefloatingActionBut);
        }
    }
}

