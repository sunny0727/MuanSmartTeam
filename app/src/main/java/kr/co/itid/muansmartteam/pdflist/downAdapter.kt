package kr.co.itid.muansmartteam.pdflist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.itid.muansmartteam.R


// test
class DownAdapter(private val context: Context) : RecyclerView.Adapter<DownAdapter.ViewHolder>() {


    var datas = mutableListOf<PdfFileData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownAdapter.ViewHolder {
//        TODO("Not yet implemented")
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_filename)
        private val imgPdf: ImageView = itemView.findViewById(R.id.img_rv_check)
        private val imgCheck: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: PdfFileData) {
            txtName.text = item.filename
//            Glide.with(itemView).load(item.img).into(imgPdf)
//            Glide.with(itemView).load(item.img).into(imgCheck)

        }
    }

    override fun onBindViewHolder(holder: DownAdapter.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
        holder.bind(datas[position])
    }


    override fun getItemCount(): Int = datas.size


}