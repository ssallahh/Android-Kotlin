import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insa.gamelist.GameAdapter
import com.insa.gamelist.R
import com.insa.gamelist.databinding.FragmentListBinding
import com.insa.gamelist.utils.DataManager

class ListFragment : Fragment() {
    private lateinit var binding : FragmentListBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        DataManager.readFile(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var gamesList = DataManager.games

        val adapter = GameAdapter(gamesList) { gameID ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(gameID)
            navController.navigate(action)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        navController = findNavController()
    }
}
