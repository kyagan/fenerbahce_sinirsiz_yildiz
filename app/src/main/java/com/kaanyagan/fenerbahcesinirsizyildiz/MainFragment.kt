package com.kaanyagan.fenerbahcesinirsizyildiz

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kaanyagan.fenerbahcesinirsizyildiz.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var fragmentBinding : FragmentMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
        fragmentBinding = binding

        view.setBackgroundColor(Color.WHITE)

        var count = 5
        binding.addStarButton.setOnClickListener{
            if (count<15){
                count += 1
                val res = "s$count"
                binding.logo.setImageResource(resources.getIdentifier(res,"drawable",context?.packageName))
            }
            else{
                val action = MainFragmentDirections.actionMainFragmentToStarsFragment()
                Navigation.findNavController(it).navigate(action)

            }
        }
    }
}
