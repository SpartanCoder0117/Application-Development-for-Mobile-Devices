package dyhm.proyecto1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


public abstract class ListaAdapter extends BaseAdapter {
    private List arrayList;
    private int R_layout_idView;
    private Context c;
    private static final String TAG = ListaAdapter.class.getName();

    public ListaAdapter(Context c, int R_layout_idView, List arrayList) {
        super();
        this.c = c;
        this.arrayList = arrayList;
        this.R_layout_idView = R_layout_idView;
        Log.d(TAG, "ListaAdapter constructor");
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R_layout_idView, null);
        }
        onEntrada(arrayList.get(position), convertView);
        return convertView;
    }

    abstract void onEntrada(Object o, View v);
}

