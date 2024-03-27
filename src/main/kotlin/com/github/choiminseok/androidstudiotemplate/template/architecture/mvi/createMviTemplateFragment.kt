package com.github.choiminseok.androidstudiotemplate.template.architecture.mvi

fun createMviTemplateFragment(
    packageName: String,
    screenName: String,
) = """
package $packageName

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rainist.banksalad2.architecture.ComposeViewController
import com.rainist.banksalad2.architecture.SideEffect
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.Composable
import javax.inject.Inject

@AndroidEntryPoint
class ${screenName}Fragment : BaseFragment(), ComposeViewController<${screenName}UiState>, {

    override val viewModel by viewModels<${screenName}ViewModel>()

   
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return setContentWithState()
    }
    
    @Composable
    override fun OnRender(state: ${screenName}UiState) {
        //TODO()
    }
    
    override fun onReceiveSideEffect(effect: SideEffect) {
        // TODO()   
    }
    
    

}
    
""".trimIndent()