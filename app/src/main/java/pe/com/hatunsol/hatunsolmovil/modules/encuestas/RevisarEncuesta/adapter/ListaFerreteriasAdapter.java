package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.R;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;

public class ListaFerreteriasAdapter extends ArrayAdapter {
    private final String MY_DEBUG_TAG = "MapAdapter";
    private ArrayList<String> items;
    private ArrayList<String> itemsAll;
    private ArrayList<String> suggestions;

    private int viewResourceId;
    private final String key = "description";


    public ListaFerreteriasAdapter(Context context, int resource, int  textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
        viewResourceId = textViewResourceId;
        itemsAll = new ArrayList(objects);
        suggestions = new ArrayList(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        String map =  getItem(position).toString();
        if (map != null) {
            if (v != null) {
                TextView vriPlace = (TextView) v.findViewById(R.id.lbl_name);
                if (vriPlace != null) {
                    vriPlace.setText(map);
                }
            }
        }
        return v;
    }

    /**
     *
     * @return
     */
    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {
        @Override
        public String convertResultToString(Object resultValue) {
            String str = (String) resultValue;
            return str;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.d("VRIPlacesFilter", "Filter " + constraint);
            if (constraint != null) {
                suggestions.clear();
                /*for (map : itemsAll) {
                    if (map.toLowerCase().startsWith(constraint.toString().toLowerCase())) {

                        Log.d("VRIPlacesFilter", "Found " + map.get(key));
                        suggestions.add(map);
                    }
                }*/
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Log.d("VRIPlacesFilter", "Publish " + constraint + " " + results.count);
            if (results != null && results.count > 0) {
                ArrayList<String> filteredList = (ArrayList<String>) results.values;
                clear();
                for (String c : filteredList) {
                    add(c);
                    Log.d("VRIPlacesFilter", "Publish " + c);
                }

//                notifyDataSetChanged();
            }

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                //notifyDataSetInvalidated();
            }
        }
    };
}
