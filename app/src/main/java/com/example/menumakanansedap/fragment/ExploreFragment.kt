package com.example.menumakanansedap.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menumakanansedap.DetailMovieActivity
import com.example.menumakanansedap.Movie
import com.example.menumakanansedap.MovieAdapter
import com.example.menumakanansedap.R


class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
//        adapter = MovieAdapter(movieArrayList)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.asampedas,
            R.drawable.gadogado,
            R.drawable.nasitumpeng,
            R.drawable.nasiuduk,
            R.drawable.pempek,
            R.drawable.rawon,
            R.drawable.rendang,
            R.drawable.satemadura,
            R.drawable.sotomedan,
            R.drawable.tempoyakpatin,

            )

        title = arrayOf(
            "Gulai Asam Pedas",
            "Gado-gado",
            "Nasi Tumpeng",
            "Nasi Uduk",
            "Pempek",
            "Rawon",
            "Rendang",
            "Sate Madura",
            "Soto Medan",
            "Tempoyak Patin",


            )

        descriptions = arrayOf(
            "Asam pedas merupakan kuah yang di dalamnya terdapat bumbu pedas dan asam yang dilengkapi dengan sayur-sayuran. Di Aceh, asam pedas sangat jarang menggunakan sayur, melainkan dipadukan dengan ikan tongkol yang disebut Asam Keueng.",
            "Kangkung, kacang panjang, pare, taoge, bayam, labu siam, mentimun, serta tahu dan tempe adalah sederet pilihan yang bisa kamu sajikan dalam piring gado-gado sayuran kamu. Meski begitu, kamu juga bisa menyertakan jenis sayuran lain ke dalam hidangan yang mirip dengan pecel ini.",
            "umpeng atau nasi tumpeng adalah panganan upacara adat masyarakat Jawa, Bali, Madura dan Sunda yang penyajian nasinya dibentuk kerucut dan ditata bersama dengan lauk-pauknya. Olahan nasi yang dipakai umumnya berupa nasi kuning, nasi putih biasa, atau nasi uduk.",
            "Nasi uduk adalah hidangan yang dibuat dari nasi putih yang diaron dan dikukus dengan santan, serta dibumbui dengan pala, kayu manis, jahe, daun serai dan merica. Hidangan ini kini adalah salah satu Hidangan Betawi yang populer.",
            "Pempek adalah makanan yang terbuat dari daging ikan yang digiling lembut yang dicampur tepung kanji atau tepung sagu, serta komposisi beberapa bahan lain seperti telur, bawang putih yang dihaluskan, penyedap rasa, dan garam.",
            "Rawon adalah masakan Indonesia berasal dari Ponorogo yang berupa sup daging berkuah hitam dengan campuran bumbu khas yang menggunakan kluwek. Rawon, Menyebar keluar Ponorogo karena Ponorogo memiliki peran Penting dari masa ke masa, hingga dikenal sebagai masakan khas Jawa Timur, masyarakat Jawa Tengah sebelah timur.",
            "Rendang atau randang dalam bahasa Minangkabau adalah hidangan berbahan dasar daging yang dihasilkan dari proses memasak suhu rendah dalam waktu lama dengan menggunakan aneka rempah-rempah dan santan. Proses memasaknya memakan waktu berjam-jam hingga yang tinggal hanyalah potongan daging berwarna hitam pekat dan dedak.",
            "Sate Madura adalah sate yang memiliki bumbu khas Madura. Sate Madura biasanya terbuat dari ayam. Madura selain terkenal sebagai pulau garam, juga terkenal dengan satenya. Sate madura sudah terkenal di seluruh Nusantara.",
            "Soto Medan adalah masakan Indonesia khas Sumatra Utara. Bahan untuk membuat Soto Medan adalah santan, daun jeruk limau, bunga lawang, lengkuas, serai, bawang merah, bawang putih, ketumbar, jintan, lada hitam, jahe, kunyit, gula dan garam sebagai bumbu.",
            "Masakan berbahan baku ikan merupakan makanan andalan Jambi. Gulai atau gangan Tempoyak Patin merupakan salah satu masakan khas Jambi yang memanfaatkan ikan patin sebagai bahan baku utamanya. Cita rasa gulai menjadi khas karena dicampur tempoyak, yakni buah durian yang difermentasikan.",

            )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}