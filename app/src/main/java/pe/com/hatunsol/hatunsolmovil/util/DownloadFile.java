package pe.com.hatunsol.hatunsolmovil.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import androidx.core.content.FileProvider;
import pe.com.hatunsol.hatunsolmovil.BuildConfig;

public class DownloadFile extends AsyncTask<String, Void, Void> {
    private Context context;

    public DownloadFile(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... strings) {
        String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
        String fileName = strings[1];  // -> maven.pdf
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File folder = context.getCacheDir();
        FileCache.clearCache(folder);
        folder = new File(extStorageDirectory, "Hatunsol");
        folder.mkdir();

        File pdfFile = new File(folder, fileName);

        try {
            pdfFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileDownloader.downloadFile(fileUrl, pdfFile);

        //Abre el Archivo

        Uri path ;

        String MY_PROVIDER = BuildConfig.APPLICATION_ID + ".FileProvider";

        if (Build.VERSION.SDK_INT >= 24)
            path = FileProvider.getUriForFile(context,   MY_PROVIDER , pdfFile);
        else
            path = Uri.fromFile(pdfFile);

        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        String x = path.getLastPathSegment();
        String formato = path.getLastPathSegment().substring(path.getLastPathSegment().lastIndexOf("."));
        if (formato.equals(".pdf")) {
            pdfIntent.setDataAndType(path, "application/pdf");
        } else {
            pdfIntent.setDataAndType(path, "image/*");
        }
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            context.startActivity(pdfIntent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return null;
    }
}
