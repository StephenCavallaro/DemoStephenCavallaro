package stephencavallaro.demostephencavallaro.Adapter;

/**
 * Created by Stephen on 1/26/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import stephencavallaro.demostephencavallaro.R;

public class ListViewAdapter extends BaseAdapter {


    private Context mContext;
    private final LayoutInflater mInflater;


    public ListViewAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();
            holder.textView1 = (TextView)convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView)convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView)convertView.findViewById(R.id.list_view_tv3);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.textView1.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));
        if (position%2==0){
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);

        }else{
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);

        }


        //View rowView = mInflater.inflate(R.layout.list_item, parent, false);
        //TextView textView = (TextView) rowView.findViewById(R.id.list_view_tv1);
        //textView.setText(String.valueOf(position));
       //return rowView;
   return convertView;
    }


}

class ViewHolder {
        TextView textView1;
    TextView textView2;
    TextView textView3;

}