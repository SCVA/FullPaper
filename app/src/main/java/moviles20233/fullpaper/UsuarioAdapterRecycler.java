package moviles20233.fullpaper;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import moviles20233.fullpaper.data.Usuario;

public class UsuarioAdapterRecycler extends RecyclerView.Adapter<UsuarioAdapterRecycler.ViewHolder>{

    private Cursor cursorListaUsuarios;
    private OnItemClickListener listenerClick;

    public  UsuarioAdapterRecycler(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, Usuario usuarioactualizado);
    }

    @NonNull
    @Override
    public UsuarioAdapterRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_user_item,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapterRecycler.ViewHolder holder, int position) {
        cursorListaUsuarios.moveToPosition(position);
        Usuario usuarioSeleccionado = new Usuario( cursorListaUsuarios );
        holder.idUsuario.setText( String.valueOf(usuarioSeleccionado.getId()) );
        holder.nombreUsuario.setText( usuarioSeleccionado.getNombre() );
        holder.passwordUsuario.setText( String.valueOf( usuarioSeleccionado.getPassword() ) );
    }

    @Override
    public int getItemCount() {
        if (cursorListaUsuarios!=null)
            return cursorListaUsuarios.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaUsuarios = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView idUsuario;
        TextView nombreUsuario;
        TextView passwordUsuario;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            idUsuario = (TextView) itemView.findViewById( R.id.itemUserID );
            nombreUsuario = (TextView) itemView.findViewById( R.id.itemUserName );
            passwordUsuario = (TextView) itemView.findViewById( R.id.itemUserPassword );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View view) {
            Usuario usuarioClickeado = obtenerUsuario( getAdapterPosition());
            usuarioClickeado.setNombre( "El pepe 2" );
            listenerClick.onClick( this,usuarioClickeado );
        }
    }

    private Usuario obtenerUsuario(int posicion){
        if (cursorListaUsuarios!=null){
            cursorListaUsuarios.moveToPosition( posicion );
            Usuario nuevoUsuario = new Usuario( cursorListaUsuarios );
            return nuevoUsuario;
        }
        return null;
    }

}
