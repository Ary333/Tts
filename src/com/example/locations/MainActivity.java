package com.example.locations;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	LinearLayout newLocLinear, locLinearList, buttonsLinear, rootLinear;
	TextView txtTitle;
	View view;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootLinear = (LinearLayout) findViewById(R.id.rootlinear);
		newLocLinear = (LinearLayout) findViewById(R.id.newLocLinear);
		LayoutInflater inflater = LayoutInflater.from(this);
 
		LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

		ScrollView sv = new ScrollView(this);
		rootLinear.addView(sv);
		sv.setLayoutParams(linLayoutParam);

		locLinearList = new LinearLayout(this);

		locLinearList.setLayoutParams(linLayoutParam);
		locLinearList.setOrientation(LinearLayout.VERTICAL);

		sv.addView(locLinearList);
 
		for (int i = 0; i < 10; i++) {

			view = inflater.inflate(R.layout.location_row, null);
			txtTitle = (TextView) view.findViewById(R.id.text);
			final ImageView cb = (ImageView) view.findViewById(R.id.checkAdd);
			final Button button = (Button) view.findViewById(R.id.editBtn);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
				}
			});
		
			buttonsLinear = (LinearLayout) view
					.findViewById(R.id.buttonsLinear);
 
			cb.setTag(i);
			locLinearList.addView(view);
			view.setTag(i);
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					String showallPrompt = "";
					int childCount = locLinearList.getChildCount();
					showallPrompt += "childCount: " + childCount + "\n\n";

					for (int c = 0; c < childCount; c++) {

						View childView = locLinearList.getChildAt(c);

						TextView childTextView = (TextView) (childView
								.findViewById(R.id.text));

						LinearLayout childButtonsLinear = (LinearLayout) (childView
								.findViewById(R.id.buttonsLinear));

						ImageView childRb = (ImageView) (childView
								.findViewById(R.id.checkAdd));

						String childTextViewText = (String) (childTextView
								.getText());

						showallPrompt += c + ": " + childTextViewText + "\n";

						System.out.println("sh " + showallPrompt);

						if (Integer.parseInt(v.getTag().toString()) == c) {

							if (childButtonsLinear.isShown()) {
								childButtonsLinear.setVisibility(View.GONE);
								childRb.setImageResource(R.drawable.unchecked);
							} else {
								childButtonsLinear.setVisibility(View.VISIBLE);
								childRb.setImageResource(R.drawable.checked);
							}

							System.out
									.println(" checked  " + childTextViewText);

						} else {

							childButtonsLinear.setVisibility(View.GONE);
							childRb.setImageResource(R.drawable.unchecked);
						}

					}
				}
			});
		}

		newLocLinear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


			}
		});
	}
}