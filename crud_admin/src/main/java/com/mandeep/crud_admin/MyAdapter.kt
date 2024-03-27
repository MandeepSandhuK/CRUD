package com.mandeep.crud_admin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.core.FieldFilter.Operator
import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location
import java.util.jar.Attributes.Name

class MyAdapter(private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.Location.text = currentitem.location
        holder.Name.text = currentitem.name
        holder.Operator.text = currentitem.operator
        holder.Phone.text = currentitem.phone

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val Location : TextView = itemView.findViewById(R.id.Location)
        val Name : TextView = itemView.findViewById(R.id.Name)
        val Operator : TextView = itemView.findViewById(R.id.Operator)
val Phone : TextView = itemView.findViewById(R.id.Phone)

    }

}

