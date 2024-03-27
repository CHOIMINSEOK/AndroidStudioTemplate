package com.github.choiminseok.androidstudiotemplate.template.architecture.mvi

fun createMviTemplateActivity(
    packageName: String,
    screenName: String,
) = """
package $packageName
    
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.rainist.banksalad2.feature.common.BaseActivity
import com.rainist.banksalad2.architecture.ComposeViewController
import com.rainist.banksalad2.architecture.SideEffect
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class ${screenName}Activity : BaseActivity(), ComposeViewController<${screenName}UiState> {

    override val viewModel by viewModels<${screenName}ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentWithState()
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