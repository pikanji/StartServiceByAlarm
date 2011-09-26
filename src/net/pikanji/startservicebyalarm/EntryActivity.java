
package net.pikanji.startservicebyalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class EntryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainService.class);
        startService(intent);

        this.finish();
    }
}
