package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, Serializable {


    private static GoogleMap mMap;
    private Model model;
    final Context context = this;
    private static LatLng currentLatLng;
    private static MapsActivity mapsActivity = new MapsActivity();

    /**
     * This is the onCreate which obtains the view SupportMapFragment and get
     * notified when the map is ready to be used. This also initializes the
     * Map view.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        model = Model.getInstance();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        java.util.List<MarkerOptions> list =  model.getReportList();
        //GoogleMap gm = MapsActivity.getMap();
        LatLng latln = null;
        for (MarkerOptions mo : list) {
            mMap.addMarker(mo);
            latln = mo.getPosition();
        }
        LatLng ll = new LatLng(33.762909, -84.422675);
        if (latln == null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        } else {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latln));
        }
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){

            @Override
            public void onMapClick(LatLng latLng) {
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                System.out.println(latLng + " latlng when being set");
                //set currLatLng
                currentLatLng = latLng;
                System.out.println(latLng + " latlng AFTER being set");
                System.out.println(currentLatLng + " current LatLng after being set");

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Would you like to add a water report at this location?");


                MarkerOptions markerOptions = new MarkerOptions();

                markerOptions.position(latLng);
                alertDialogBuilder
                        .setMessage("")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                Intent intent = new Intent(MapsActivity.this, SubmitReportActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // pan camera to position
                CameraUpdateFactory.newLatLng(latLng);

                // show it
                alertDialog.show();


            }
        });


    }

    /**
     *
     * @return map instance
     */
    public static GoogleMap getMap() {
        return mMap;
    }

    /**
     *
     * @return LatLng of current location
     */
    public static LatLng getLatLng() {
        System.out.println(currentLatLng + " latLng before passing it over");
        return currentLatLng;
    }

    /**
     *
     */
    public static MapsActivity getMapActivity() { return mapsActivity;}
}
