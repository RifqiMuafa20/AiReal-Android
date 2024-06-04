package Capstone.tim.aireal.detailproduct

import Capstone.tim.aireal.R
import Capstone.tim.aireal.databinding.ActivityDetailProductBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smarteist.autoimageslider.SliderView

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    private var url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png"
    private var url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp"
    private var url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sliderDataArrayList = ArrayList<SliderData>()
        val sliderView = findViewById<SliderView>(R.id.slider)

        sliderDataArrayList.add(SliderData(url1))
        sliderDataArrayList.add(SliderData(url2))
        sliderDataArrayList.add(SliderData(url3))

        val adapter = SliderAdapter(this, sliderDataArrayList)

        sliderView.setSliderAdapter(adapter)
    }
}