package ir.debook.debook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class sampleUpload extends Activity {
    Bitmap image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        Button camera = (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            image = (Bitmap) data.getExtras().get("data");
            sendImage();
        }
    }

    public void sendImage(){
        byte[] dataSet = null;
        try {
            String url = "http://172.16.136.229:8000/bookcore/api/book-images/";
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            MultipartEntity entity = new MultipartEntity();

            if (image != null) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                dataSet = bos.toByteArray();
                entity.addPart("img", new ByteArrayBody(dataSet, "image/jpeg", "nimaaa.jpg"));
            }
            // entity.addPart("category", new StringBody(categoryname,"text/plain",Charset.forName("UTF-8")));
            entity.addPart("category", new StringBody("nimaCat", "text/plain", Charset.forName("UTF-8")));
            entity.addPart("phone", new StringBody("nimaPhone", "text/plain", Charset.forName("UTF-8")));
            entity.addPart("email", new StringBody("nimaEmail", "text/plain", Charset.forName("UTF-8")));
            entity.addPart("source", new StringBody("1", "text/plain", Charset.forName("UTF-8")));

            httppost.setEntity(entity);
            HttpResponse resp = httpclient.execute(httppost);
            //HttpEntity resEntity = resp.getEntity();
            //String string = EntityUtils.toString(resEntity);
            Log.d("image", "############### -> onActivityResult: "+"image uploaded");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            Log.d("image", "############### -> onActivityResult: "+"image not uploaded");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("image", "############### -> onActivityResult: "+"image not uploaded");
        }
    }
}
