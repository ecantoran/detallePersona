package registromedico.idit.com.detallepersonas;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import registromedico.idit.com.detallepersonas.dummy.DummyContent;

/**
 * A fragment representing a single Persona detail screen.
 * This fragment is either contained in a {@link PersonaListActivity}
 * in two-pane mode (on tablets) or a {@link PersonaDetailActivity}
 * on handsets.
 */
public class PersonaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PersonaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            //Barra en caso de que la posicion de la tableta sea hotizontal
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.nombre + " " + mItem.apellido );
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.persona_detail, container, false);
        //Modificar para agregar datos al View
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.txtnombre)).setText(mItem.nombre + " " + mItem.apellido);
            ((TextView) rootView.findViewById(R.id.txtsexo)).setText(mItem.sexo);
            ((TextView)rootView.findViewById(R.id.txtnacimiento)).setText(mItem.nacimiento);
            ((TextView)rootView.findViewById(R.id.txtocupacion)).setText(mItem.ocupacion);
            ((TextView)rootView.findViewById(R.id.txtdireccion)).setText(mItem.direccion);
            ((TextView)rootView.findViewById(R.id.txtrfc)).setText(mItem.rfc);
            ((TextView)rootView.findViewById(R.id.txtcurp)).setText(mItem.curp);

        }

        return rootView;
    }
}