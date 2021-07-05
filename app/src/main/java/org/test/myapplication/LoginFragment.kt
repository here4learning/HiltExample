package org.test.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.view.*

@AndroidEntryPoint
class LoginFragment : Fragment(){

    private val viewModel by viewModels<AccountViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login,container, false)
        view.text_view_forgot_password.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.doAuthenticate("example@example.com","12345")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isLoginSuccess.observeForever {
           // context?.openActivity(DashboardActivity :: class.java)
        }
        viewModel.isLoginError.observeForever {
            //error
        }
    }

}