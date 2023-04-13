package alvin.si61.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    private EditText etNpm, etNama, etProdi;

    private Button btnTambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNpm = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        etProdi = findViewById(R.id.et_prodi);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npm, nama, prodi;

                npm = etNpm.getText().toString();
                nama = etNama.getText().toString();
                prodi = etProdi.getText().toString();


                if(nama.trim().equals("")){
                    etNpm.setError("NPM Tidak Boleh Kosong");
                }else if (npm.trim().equals("")){
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else if (prodi.trim().equals("")){
                    etProdi.setError("Prodi Tidak Boleh Kosong");
                }
                else {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eks = myDB.tambahData(npm,nama,prodi);
                    if (eks == -1){
                        Toast.makeText(TambahActivity.this, "Tambah Data Gagal", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(TambahActivity.this, "Tambah Data Sukses", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });



    }
}