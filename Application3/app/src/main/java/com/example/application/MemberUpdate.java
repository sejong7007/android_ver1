package com.example.application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MemberUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_update);
        final Context _this = MemberUpdate.this;
        final String[] arr = this.getIntent()
                .getStringExtra("spec")
                .split(",");
        final TextView nameTV = findViewById(R.id.name);
        final TextView emailTV = findViewById(R.id.changeEmail);
        final TextView phoneTV = findViewById(R.id.changePhone);
        final TextView addrTV = findViewById(R.id.changeAddress);
        nameTV.setText(arr[1]);
        emailTV.setText(arr[2]);
        phoneTV.setText(arr[3]);
        addrTV.setText(arr[4]);

        findViewById(R.id.confirmBtn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ItemUpdate query = new ItemUpdate(_this);
                        query.name = nameTV.getText().toString();
                        query.email = emailTV.getText().toString();
                        query.phone = phoneTV.getText().toString();
                        query.addr = addrTV.getText().toString();
                        query.seq = arr[0];
                        query.run();
                        int result = Integer.parseInt(arr[0])-1;
                        Intent intent = new Intent(_this, MemberDetail.class);
                        intent.putExtra("seq",result+"");
                        startActivity(intent);
                    }
                });

    }

    private class MemberUpdateQuery extends Main.QueryFactory{
        SQLiteOpenHelper helper;

        public MemberUpdateQuery(Context _this) {
            super(_this);
            helper = new Main.SQLiteHelper(_this);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getWritableDatabase();
        }
    }

    private class ItemUpdate extends MemberUpdateQuery{
        String seq, name, email, phone, addr;

        public ItemUpdate(Context _this) {super(_this);}

        public void run(){
            String sql = String.format("UPDATE %s " +
                            "SET %s = '%s' , " +
                               " %s = '%s', " +
                               " %s = '%s', " +
                               "  %s = '%s' " +
                            "WHERE %s LIKE '%s'",
                            Main.MEMBERS,
                            Main.NAME, name,
                            Main.EMAIL, email,
                            Main.PHONE, phone,
                            Main.ADDR, addr,
                            Main.SEQ, seq);
            getDatabase().execSQL(sql);
            Log.d("UPDATE 쿼리","SUCCESS!~!!!!!");
        }
    }
}
