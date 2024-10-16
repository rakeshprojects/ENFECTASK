package com.example.taskenfc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskenfc.model.PostUser

class PostUserAdapter(private val postUserList: List<PostUser>) :
    RecyclerView.Adapter<PostUserAdapter.PostUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_user, parent, false)
        return PostUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostUserViewHolder, position: Int) {
        val postUser = postUserList[position]
        holder.bind(postUser)
    }

    override fun getItemCount(): Int = postUserList.size

    class PostUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        private val postBody: TextView = itemView.findViewById(R.id.postBody)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val userid: TextView = itemView.findViewById(R.id.id)
        private val lat: TextView = itemView.findViewById(R.id.txtLat)
        private val lng: TextView = itemView.findViewById(R.id.txtLng)

        fun bind(postUser: PostUser) {
            postTitle.text = postUser.post.title
            postBody.text = postUser.post.body
            userName.text = postUser.user.name
            userid.text = postUser.user.id.toString()
            lat.text = "Lat: "+postUser.user.address.geo.get("lat").asString
            lng.text = "Lng: "+postUser.user.address.geo.get("lng").asString
        }
    }
}