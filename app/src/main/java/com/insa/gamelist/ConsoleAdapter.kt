import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.insa.gamelist.R
import com.insa.gamelist.databinding.ConsoleItemBinding
import com.insa.gamelist.extensions.load
import com.squareup.picasso.Picasso

class ConsoleAdapter(private val consoles: List<String>) :
    RecyclerView.Adapter<ConsoleAdapter.ConsoleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsoleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ConsoleItemBinding.inflate(inflater, parent, false)
        return ConsoleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConsoleViewHolder, position: Int) {
        val console = consoles[position]
        holder.bind(console)
    }

    override fun getItemCount(): Int {
        return consoles.size
    }

    private fun getIconUrl(console: String, context: Context): String {
        return when (console) {
            "PS4" -> context.getString(R.string.ic_ps4_url)
            "PS5" -> context.getString(R.string.ic_ps5_url)
            "Xbox One" -> context.getString(R.string.ic_xbox_one_url)
            "Xbox X|S" -> context.getString(R.string.ic_xbox_series_url)
            "PC" -> context.getString(R.string.ic_pc_url)
            "Switch" -> context.getString(R.string.ic_switch_url)
            else -> context.getString(R.string.ic_pc_url)
        }
    }

    inner class ConsoleViewHolder(private val binding: ConsoleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(console: String) {
            // Charger l'icône de la console en utilisant Picasso
            val iconUrl = getIconUrl(console, binding.root.context)
            Picasso.get().load(iconUrl).into(binding.consoleIcon)
        }
    }
}
