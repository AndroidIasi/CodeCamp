package ro.androidiasi.codecamp.codecamperdetails;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import ro.androidiasi.codecamp.R;
import ro.androidiasi.codecamp.internal.model.Codecamper;

/**
 * Created by andrei on 20/04/16.
 */
@EFragment
public class CodecamperDetailsFragment extends DialogFragment implements CodecamperDetailsContract.View{

    @FragmentArg Codecamper mCodecamper;

    @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String sanitizedDescription = mCodecamper.getDescription().replaceAll("<[^>]*>", "");
        return builder.setTitle(mCodecamper.getFullName())
                .setMessage(sanitizedDescription)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
