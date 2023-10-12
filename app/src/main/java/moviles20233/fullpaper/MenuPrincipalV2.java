package moviles20233.fullpaper;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moviles20233.fullpaper.data.InventarioDBHelper;
import moviles20233.fullpaper.data.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuPrincipalV2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuPrincipalV2 extends Fragment implements UsuarioAdapterRecycler.OnItemClickListener{

    private RecyclerView listaUsuarios;
    private InventarioDBHelper bdInventario;
    private LinearLayoutManager linearLayoutManager;
    private UsuarioAdapterRecycler adaptadorUsuario;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuPrincipalV2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuPrincipalV2.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuPrincipalV2 newInstance(String param1, String param2) {
        MenuPrincipalV2 fragment = new MenuPrincipalV2();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_menu_principal_v2, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listaUsuarios = (RecyclerView) getView().findViewById( R.id.listaRUsuarios );
        bdInventario = new InventarioDBHelper( getContext() );

        listaUsuarios.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( getContext() );
        listaUsuarios.setLayoutManager( linearLayoutManager );
        adaptadorUsuario = new UsuarioAdapterRecycler( this );
        listaUsuarios.setAdapter( adaptadorUsuario );
        loadPersonas();
    }

    @Override
    public void onClick(UsuarioAdapterRecycler.ViewHolder view, Usuario usuarioActualizado) {
        bdInventario.updateUsuario(usuarioActualizado,String.valueOf(usuarioActualizado.getId()));
        loadPersonas();
    }

    private void loadPersonas() {
        new PersonaLoaderTask().execute( );
    }

    private class PersonaLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return bdInventario.getAllUsuarios();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptadorUsuario.swapCursor( cursor );
            }
        }
    }

}