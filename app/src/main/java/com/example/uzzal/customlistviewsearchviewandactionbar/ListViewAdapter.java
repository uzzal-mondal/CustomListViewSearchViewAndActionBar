package com.example.uzzal.customlistviewsearchviewandactionbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

   //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;


    //constructer


    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);

    }

     public class ViewHolder{

        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }




    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null){

            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row,null);

            //locate the view in raw.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);
            view.setTag(holder);
        }else {

            holder = (ViewHolder)view.getTag();
        }

           //*** set the result in the text view
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());

           //*** set the result in a image view ...
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

           // *** listview.itemClick; mone rakhte hobe ajibon.....

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code later

                if(modellist.get(postition).getTitle().equals("Kotlin")){

                      // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","Kotlin");
                    intent.putExtra("contentPr","This is Kotlin");
                    mContext.startActivity(intent);

                }




                if(modellist.get(postition).getTitle().equals("Java Script")){

                    // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","Java Script");
                    intent.putExtra("contentPr","This is Java Script");
                    mContext.startActivity(intent);

                }





                if(modellist.get(postition).getTitle().equals("Python")){

                    // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","Python");
                    intent.putExtra("contentPr","This is Python");
                    mContext.startActivity(intent);

                }




                if(modellist.get(postition).getTitle().equals("Java")){

                    // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","Java");
                    intent.putExtra("contentPr","This is Java");
                    mContext.startActivity(intent);

                }




                if(modellist.get(postition).getTitle().equals("C++")){

                    // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","C++");
                    intent.putExtra("contentPr","This is C++");
                    mContext.startActivity(intent);

                }



                if(modellist.get(postition).getTitle().equals("C")){

                    // start new activity with title for action bar;
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle","C");
                    intent.putExtra("contentPr","This is C");
                    mContext.startActivity(intent);

                }

            }
        });


        return view;
    }

    //filter.....
    public void filter(String charText){

        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();

        if(charText.length()==0){

            modellist.addAll(arrayList);
        }else {

            for(Model model: arrayList){

                if(model.getTitle().toLowerCase(Locale.getDefault())
                    .contains(charText)){
                    modellist.add(model);
                }
            }
        }
         notifyDataSetChanged();
    }

}
