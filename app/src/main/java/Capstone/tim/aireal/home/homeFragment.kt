package Capstone.tim.aireal.home

import Capstone.tim.aireal.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class homeFragment : Fragment() {
    private lateinit var rvCategories: RecyclerView
    private val list = ArrayList<Categories>()

    companion object {
        fun newInstance() = homeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        rvCategories = requireView().findViewById(R.id.rv_category)
        rvCategories.setHasFixedSize(true)
        list.addAll(getListCategories())
        showRecyclerList()
    }

    private fun getListCategories(): ArrayList<Categories> {
        val dataName = resources.getStringArray(R.array.product_categories)
        val dataPhoto = resources.obtainTypedArray(R.array.image_categories)
        val listCategory = ArrayList<Categories>()
        for (i in dataName.indices) {
            val category = Categories(dataPhoto.getResourceId(i, -1), dataName[i])
            listCategory.add(category)
        }
        return listCategory
    }

    private fun showRecyclerList() {
        rvCategories.layoutManager = LinearLayoutManager(context)
        val listCategoryAdapter = ProductCategoriesAdapter(list)
        rvCategories.adapter = listCategoryAdapter

//        listCategoryAdapter.setOnItemClickCallback(object : ProductCategoriesAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Categories) {
//                val item = Categories(data.photo, data.name)
//                val intent = Intent(context, ExploreActivity::class.java)
//                intent.putExtra(ExploreActivity.EXTRA_ITEM, item)
//                startActivity(intent)
//            }
//        })
    }

}