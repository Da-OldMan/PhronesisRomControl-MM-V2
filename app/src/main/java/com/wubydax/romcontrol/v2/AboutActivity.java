package com.wubydax.romcontrol.v2;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wubydax.romcontrol.v2.utils.Constants;

import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    private Integer[] mContactUsIds, mTeamIds, mCreditsIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()).getInt(Constants.THEME_PREF_KEY, getResources().getInteger(R.integer.default_theme)) == 0 ? R.style.AppTheme_NoActionBar : R.style.AppTheme_NoActionBar_Dark);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.aboutToolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpAboutItems();
        setUpTeamItems();
        setUpCreditsItems();
    }

    private void setUpCreditsItems() {

        String[] textItems = getResources().getStringArray(R.array.about_credits_names);
        mCreditsIds = new Integer[textItems.length];
        TypedArray typedArray = getResources().obtainTypedArray(R.array.about_credits_drawables);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aboutCreditsContainer);
        assert linearLayout != null;
        for (int i = 0; i < textItems.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.about_people_item, linearLayout, false);

            ((CircleImageView) itemView.findViewById(R.id.aboutPeopleIcon)).setImageResource(typedArray.getResourceId(i, -1));
            ((TextView) itemView.findViewById(R.id.aboutPeopleText)).setText(textItems[i]);
            int id = View.generateViewId();
            itemView.setId(id);
            mCreditsIds[i] = id;
            linearLayout.addView(itemView, i);
        }
        typedArray.recycle();
    }

    private void setUpTeamItems() {
        String[] textItems = getResources().getStringArray(R.array.about_team_names);
        mTeamIds = new Integer[textItems.length];
        TypedArray typedArray = getResources().obtainTypedArray(R.array.about_team_drawables);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aboutTeamContainer);
        assert linearLayout != null;
        for (int i = 0; i < textItems.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.about_people_item, linearLayout, false);
            ((CircleImageView) itemView.findViewById(R.id.aboutPeopleIcon)).setImageResource(typedArray.getResourceId(i, -1));
            ((TextView) itemView.findViewById(R.id.aboutPeopleText)).setText(textItems[i]);
            int id = View.generateViewId();
            itemView.setId(id);
            mTeamIds[i] = id;
            linearLayout.addView(itemView, i);
        }
        typedArray.recycle();

    }

    private void setUpAboutItems() {
        String[] textItems = getResources().getStringArray(R.array.about_contact_us_text);
        mContactUsIds = new Integer[textItems.length];
        TypedArray typedArray = getResources().obtainTypedArray(R.array.about_contact_us_drawables);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aboutContactUsContainer);
        assert linearLayout != null;
        for (int i = 0; i < textItems.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.about_contact_us_item, linearLayout, false);

            ((CircleImageView) itemView.findViewById(R.id.contactUsImage)).setImageResource(typedArray.getResourceId(i, -1));
            ((TextView) itemView.findViewById(R.id.contactUsText)).setText(textItems[i]);
            int id = View.generateViewId();
            itemView.setId(id);
            mContactUsIds[i] = id;
            linearLayout.addView(itemView, i);
        }
        typedArray.recycle();
    }

    public void onClick(View view) {
        Integer id = view.getId();
        List<String> linksList;
        String url = null;
        List contactIds = Arrays.asList(mContactUsIds);
        List teamIds = Arrays.asList(mTeamIds);
        List creditsIds = Arrays.asList(mCreditsIds);
        if (contactIds.contains(id)) {
            linksList = Arrays.asList(getResources().getStringArray(R.array.about_contact_us_links));
            url = linksList.get(contactIds.indexOf(id));
        } else if (teamIds.contains(id)) {
            linksList = Arrays.asList(getResources().getStringArray(R.array.about_team_links));
            url = linksList.get(teamIds.indexOf(id));
        } else if(creditsIds.contains(id)) {
            linksList = Arrays.asList(getResources().getStringArray(R.array.about_credits_links));
            url = linksList.get(creditsIds.indexOf(id));
        }
        if(url != null) {
            openUrl(url);
        } else {
            Toast.makeText(MyApp.getContext(), "Invalid URL", Toast.LENGTH_SHORT).show();
        }
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
