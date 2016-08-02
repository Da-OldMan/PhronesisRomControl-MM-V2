package com.wubydax.romcontrol.v2.prefs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wubydax.romcontrol.v2.R;
import com.wubydax.romcontrol.v2.utils.Utils;

/*      Created by Roberto Mariani and Anna Berkovitch, 28/07/2016
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

public class GlobalRestorePreference extends DialogPreference {
    private final boolean mIsRebootRequired, mIsSilent;
    private final String mPackageToKill;
    private final String[] mTitles, mKeys;
    private final int[] mValues;
    public GlobalRestorePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GlobalRestorePreference);
        mTitles = context.getResources().getStringArray(typedArray.getResourceId(R.styleable.GlobalRestorePreference_titlesList, -1));
        mKeys = context.getResources().getStringArray(typedArray.getResourceId(R.styleable.GlobalRestorePreference_keysList, -1));
        mValues = context.getResources().getIntArray(typedArray.getResourceId(R.styleable.GlobalRestorePreference_valuesList, -1));
        typedArray.recycle();
        TypedArray generalTypedArray = context.obtainStyledAttributes(attrs, R.styleable.Preference);
        mIsRebootRequired = generalTypedArray.getBoolean(R.styleable.Preference_rebootDevice, false);
        mPackageToKill = generalTypedArray.getString(R.styleable.Preference_packageNameToKill);
        mIsSilent = generalTypedArray.getBoolean(R.styleable.Preference_isSilent, true);
        generalTypedArray.recycle();
        setDialogLayoutResource(R.layout.global_restore_preference_dialog_layout);
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        StringBuilder stringBuilder = new StringBuilder();
        int length = mTitles.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(mTitles[i]);
            if(i != length - 1) {
                stringBuilder.append("\n");
            }
        }
        ((TextView) view.findViewById(R.id.restoreItems)).setText(stringBuilder.toString());
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        super.onClick(dialog, which);
        if(which == AlertDialog.BUTTON_POSITIVE) {
            int length = mKeys.length;
            for (int i = 0; i < length ; i++) {
                Settings.System.putInt(getContext().getContentResolver(), mKeys[i], mValues[i]);
                ColorPickerPreference colorPickerPreference = (ColorPickerPreference) findPreferenceInHierarchy(mKeys[i]);
                if(colorPickerPreference != null) {
                    colorPickerPreference.setColor(mValues[i]);
                }
            }
            if (mIsRebootRequired) {
                Utils.showRebootRequiredDialog(getContext());
            } else {
                if (mPackageToKill != null) {
                    if (Utils.isPackageInstalled(mPackageToKill)) {
                        if (mIsSilent) {
                            Utils.killPackage(mPackageToKill);
                        } else {
                            Utils.showKillPackageDialog(mPackageToKill, getContext());
                        }
                    }
                }
            }
        }
    }
}
