package com.zyhp.restaurantmanagement.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.zyhp.restaurantmanagement.R;

/**
 * Created by Administrator on 2018/7/6.
 */

public class GetChoiceDialog {
    public interface  GetChoiceDialogInterface {
        void onClick(int which);
    }
    public static void getChoiceDialog(Context context,String title,String items[],final GetChoiceDialogInterface getChoiceDialogInterface) {


        AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        getChoiceDialogInterface.onClick(which);
                    }
                });

        dialog.create();
        dialog.show();

    }
}