package com.breakandmeet.android;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by adrien on 15/11/2015.
 */
public class GMapActivity extends Activity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //String ville = getIntent().getStringExtra("ville");
        LatLng lille = new LatLng(50.629249, 3.057256);
        LatLng wazemmes_QG = new LatLng(50.6252543, 3.04824719);
        LatLng lilleCentre_LPC = new LatLng(50.6383804, 3.0622038);
        LatLng lilleCentre_Dinette = new LatLng(50.6224694, 3.06093899);
        LatLng lilleCentre_C44 = new LatLng(50.6421635, 3.06627709);

        //map.setMyLocationEnabled(true);
        //System.out.println("|"+ville+"|");
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lille, 13));

        map.addMarker(new MarkerOptions().title("Quartier Gourmet").snippet("Jean Dupont \n Jacques Lambert").position(wazemmes_QG)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        map.addMarker(new MarkerOptions().title("La Petite Cour").snippet("Lille Centre").position(lilleCentre_LPC)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().title("La Dinette").snippet("Vieux Lille").position(lilleCentre_Dinette)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().title("Comptoir 44").snippet("Peuple Belge").position(lilleCentre_C44)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }
}
