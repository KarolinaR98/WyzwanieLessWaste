package com.example.wyzwanielesswaste;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsSzczecin extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_szczecin);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Szczecin = new LatLng(53.428543, 14.552812);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Szczecin,10));

        //Restaurants
        LatLng Krowarzywa = new LatLng(53.432041880401975, 14.544385137390035);
        mMap.addMarker(new MarkerOptions().position(Krowarzywa).title("Restauracja Krowarzywa"));

        LatLng Vege_Club_Amar = new LatLng(53.43323707330376, 14.542937545193235);
        mMap.addMarker(new MarkerOptions().position(Vege_Club_Amar).title("Restauracja Vege Club Amar"));

        LatLng Vege_5_Smakow = new LatLng(53.42705158364812, 14.539488123327612);
        mMap.addMarker(new MarkerOptions().position(Vege_5_Smakow).title("Restauracja Vege 5 Smaków"));

        LatLng Bistro_Jaglana = new LatLng(53.432391512589945, 14.539750610554778);
        mMap.addMarker(new MarkerOptions().position(Bistro_Jaglana).title("Restauracja Bistro Jaglana"));

        LatLng Jak_Malina = new LatLng(53.42994367878903, 14.552270906651733);
        mMap.addMarker(new MarkerOptions().position(Jak_Malina).title("Restauracja Jak Malina"));

        LatLng Prasad = new LatLng(53.426558711940075, 14.546060720146368);
        mMap.addMarker(new MarkerOptions().position(Prasad).title("Restauracja Prasad"));

        LatLng Marshal_Food = new LatLng(53.4312143651632, 14.545277607861477);
        mMap.addMarker(new MarkerOptions().position(Marshal_Food).title("Restauracja Marshal Food"));

        LatLng Kisiel = new LatLng(53.433262624872135, 14.542901766167839);
        mMap.addMarker(new MarkerOptions().position(Kisiel).title("Restauracja Kisiel"));


        //Shops and markets
        LatLng Veganada = new LatLng(53.42581572445214, 14.545379790039979);
        mMap.addMarker(new MarkerOptions().position(Veganada).title("Sklep Veganada").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Organic_Garden = new LatLng(53.42937599119217, 14.550314029435857);
        mMap.addMarker(new MarkerOptions().position(Organic_Garden).title("Sklep Organic Garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Samo_Zdrowie = new LatLng(53.443122988196265, 14.548989411644637);
        mMap.addMarker(new MarkerOptions().position(Samo_Zdrowie).title("Sklep Samo Zdrowie").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Eco_life = new LatLng(53.427352586973754, 14.552398723913907);
        mMap.addMarker(new MarkerOptions().position(Eco_life).title("Sklep Eco life").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Dary_Zdrowia = new LatLng(53.427434183289805, 14.534490285260244);
        mMap.addMarker(new MarkerOptions().position(Dary_Zdrowia).title("Sklep Dary Zdrowia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Zielony_Kram = new LatLng(53.443134599091806, 14.51196523802903);
        mMap.addMarker(new MarkerOptions().position(Zielony_Kram).title("Sklep Zielony Kram").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Rynek_Pogodno = new LatLng(53.44213158955559, 14.511953361032472);
        mMap.addMarker(new MarkerOptions().position(Rynek_Pogodno).title("Rynek Pogodno").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Targowisko_Turzyn = new LatLng(53.424421812491715, 14.531013302534502);
        mMap.addMarker(new MarkerOptions().position(Targowisko_Turzyn).title("Targowisko Turzyn").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Targowisko_Manhattan = new LatLng(53.44313260939884, 14.548983782600095);
        mMap.addMarker(new MarkerOptions().position(Targowisko_Manhattan).title("Targowisko Manhattan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Rynek_Kilińskiego = new LatLng(53.44156617996003, 14.54792460018687);
        mMap.addMarker(new MarkerOptions().position(Rynek_Kilińskiego).title("Rynek Kilińskiego").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        //Cosmetics
        LatLng Kosmetyki_Naturalne = new LatLng(53.42731804416209, 14.534609534287338);
        mMap.addMarker(new MarkerOptions().position(Kosmetyki_Naturalne).title("Kosmetyki Naturalne Dary Zdrowia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        LatLng Ministerstwo_DM = new LatLng(53.44639088696121, 14.543592888331466);
        mMap.addMarker(new MarkerOptions().position(Ministerstwo_DM).title("Ministerstwo Dobrego Mydła").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        LatLng EkoSzuflada = new LatLng(53.42731804416209, 14.534609534287338);
        mMap.addMarker(new MarkerOptions().position(EkoSzuflada).title("EkoSzuflada Kosmetyki Naturalne").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        }
}