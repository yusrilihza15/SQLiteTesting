package id.ac.poliban.dts.indra.sqlitetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import id.ac.poliban.dts.indra.sqlitetesting.dao.impl.FriendDaoImplSQLite;
import id.ac.poliban.dts.indra.sqlitetesting.domain.Friend;

public class MainActivity extends AppCompatActivity {
    private List<Friend> data = new ArrayList<>();
    {
        data.add(new Friend("Vita Susanti","dago utara,bandung","081222222"));
        data.add(new Friend("indra","banjarmasin,pengambangan","0895613424989"));
        data.add(new Friend("udin","kampung melayu","085310101010"));
        data.add(new Friend("Salah","Tenggarong","085310101011"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar()!=null)getActionBar().setTitle("SQLite DEMO");

        EditText etId = findViewById(R.id.etId);

        Button btUpgrade = findViewById(R.id.btUpgrade);
        Button btInsert = findViewById(R.id.btInsert);
        Button btUpdate = findViewById(R.id.btUpdate);
        Button btDelete = findViewById(R.id.btDelete);
        Button btGetAFriend = findViewById(R.id.btGetAFriend);
        Button btGetAllFriends = findViewById(R.id.btGetAllFriend);

        FriendDaoImplSQLite db = new FriendDaoImplSQLite(this);

        btUpgrade.setOnClickListener(v -> {
            db.onUpgrade(db.getReadableDatabase(),1,2);
            Toast.makeText(this, "Upgrade Sukses", Toast.LENGTH_SHORT).show();
        });

        btInsert.setOnClickListener(v -> {
            data.forEach(o-> db.insert(o));
            Toast.makeText(this, "insert ok", Toast.LENGTH_SHORT).show();
        });

        btGetAllFriends.setOnClickListener(v -> {
            db.getAllFriends().forEach(o-> System.out.println(o));
            Toast.makeText(this, "Showing data ok,check in run monitor!", Toast.LENGTH_SHORT).show();
        });

        btUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            db.update(new Friend(id,"xxx","xxx","xxx"));
            Toast.makeText(this, "update sukses", Toast.LENGTH_SHORT).show();
        });

        btDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            db.delete(id);
            Toast.makeText(this, "delete sukses,check in run monitor!", Toast.LENGTH_SHORT).show();
        });

        btGetAFriend.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            Friend f = db.getAFriendById(id);
            Toast.makeText(this, "dapat temen sukses,check in run monitor", Toast.LENGTH_SHORT).show();
            System.out.println(f);
        });


    }
}
