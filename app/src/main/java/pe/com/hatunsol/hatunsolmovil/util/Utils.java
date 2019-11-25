package pe.com.hatunsol.hatunsolmovil.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Utils {
    public static String EncriptarPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String strEncPassword = "";
        byte[] data = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA1");
        byte[] resultado = sha.digest(data);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < resultado.length; i++)
            sb.append(String.format("%02x", resultado[i]));

        strEncPassword = sb.toString();
        return strEncPassword;
    }

    public static String getPath(Uri uri, Context ctx) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = ctx.getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public static Bitmap decodeFile(String filePath, Bitmap bitmap) {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 1920;//1024;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        bitmap = BitmapFactory.decodeFile(filePath, o2);
        return bitmap;

    }

    public static String createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/Hatunsol");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/Hatunsol/");
            wallpaperDirectory.mkdirs();
        }

        File file = new File(new File("/sdcard/Hatunsol/"), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 80, out);
            out.flush();
            out.close();
            return file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void galleryAddPic(String path, Context ctx) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(path);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        ctx.sendBroadcast(mediaScanIntent);
    }

    public static void ContenidoMayuscula(ConstraintLayout clDatos) {
        for (int i = 0; i < clDatos.getChildCount(); i++) {
            Object child = clDatos.getChildAt(i);
            if (child instanceof AppCompatEditText) {
                AppCompatEditText et = (AppCompatEditText) child;
                InputFilter[] editFilters = et.getFilters();
                InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                newFilters[editFilters.length] = new InputFilter.AllCaps();
                et.setFilters(newFilters);
            }else if (child instanceof MultiAutoCompleteTextView) {
                MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) child;
                InputFilter[] editFilters = multiAutoCompleteTextView.getFilters();
                InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                newFilters[editFilters.length] = new InputFilter.AllCaps();
                multiAutoCompleteTextView.setFilters(newFilters);
            }else if (child instanceof AutoCompleteTextView) {
                AutoCompleteTextView et = (AutoCompleteTextView) child;
                InputFilter[] editFilters = et.getFilters();
                InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                newFilters[editFilters.length] = new InputFilter.AllCaps();
                et.setFilters(newFilters);
            }else if (child instanceof EditText) {
                EditText edt = (EditText) child;
                InputFilter[] editFilters = edt.getFilters();
                InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                newFilters[editFilters.length] = new InputFilter.AllCaps();
                edt.setFilters(newFilters);
            }

            if (clDatos.getChildAt(i) instanceof ConstraintLayout) {
                ConstraintLayout ll = (ConstraintLayout) clDatos.getChildAt(i);

                for (int j = 0; j < ll.getChildCount(); j++) {
                    child = ll.getChildAt(j);
                    if (child instanceof AppCompatEditText) {
                        AppCompatEditText et = (AppCompatEditText) child;
                        InputFilter[] editFilters = et.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        et.setFilters(newFilters);
                    } else if (child instanceof AutoCompleteTextView) {
                        AutoCompleteTextView et = (AutoCompleteTextView) child;
                        InputFilter[] editFilters = et.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        et.setFilters(newFilters);
                    }else if (child instanceof EditText) {
                        EditText edt = (EditText) child;
                        InputFilter[] editFilters = edt.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        edt.setFilters(newFilters);
                    }else if (child instanceof MultiAutoCompleteTextView) {
                        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) child;
                        InputFilter[] editFilters = multiAutoCompleteTextView.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        multiAutoCompleteTextView.setFilters(newFilters);
                    }
                }
            }
        }
    }

    public static void ContenidoMayuscula(LinearLayout llDatos) {
        for (int i = 0; i < llDatos.getChildCount(); i++) {
            Object child = llDatos.getChildAt(i);
            if (child instanceof AppCompatEditText) {
                AppCompatEditText et = (AppCompatEditText) child;
                InputFilter[] editFilters = et.getFilters();
                InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                newFilters[editFilters.length] = new InputFilter.AllCaps();
                et.setFilters(newFilters);
            }

            if (llDatos.getChildAt(i) instanceof LinearLayout) {
                LinearLayout ll = (LinearLayout) llDatos.getChildAt(i);

                for (int j = 0; j < ll.getChildCount(); j++) {
                    child = ll.getChildAt(j);
                    if (child instanceof AppCompatEditText) {
                        AppCompatEditText et = (AppCompatEditText) child;
                        InputFilter[] editFilters = et.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        et.setFilters(newFilters);
                        // et.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                    } else if (child instanceof AutoCompleteTextView) {
                        AutoCompleteTextView et = (AutoCompleteTextView) child;
                        InputFilter[] editFilters = et.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        et.setFilters(newFilters);
                    } else if (child instanceof EditText) {
                        EditText edt = (EditText) child;
                        InputFilter[] editFilters = edt.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        edt.setFilters(newFilters);
                    }else if (child instanceof AutoCompleteTextView) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) child;
                        InputFilter[] editFilters = autoCompleteTextView.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        autoCompleteTextView.setFilters(newFilters);
                    }else if (child instanceof MultiAutoCompleteTextView) {
                        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) child;
                        InputFilter[] editFilters = multiAutoCompleteTextView.getFilters();
                        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
                        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
                        newFilters[editFilters.length] = new InputFilter.AllCaps();
                        multiAutoCompleteTextView.setFilters(newFilters);
                    }
                }
            }


        }
    }


}
