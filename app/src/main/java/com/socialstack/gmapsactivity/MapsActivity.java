package com.socialstack.gmapsactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        t = findViewById(R.id.tool);
        setActionBar(t);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(31.2552, 75.7050);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in LPU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mapsmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mMap!=null){
            switch (item.getItemId()){
                case R.id.misat: mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;

                case R.id.mihyb:mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
                case R.id.minormal: mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case R.id.miter:mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;
                default: return super.onOptionsItemSelected(item);
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
