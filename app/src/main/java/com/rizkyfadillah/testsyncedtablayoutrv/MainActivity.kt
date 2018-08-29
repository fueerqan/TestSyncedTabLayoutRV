package com.rizkyfadillah.testsyncedtablayoutrv

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearSmoothScroller
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var usecaseAdapter: UsecaseAdapter

    private lateinit var datas: ArrayList<Visitable>

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var smoothScroller: LinearSmoothScroller

    private var currentScrollPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datas = arrayListOf()

        usecaseAdapter = UsecaseAdapter(datas)

        linearLayoutManager = LinearLayoutManager(this)

        smoothScroller = object : LinearSmoothScroller(this@MainActivity) {
            override fun getVerticalSnapPreference(): Int {
                return LinearSmoothScroller.SNAP_TO_START
            }
        }

        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = usecaseAdapter

        val tab1 = tablayout.newTab()
        tab1.text = "Tagihan"
        tablayout.addTab(tab1)

        val tab2 = tablayout.newTab()
        tab2.text = "Travel"
        tablayout.addTab(tab2)

        val tab3 = tablayout.newTab()
        tab3.text = "Keuangan"
        tablayout.addTab(tab3)

        val categoriesTagihan = arrayListOf<CategoryViewModel>()
        categoriesTagihan.add(CategoryViewModel("Pulsa", "https://ecs7.tokopedia.net/img/recharge/category/pulsa.png"))
        categoriesTagihan.add(CategoryViewModel("Pake Data", "https://ecs7.tokopedia.net/img/recharge/category/paket-data.png"))
        categoriesTagihan.add(CategoryViewModel("Listrik PLN", "https://ecs7.tokopedia.net/img/recharge/category/pln.png"))
        categoriesTagihan.add(CategoryViewModel("BPJS", "https://ecs7.tokopedia.net/img/recharge/category/bpjs.png"))
        categoriesTagihan.add(CategoryViewModel("Air PDAM", "https://ecs7.tokopedia.net/img/recharge/category/air.png"))
        categoriesTagihan.add(CategoryViewModel("Voucher Game", ""))
        categoriesTagihan.add(CategoryViewModel("Vouchers", ""))
        categoriesTagihan.add(CategoryViewModel("Telkom", ""))
        datas.add(UsecaseViewModel("Tagihan", categoriesTagihan))

        val categoriesTravel = arrayListOf<CategoryViewModel>()
        categoriesTravel.add(CategoryViewModel("Tiket KAI", ""))
        categoriesTravel.add(CategoryViewModel("Tiket Pesawat", ""))
        categoriesTravel.add(CategoryViewModel("Event", ""))
        categoriesTravel.add(CategoryViewModel("Hiburan", ""))
        datas.add(UsecaseViewModel("Travel", categoriesTravel))

        val categoriesKeuangan = arrayListOf<CategoryViewModel>()
        categoriesKeuangan.add(CategoryViewModel("Reksadana", ""))
        categoriesKeuangan.add(CategoryViewModel("Emas", ""))
        categoriesKeuangan.add(CategoryViewModel("Pinjam", ""))
        datas.add(UsecaseViewModel("Keuangan", categoriesKeuangan))

        usecaseAdapter.notifyDataSetChanged()

        println("coba coba")

        var oldScrollPosition = 0

        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

//                Log.v("MainActivity","Scroll position: " + linearLayoutManager.findFirstCompletelyVisibleItemPosition())

//                tablayout.getTabAt(linearLayoutManager.findFirstVisibleItemPosition())?.select()

//                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//                    tablayout.getTabAt(linearLayoutManager.findFirstVisibleItemPosition())?.select()
//                } else if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    tablayout.getTabAt(linearLayoutManager.findFirstVisibleItemPosition())?.select()
//                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                text_position.text = "scroll position ${linearLayoutManager.findFirstVisibleItemPosition()}"

                currentScrollPosition = linearLayoutManager.findFirstVisibleItemPosition()
                if (oldScrollPosition != currentScrollPosition) {
                    tablayout.getTabAt(linearLayoutManager.findFirstVisibleItemPosition())?.select()
                    oldScrollPosition = currentScrollPosition
                }

//                text_position.text = "scroll position ${linearLayoutManager.findFirstVisibleItemPosition()}"

//                Log.e("MainActivity", "scroll position ${linearLayoutManager.findFirstVisibleItemPosition()}")
//                Toast.makeText(this@MainActivity, "scroll position ${linearLayoutManager.findFirstVisibleItemPosition()}", Toast.LENGTH_SHORT).show()
//                tablayout.getTabAt(linearLayoutManager.findFirstVisibleItemPosition())?.select()
            }

        })

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                for (data in datas) {
                    if (data is UsecaseViewModel) {
                        if (tab?.text?.equals(data.name)!!) {
                            if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == currentScrollPosition) {
                                smoothScroller.targetPosition = datas.indexOf(data)

                                linearLayoutManager.startSmoothScroll(smoothScroller)
                            }
//                            recyclerview.smoothScrollToPosition(datas.indexOf(data))
//                            linearLayoutManager.scrollToPositionWithOffset(datas.indexOf(data), 0)
                        }
                    }
                }
            }
        })
    }
}
