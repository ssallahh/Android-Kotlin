import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insa.gamelist.Game
import com.insa.gamelist.R
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.insa.gamelist.databinding.FragmentDetailBinding
import com.insa.gamelist.extensions.load
import com.insa.gamelist.utils.DataManager
import java.text.SimpleDateFormat
import java.util.Date

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedGame = DataManager.games[args.gameID.toInt()]
        val date = SimpleDateFormat("dd/MM/yyyy").format(Date(selectedGame.timestamp*1000))
        val consoleAdapter = ConsoleAdapter(selectedGame.console)

        binding.recyclerViewConsole.adapter = consoleAdapter
        binding.nameGame.text = selectedGame.title
        binding.dateGame.text = date
        binding.genreGame.text = "Genre: ${selectedGame.type}"
        binding.devGame.text = "Développeur: ${selectedGame.developer}"
        binding.editorGame.text = "Editeur: ${selectedGame.editor}"
        binding.descriptionGame.text = selectedGame.description
        binding.imageView.load(selectedGame.image)
    }
}
