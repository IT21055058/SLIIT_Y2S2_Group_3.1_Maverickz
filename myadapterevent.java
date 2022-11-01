package com.maverickz.mad_project_hope;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.ArrayList;
//
//public class myadapter extends FirebaseRecyclerAdapter<myadapter.MyViewHolder>{
//
//    public myadapter(Context context, ArrayList<Event> list) {
//
//        this.context = context;
//        this.list = list;
//    }
//    Context context;
//    ArrayList<Event> list;
//
//
//    @Override
//    protected void onBindViewHolder(@NonNull final MyViewHolder holder, final int position, @NonNull final Event model) {
//        holder.name.setText(model.getName());
//        holder.date.setText(model.getEventDate());
//        holder.location.setText(model.getEventLocCity());
////
////        holder.update.setOnClickListener((view) -> {
////
////
////        });
////
////        holder.delete.setOnClickListener((view) -> {
////
////
////        });
//
//    }
//
////    @Override
////    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull Event model) {
////        holder.name.setText(model.getName());
////        holder.date.setText(model.getEventDate());
////        holder.location.setText(model.getEventLocCity());
////
////          holder.update.setOnClickListener((view) -> {
////
////
////          });
////
////        holder.delete.setOnClickListener((view) -> {
////
////
////        });
////
////
////
////    }
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//        View v = LayoutInflater.from(context).inflate(R.layout.singleevent,parent,false);
//        return new MyViewHolder(v);
//    }
//
//
//
////
////    public static class myviewholder extends RecyclerView.ViewHolder{
////
////        TextView name, date, location;
////        Button delete, update;
////        public myviewholder(@NonNull View itemview){
////            super(itemview);
//
////            name = (TextView)itemview.findViewById(R.id.sreventName);
////            date = (TextView)itemview.findViewById(R.id.sreventdate);
////            location = (TextView)itemview.findViewById(R.id.sreventloc);
////
////            delete = (Button)itemview.findViewById(R.id.eventDel);
////            update = (Button)itemview.findViewById(R.id.eventUpdate);
////
////        }
////
////    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder{
//
//        TextView name, date, location;
//        Button delete, update;
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            name = (TextView)itemView.findViewById(R.id.sreventName);
//            date = (TextView)itemView.findViewById(R.id.sreventdate);
//            location = (TextView)itemView.findViewById(R.id.sreventloc);
//
//            delete = (Button)itemView.findViewById(R.id.eventDel);
//            update = (Button)itemView.findViewById(R.id.eventUpdate);
//        }
//    }
//
//
//
//
//    }


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class myadapterevent extends RecyclerView.Adapter<myadapterevent.MyViewHolder> {

//    SharedPreferences sharedPreferences;
//
//    private static final String SHARED_PREF_NAME = "mypref";
//    private static final String KEY_NAME = "name";
//
//
//
//
//    ArrayList<Event> list2;




    public myadapterevent(Context context, ArrayList<Event> list) {
        this.context = context;


//        for (int counter = 0; counter < list.size(); counter++) {
//
//        }



        this.list = list;



    }

    Context context;
    ArrayList<Event> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singleevent,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Event event = list.get(position);

        holder.location.setText(event.getEventLocCity());
        holder.name.setText(event.getName());
        holder.date.setText(event.getEventDate());



        //Edit Option-----------------------------------------------------------------------------------------------------------Start--------------------
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.update.getContext()).setContentHolder(new ViewHolder(R.layout.eventupdate))
                        .setExpanded(true, 1500).create();

                View myview = dialogPlus.getHolderView();
                EditText Updatevent_name = myview.findViewById(R.id.Updatevent_name);
                EditText Updateevent_date = myview.findViewById(R.id.Updateevent_date);
                EditText Updatelocation_street = myview.findViewById(R.id.Updatelocation_street);
                EditText Updatestart_time = myview.findViewById(R.id.Updatestart_time);
                EditText Updateevent_description = myview.findViewById(R.id.Updateevent_description);
                EditText Updatecont_info = myview.findViewById(R.id.Updatecont_info);
                Button Update_btn = myview.findViewById(R.id.Update_btn);

                Updatevent_name.setText(event.getName());
                Updateevent_date.setText(event.getEventDate());
                Updatelocation_street.setText(event.getEventLocStreet());
                Updatestart_time.setText(event.getEventStart());
                Updateevent_description.setText(event.getEventDesc());
                Updatecont_info.setText(event.getEventCont());

                dialogPlus.show();


                Update_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("eventDate",Updateevent_date.getText().toString());
                        map.put("name",Updatevent_name.getText().toString());
                        map.put("eventLocStreet",Updatelocation_street.getText().toString());
                        map.put("eventStart",Updatestart_time.getText().toString());
                        map.put("eventDesc",Updateevent_description.getText().toString());
                        map.put("eventCont",Updatecont_info.getText().toString());


//                        Firebase product_key = getItem(position);

                        FirebaseDatabase.getInstance().getReference().child("Event")
                                .child(event.getID())
                                .updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();

                                    }
                                });
                    }
                });

            }
        });

//Edit Option---------------------------------------------------------------------------------------------------------End------------------------

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.delete.getContext());
                builder.setTitle("Are you Sure ?");
                builder.setMessage("Do you really want to delete this Event ? This process cannot be undone...");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        FirebaseDatabase.getInstance().getReference().child("Event").child(event.getID()).removeValue();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


    }





    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView name, date, location;
        Button delete, update;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.sreventName);
            date = (TextView)itemView.findViewById(R.id.sreventdate);
            location = (TextView)itemView.findViewById(R.id.sreventloc);
            delete = (Button)itemView.findViewById(R.id.eventDel);
            update = (Button)itemView.findViewById(R.id.eventUpdate);



        }
    }
}


