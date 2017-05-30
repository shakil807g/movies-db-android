package fmrsabino.moviesdb.ui.explore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fmrsabino.moviesdb.R
import fmrsabino.moviesdb.data.remote.Network
import fmrsabino.moviesdb.injection.scope.ForView
import kotlinx.android.synthetic.main.explore_item.view.*
import timber.log.Timber
import javax.inject.Inject

@ForView
class TrendingTvAdapter @Inject constructor(val picasso: Picasso) : RecyclerView.Adapter<TrendingTvAdapter.ViewHolder>() {
    val items: MutableList<Network.TvSeries> = mutableListOf()
    var imageConfiguration: Network.ImageConfiguration? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.explore_item, parent, false))

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Network.TvSeries) {
            itemView.movie_title.text = item.name
            imageConfiguration?.let {
                picasso.load(it.secureBaseUrl + it.posterSizes?.get(4) + item.posterPath).into(itemView.movie_cover)
            }
        }
    }

    fun onNewConfiguration(imageConfiguration: Network.ImageConfiguration?) {
        this.imageConfiguration = imageConfiguration
        imageConfiguration?.let {
            Timber.d(it.posterSizes.toString())
            Timber.d(it.secureBaseUrl)
        }
    }

    fun onNewItems(newItems: List<Network.TvSeries>) {
        //TODO: Diff Util
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
