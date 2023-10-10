package moviles20233.fullpaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import moviles20233.fullpaper.data.Usuario;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    public UsuarioAdapter (Context context, ArrayList<Usuario> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtener inflater.

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_user_item,parent,false);
        }

        TextView iditem = (TextView) convertView.findViewById(R.id.itemUserID);
        TextView nameitem = (TextView) convertView.findViewById(R.id.itemUserName) ;
        TextView passwordItem = (TextView) convertView.findViewById(R.id.itemUserPassword);

        Usuario usuarioActual = getItem(position);

        iditem.setText(String.valueOf(usuarioActual.getId()));
        nameitem.setText(usuarioActual.getNombre());
        passwordItem.setText(String.valueOf(usuarioActual.getPassword()));

        return convertView;
    }
}
