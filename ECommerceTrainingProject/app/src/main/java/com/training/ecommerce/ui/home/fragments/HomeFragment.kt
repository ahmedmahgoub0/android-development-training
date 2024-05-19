package com.training.ecommerce.ui.home.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.training.ecommerce.databinding.FragmentHomeBinding
import com.training.ecommerce.ui.home.adapter.SalesAdAdapter
import com.training.ecommerce.ui.home.model.SalesAdUIModel
import com.training.ecommerce.utils.DepthPageTransformer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: HomeFragment")


        val salesAds = listOf(
            SalesAdUIModel(
                title = "Super Flash Sale",
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/android-e-commerce-training.appspot.com/o/temps%2Fbig-sale-megaphone-banner-isolated-on-white-background-vector-sale-banner-discount-offer-market-advertising-illustration-2BNBMX2.jpg?alt=media&token=62fa2e9c-e40b-4e13-b0cc-76435e4e1c54",
                endAt = System.currentTimeMillis() + 3600000 // 1 hour from now
            ), SalesAdUIModel(
                title = "Limited Offer",
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/android-e-commerce-training.appspot.com/o/temps%2FPromotion%20Image.png?alt=media&token=ae502706-b8f2-4e02-894f-6887d082d08a",
                endAt = System.currentTimeMillis() + 7200000 // 2 hours from now
            )
        )

        val adapter = SalesAdAdapter(salesAds)
        binding.saleAdsViewPager.adapter = adapter
        binding.saleAdsViewPager.setPageTransformer(DepthPageTransformer())

        lifecycleScope.launch {
            delay(5000)
            binding.saleAdsViewPager.currentItem = 1
        }
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}