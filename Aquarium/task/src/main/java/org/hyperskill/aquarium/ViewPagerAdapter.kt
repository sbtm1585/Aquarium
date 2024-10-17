package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ViewPagerAdapter(
    private var image: List<String>, private val name: List<String>, private val description: List<String>
) : RecyclerView.Adapter<PageViewHolder>() {

    override fun getItemCount() = image.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder =
        PageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_item, parent, false))

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.itemView.run {
            Picasso.get()
                .load(image[position])
                .resize(900, 600)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(findViewById<ImageView>(R.id.image_view))

            findViewById<TextView>(R.id.tv_name).text = name[position]
            findViewById<TextView>(R.id.tv_description).text = description[position]
        }
    }
}

class PageViewHolder(iV: View) : RecyclerView.ViewHolder(iV)

