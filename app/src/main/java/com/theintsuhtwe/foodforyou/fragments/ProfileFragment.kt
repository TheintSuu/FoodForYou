package com.theintsuhtwe.foodforyou.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProviders
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.UserVO
import com.theintsuhtwe.foodforyou.mvp.presenters.ProfilePresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.ProfilePresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.ProfileView
import com.theintsuhtwe.foodforyou.utils.loadImage
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment(), ProfileView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: ProfilePresenter
    private var mBitmap: Bitmap? =null



       val IMAGE_REQUEST = 1111



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       setUpPresenter()

        setUpListener()

        mPresenter.onUiReady(this)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListener(){
        btnSave.setOnClickListener {
            mBitmap?.let {
                mPresenter.updateUserProfile(bitmap = it)
            } ?: kotlin.run {

            }
        }

        btnEditProfile.setOnClickListener {
            mPresenter.onTapUpdateProfile()
        }
    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                IMAGE_REQUEST
        )
    }

    override fun displayUserProfile(user: UserVO) {
        activity?.let { user.image?.let { it1 -> loadImage(it, it1, roundedCornerImageView) } }

        etProfileEmail.text = user.email

        etProfileName.text = user.name
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data
            try {

                filePath?.let {uri ->
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source? = activity?.contentResolver?.let { it1 -> ImageDecoder.createSource(it1, uri) }
                        val bitmap = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                        mBitmap = bitmap
                        activity?.let { it1 -> loadImage(it1, uri.toString(), roundedCornerImageView) }
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, uri
                        )
                        mBitmap =  bitmap
                        activity?.let { it1 -> loadImage(it1, uri.toString(), roundedCornerImageView) }
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}