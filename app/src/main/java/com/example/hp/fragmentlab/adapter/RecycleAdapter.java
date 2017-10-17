package com.example.hp.fragmentlab.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.hp.fragmentlab.ContactDetail;
import com.example.hp.fragmentlab.Events.MyEventData;
import com.example.hp.fragmentlab.MainActivity;
import com.example.hp.fragmentlab.R;
import com.example.hp.fragmentlab.model.MyContacts;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hp on 10/12/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<MyContacts> mList;
    private Context context;

    public RecycleAdapter(List<MyContacts> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_row, parent, false);

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(0)
                .playOn(holder.cardView);
        final MyContacts contacts = mList.get(position);
        holder.txtName.setText(contacts.getName());
        holder.txtPhone.setText(contacts.getPhoen());
        //   holder.img.setImageResource(contacts.getImgId());
        holder.circleImageView.setImageResource(contacts.getImgId());
        holder.btnDetailconstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  EventBus.getDefault().post(new MyEventData("This is My Event"));
                EventBus.getDefault().postSticky(new MyContacts(contacts.getName(), contacts.getPhoen(), contacts.getImgId()));
                Intent intent = new Intent(context, ContactDetail.class);
             /*   intent.putExtra("name",contacts.getName());
                intent.putExtra("phone" , contacts.getPhoen());
                */
                context.startActivity(intent);
            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cardView.setVisibility(View.GONE);

                //   Toast.makeText(context,"RRRRrrrrrrrrrrrrrrrrr" ,Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /*
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(callIntent);
                */
            }

        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtPhone;
        //  private Button btnDetails;
        //    private ImageView img;
        private CardView cardView;
        private ImageButton btnRemove;
        private ImageButton btnCall;
        private CircleImageView circleImageView;
        private ConstraintLayout btnDetailconstraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtPhone = (TextView) itemView.findViewById(R.id.txt_phone);
            //   btnDetails = (Button) itemView.findViewById(R.id.btn_details);
            //     img = (ImageView) itemView.findViewById(R.id.card_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            btnRemove = (ImageButton) itemView.findViewById(R.id.btn_remove);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.circle_image);
            btnDetailconstraintLayout = (ConstraintLayout) itemView.findViewById(R.id.btn_details);
            btnRemove = (ImageButton) itemView.findViewById(R.id.btn_call);
        }
    }
}
