package com.example.lab4;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    String drawableName = "ic_logo_00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setLogo(View view) {
        Intent intent = new Intent(getApplicationContext(), LogoSelectorActivity.class);
        startActivityForResult(intent, 0);
    }

    public void openInGoogleMaps (View view) {

        EditText teamPostalCode = findViewById(R.id.postalCodeId);

        Uri gmmIntentUri = Uri.parse("https://maps.google.com/maps?q=" + teamPostalCode.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void submit (View view) {
        EditText teamNameView = findViewById(R.id.teamNameViewId);
        EditText postalCodeView = findViewById(R.id.postalCodeId);

        String teamName = teamNameView.getText().toString();
        String postalCode = postalCodeView.getText().toString();

        Team team = new Team(teamName, postalCode, drawableName);

        Intent intent = new Intent(getApplicationContext(), ConfirmationActivity.class);
        intent.putExtra("teamInfo", team);
        startActivity(intent);
    }

    public void setTeamIcon(View view){
        Intent returnIntent = new Intent();

        ImageView selectedImage = (ImageView) view;

        returnIntent.putExtra("ImageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        ImageView logoImage = findViewById(R.id.logoImage);

        drawableName = "ic_logo_00";
        int imageID = data.getIntExtra("imageID", R.id.teamid00);

        if (imageID == R.id.teamid00) {
            drawableName = "ic_logo_00";
        } else if (imageID == R.id.teamid01) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.teamid02) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.teamid03) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.teamid04) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.teamid05) {
            drawableName = "ic_logo_05";
        } else {
            drawableName = "ic_logo_00";
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        logoImage.setImageResource(resID);

    }
}